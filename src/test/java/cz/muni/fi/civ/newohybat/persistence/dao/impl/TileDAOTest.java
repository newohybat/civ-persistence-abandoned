package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.PlayerDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;

@RunWith(Arquillian.class)
public class TileDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Tile.class.getPackage())
        		.addClasses(Tile.class,TileDAO.class,TileDAOImpl.class)
        		.addClasses(City.class,CityDAO.class,CityDAOImpl.class)
        		.addClasses(Player.class,PlayerDAO.class,PlayerDAOImpl.class)
        		.addClasses(Terrain.class,TerrainDAO.class,TerrainDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Tile tile;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	TileDAO dao;
	@Inject
	TerrainDAO terDao;
	@Inject
	CityDAO cDao;
	@Inject
	PlayerDAO pDao;
	
	@Before
	public void preparePersistenceTest(){
	    startTransaction();
	}

	@After
	public void commitTransaction(){
	    try {
			utx.commit();
			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startTransaction() {
	    try {
			utx.begin();
			em.joinTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	@Test
    public void testCreate()
    {
    	tile = this.getTile();
    	tile.setOwnedBy(getCity());
    	dao.create(tile);
        assertNotNull(tile.getId());
        commitTransaction();
        startTransaction();
        Tile next = dao.getById(tile.getId());
        assertNotNull(next);
        assertNotNull(next.getOwnedBy());
        City c = cDao.getById(next.getOwnedBy().getId());
        assertTrue(c.getManagedTiles().contains(next));
    }
	
	@Test
	public void testGetById(){
		tile = this.getTile();
		dao.create(tile);
		Long id = tile.getId();
		
		Tile fromDB = dao.getById(id);
		
		assertEquals(tile,fromDB);
	}
	
	@Test
	public void testDelete(){
		tile = this.getTile();
		dao.create(tile);
		Long id = tile.getId();
		
		dao.delete(tile);
		
		Tile fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		tile = this.getTile();
		dao.create(tile);
		
		Terrain t = getTerrain();
		tile.setTerrain(t);
		Long id = tile.getId();
		
		Tile check = dao.getById(id);
		
		assertEquals(t, check.getTerrain());
	}
	
	@Test
	public void testGetAll(){
		tile = this.getTile();
		dao.create(tile);
		Tile another = this.getTile();
		dao.create(another);
		assertTrue(dao.getAll().contains(tile)&&dao.getAll().contains(another));
	}
    
    public Tile getTile(){
    	Tile t = new Tile();
    	t.setImprovements(new HashSet<TileImprovement>());
    	t.setPosX(2L);
    	t.setPosY(2L);
    	t.setUnits(new HashSet<Unit>());
    	t.setTerrain(getTerrain());
    	return t;
    }

    private City getCity(){
    	City c = new City();
    	Tile t = getTile();
    	dao.create(t);
    	c.setCityCentre(t);
    	c.setWeLoveDay(true);
    	c.setHomeUnits(new HashSet<Unit>());
    	c.setImprovements(new HashSet<CityImprovement>());
    	c.setManagedTiles(new HashSet<Tile>());
    	c.setName("newark");
    	c.setOwner(getPlayer());
    	c.setSize(25);
    	c.setTradeRoutes(new HashSet<TradeRoute>());
    	cDao.create(c);
    	return c;
    }
    public Player getPlayer(){
    	Player p  = new Player();
    	p.setName("mighty Stew");
    	p.setAdvances(new HashSet<Advance>());
    	p.setCities(new HashSet<City>());
    	p.setUnits(new HashSet<Unit>());
    	pDao.create(p);
    	return p;
    }
    private Terrain getTerrain(){
		Terrain terrain = new Terrain();
		terrain.setIdent("grass"+no++);
		terDao.create(terrain);
		return terrain;
	}
    
	
}
