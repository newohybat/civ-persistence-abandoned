package cz.muni.fi.civ.newohybat.persistence.facade.iface;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Table;

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

public interface CivBackend {
	AdvanceDTO getAdvanceById(Long id);
	
	
	AdvanceDTO getAdvanceByIdent(String ident);
	
	
	Map<String, AdvanceDTO> getAdvances();
	
	
	void createPlayer(PlayerDTO player);
	
	void updatePlayer(PlayerDTO player);
	
	void deletePlayer(PlayerDTO player);
	
	PlayerDTO getPlayerById(Long id);
	
	List<PlayerDTO> getPlayers();
	
	void createCity(CityDTO city);
	
	void updateCity(CityDTO city);
	
	void deleteCity(CityDTO city);
	
	CityDTO getCityById(Long id);
	
	List<CityDTO> getCities();
	
	CityImprovementDTO getCityImprovementById(Long id);
	
	CityImprovementDTO getCityImprovementByIdent(String ident);
	
	Map<String,CityImprovementDTO> getCityImprovements();
	
	void createUnit(UnitDTO unit);
	
	void updateUnit(UnitDTO unit);
	
	void deleteUnit(UnitDTO unit);
	
	UnitDTO getUnitById(Long id);
	
	List<UnitDTO> getUnits();
	
	void update(TileDTO tile);
	
	TileDTO getTileById(Long id);
	
	Table<Long, Long, TileDTO> getTiles();
	
	List<TileDTO> getTilesAsList();
	
	TileImprovementDTO getTileImprovementById(Long id);
	
	TileImprovementDTO getTileImprovementByIdent(String ident);
	
	Map<String, TileImprovementDTO> getTileImprovements();
	
	Map<String,SpecialDTO> getSpecials();
	
	Map<String,TerrainDTO> getTerrains();
	
	Map<String,UnitTypeDTO> getUnitTypes();
	
}
