package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class TileImprovementDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(TileImprovement.class.getPackage())
        		.addClass(TileImprovement.class)
        		.addClass(TileImprovementDAO.class)
        		.addClass(TileImprovementDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private TileImprovement improvement;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	TileImprovementDAO dao;
    
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
    	improvement = this.getTileImprovement();
    	dao.create(improvement);
        assertNotNull(improvement.getId());
        
    }
	
	@Test
	public void testGetById(){
		improvement = this.getTileImprovement();
		dao.create(improvement);
		Long id = improvement.getId();
		
		TileImprovement imp2 = dao.getById(id);
		
		assertEquals(improvement,imp2);
	}
	
	@Test
	public void testDelete(){
		improvement = this.getTileImprovement();
		dao.create(improvement);
		Long id = improvement.getId();
		
		dao.delete(improvement);
		
		TileImprovement imp2 = dao.getById(id);
		
		assertNull(imp2);
	}
    
	@Test
	public void testUpdate(){
		improvement = this.getTileImprovement();
		dao.create(improvement);
		
		improvement.setIdent("newIdent"+no++);
		Long id = improvement.getId();
		commitTransaction();
		startTransaction();
		TileImprovement check = dao.getById(id);
		
		assertEquals(improvement.getIdent(), check.getIdent());
	}
	
	@Test
	public void testGetAll(){
		improvement = this.getTileImprovement();
		dao.create(improvement);
		TileImprovement another = this.getTileImprovement();
		dao.create(another);
		assertTrue(dao.getAll().contains(improvement)&&dao.getAll().contains(another));
	}
	
    public TileImprovement getTileImprovement(){
    	TileImprovement imp = new TileImprovement();
    	imp.setIdent("irrigation"+no++);
    	return imp;
    	
    }
	
}
