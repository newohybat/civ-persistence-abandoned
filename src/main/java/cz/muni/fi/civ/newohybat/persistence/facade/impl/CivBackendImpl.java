package cz.muni.fi.civ.newohybat.persistence.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.AdvanceDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.PlayerDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.SpecialDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TerrainDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitTypeDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.helpers.DTOHelper;
import cz.muni.fi.civ.newohybat.persistence.facade.iface.CivBackend;
import cz.muni.fi.civ.newohybat.persistence.services.iface.AdvanceService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityImprovementService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.PlayerService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.SpecialService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TerrainService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileImprovementService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitTypeService;

@Stateless
public class CivBackendImpl implements CivBackend {
	@Inject
	private AdvanceService advanceServ;
	@Inject
	private PlayerService playerServ;
	@Inject
	private CityService cityServ;
	@Inject
	private UnitService unitServ;
	@Inject
	private TileService tileServ;
	@Inject
	private CityImprovementService cityImpServ;
	@Inject
	private TileImprovementService tileImpServ;
	@Inject
	private UnitTypeService unitTypeServ;
	@Inject
	private SpecialService specialServ;
	@Inject
	private TerrainService terrainServ;

	public AdvanceDTO getAdvanceById(Long id) {
		return DTOHelper.getAdvanceDTO(advanceServ.getById(id));
	}

	public AdvanceDTO getAdvanceByIdent(String ident) {
		return DTOHelper.getAdvanceDTO(advanceServ.getByIdent(ident));
	}

	public Map<String, AdvanceDTO> getAdvances() {
		Map<String,AdvanceDTO> advances = new HashMap<String, AdvanceDTO>();
		for(Advance a:advanceServ.getAll()){
			advances.put(a.getIdent(), DTOHelper.getAdvanceDTO(a));
		}
		return advances;
	}

	public void createPlayer(PlayerDTO player) {
		playerServ.create(DTOHelper.getPlayer(player));
	}
	
	public void updatePlayer(PlayerDTO player) {
		playerServ.update(DTOHelper.getPlayer(player));
	}

	public void deletePlayer(PlayerDTO player) {
		playerServ.delete(DTOHelper.getPlayer(player));
	}

	public PlayerDTO getPlayerById(Long id) {
		return DTOHelper.getPlayerDTO(playerServ.getById(id));
	}

	public List<PlayerDTO> getPlayers() {
		List<PlayerDTO> players = new ArrayList<PlayerDTO>();
		for(Player p: playerServ.getAll()){
			players.add(DTOHelper.getPlayerDTO(p));
		}
		return players;
	}

	public void createCity(CityDTO city) {
		cityServ.create(DTOHelper.getCity(city));
	}

	public void updateCity(CityDTO city) {
		cityServ.update(DTOHelper.getCity(city));
	}

	public void deleteCity(CityDTO city) {
		cityServ.delete(DTOHelper.getCity(city));
	}

	public CityDTO getCityById(Long id) {
		return DTOHelper.getCityDTO(cityServ.getById(id));
	}

	public List<CityDTO> getCities() {
		List<CityDTO> cities = new ArrayList<CityDTO>();
		for(City c: cityServ.getAll()){
			cities.add(DTOHelper.getCityDTO(c));
		}
		return cities;
	}

	public void createUnit(UnitDTO unit) {
		unitServ.create(DTOHelper.getUnit(unit));
	}

	public void updateUnit(UnitDTO unit) {
		unitServ.update(DTOHelper.getUnit(unit));
	}

	public void deleteUnit(UnitDTO unit) {
		unitServ.delete(DTOHelper.getUnit(unit));
	}

	public UnitDTO getUnitById(Long id) {
		return DTOHelper.getUnitDTO(unitServ.getById(id));
	}

	public List<UnitDTO> getUnits() {
		List<UnitDTO> units = new ArrayList<UnitDTO>();
		for(Unit u: unitServ.getAll()){
			units.add(DTOHelper.getUnitDTO(u));
		}
		return units;
	}

	public void update(TileDTO tile) {
		tileServ.update(DTOHelper.getTile(tile));
	}

	public TileDTO getTileById(Long id) {
		return DTOHelper.getTileDTO(tileServ.getById(id));
	}

	public Table<Long, Long, TileDTO> getTiles() {
		Table<Long,Long,TileDTO> tiles = HashBasedTable.create();
		for(Tile t: tileServ.getAll()){
			tiles.put(t.getPosX(), t.getPosY(), DTOHelper.getTileDTO(t));
		}
		return tiles;
	}

	public List<TileDTO> getTilesAsList() {
		List<TileDTO> tiles = new ArrayList<TileDTO>();
		for(Tile t: tileServ.getAll()){
			tiles.add(DTOHelper.getTileDTO(t));
		}
		return tiles;
	}

	public Map<String, SpecialDTO> getSpecials() {
		Map<String,SpecialDTO> specials = new HashMap<String, SpecialDTO>();
		for(Special s:specialServ.getAll()){
			specials.put(s.getIdent(), DTOHelper.getSpecialDTO(s));
		}
		return specials;
	}

	public Map<String, TerrainDTO> getTerrains() {
		Map<String,TerrainDTO> terrains = new HashMap<String, TerrainDTO>();
		for(Terrain t:terrainServ.getAll()){
			terrains.put(t.getIdent(), DTOHelper.getTerrainDTO(t));
		}
		return terrains;
	}

	public Map<String, UnitTypeDTO> getUnitTypes() {
		Map<String,UnitTypeDTO> types = new HashMap<String, UnitTypeDTO>();
		for(UnitType type:unitTypeServ.getAll()){
			types.put(type.getIdent(), DTOHelper.getUnitTypeDTO(type));
		}
		return types;
	}

	public CityImprovementDTO getCityImprovementById(Long id) {
		return DTOHelper.getCityImprovementDTO(cityImpServ.getById(id));
	}

	public CityImprovementDTO getCityImprovementByIdent(String ident) {
		return DTOHelper.getCityImprovementDTO(cityImpServ.getByIdent(ident));
	}

	public Map<String, CityImprovementDTO> getCityImprovements() {
		Map<String,CityImprovementDTO> imps = new HashMap<String, CityImprovementDTO>();
		for(CityImprovement imp:cityImpServ.getAll()){
			imps.put(imp.getIdent(), DTOHelper.getCityImprovementDTO(imp));
		}
		return imps;
	}

	public TileImprovementDTO getTileImprovementById(Long id) {
		return DTOHelper.getTileImprovementDTO(tileImpServ.getById(id));
	}

	public TileImprovementDTO getTileImprovementByIdent(String ident) {
		return DTOHelper.getTileImprovementDTO(tileImpServ.getByIdent(ident));
	}

	public Map<String, TileImprovementDTO> getTileImprovements() {
		Map<String,TileImprovementDTO> imps = new HashMap<String, TileImprovementDTO>();
		for(TileImprovement imp:tileImpServ.getAll()){
			imps.put(imp.getIdent(), DTOHelper.getTileImprovementDTO(imp));
		}
		return imps;
	}
	
}
