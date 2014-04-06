package cz.muni.fi.civ.newohybat.persistence.facade.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.ActionDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.AdvanceDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.GovernmentDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.PlayerDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.SpecialDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TerrainDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TradeRouteDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitTypeDTO;

public class DTOHelper {
	
	public static City getCity(CityDTO cityDto){
		City c = new City();
		
		c.setOwner(DTOHelper.getPlayer(cityDto.getOwner()));
		
		c.setCityCentre(DTOHelper.getTile(cityDto.getCityCentre()));
		
		c.setId(cityDto.getId());
		
		c.setName(cityDto.getName());
		
		Set<CityImprovement> improvements = new HashSet<CityImprovement>();
		for(String ident:cityDto.getImprovements()){
			improvements.add(DTOHelper.getCityImprovement(ident));
		}
		c.setImprovements(improvements);
		
		Set<CityImprovement> enabledImprovements = new HashSet<CityImprovement>();
		for(String ident:cityDto.getEnabledImprovements()){
			enabledImprovements.add(DTOHelper.getCityImprovement(ident));
		}
		c.setEnabledImprovements(enabledImprovements);
		
		Set<UnitType> enabledUnitTypes = new HashSet<UnitType>();
		for(String ident:cityDto.getEnabledUnitTypes()){
			enabledUnitTypes.add(DTOHelper.getUnitType(ident));
		}
		c.setEnabledUnitTypes(enabledUnitTypes);
		
		Set<Unit> homeUnits = new HashSet<Unit>();
		for(Long u:cityDto.getHomeUnits()){
			homeUnits.add(DTOHelper.getUnit(u));
		}
		c.setHomeUnits(homeUnits);
		
		Set<TradeRoute> tradeRoutes = new HashSet<TradeRoute>();
		for(TradeRouteDTO route:cityDto.getTradeRoutes()){
			tradeRoutes.add(DTOHelper.getTradeRoute(route));
		}
		c.setTradeRoutes(tradeRoutes);
		
		Set<Tile> managedTiles = new HashSet<Tile>();
		for(Long tileId:cityDto.getManagedTiles()){
			managedTiles.add(DTOHelper.getTile(tileId));
		}
		c.setManagedTiles(managedTiles);
		
		c.setCurrentImprovement(DTOHelper.getCityImprovement(cityDto.getCurrentImprovement()));
		c.setCurrentUnit(DTOHelper.getUnitType(cityDto.getCurrentUnit()));
		c.setCorruption(cityDto.getCorruption());
		c.setDisorder(cityDto.getDisorder());
		c.setFoodConsumption(cityDto.getFoodConsumption());
		c.setFoodProduction(cityDto.getFoodProduction());
		c.setFoodStock(cityDto.getFoodStock());
		c.setFoodSurplus(cityDto.getFoodSurplus());
		c.setLuxuriesAmount(cityDto.getLuxuriesAmount());
		c.setLuxuriesSpent(cityDto.getLuxuriesSpent());
		c.setPeopleContent(cityDto.getPeopleContent());
		c.setPeopleEntertainers(cityDto.getPeopleEntertainers());
		c.setPeopleHappy(cityDto.getPeopleHappy());
		c.setPeopleScientists(cityDto.getPeopleScientists());
		c.setPeopleTaxmen(cityDto.getPeopleTaxmen());
		c.setPeopleUnhappy(cityDto.getPeopleUnhappy());
		c.setResearchAmount(cityDto.getResearchAmount());
		c.setResourcesConsumption(cityDto.getResourcesConsumption());
		c.setResourcesProduction(cityDto.getResourcesProduction());
		c.setResourcesSurplus(cityDto.getResourcesSurplus());
		c.setSize(cityDto.getSize());
		c.setTaxesAmount(cityDto.getTaxesAmount());
		c.setTradeProduction(cityDto.getTradeProduction());
		c.setWeLoveDay(cityDto.getWeLoveDay());
		c.setImprovementsUpkeep(cityDto.getImprovementsUpkeep());
		c.setUnitsSupport(cityDto.getUnitsSupport());
		c.setPollutionChance(cityDto.getPollutionChance());
		
		return c;
	}
	private static Unit getUnit(Long u) {
		Unit unit = new Unit();
		unit.setId(u);
		return unit;
	}
	private static Tile getTile(Long cityCentre) {
		Tile t = new Tile();
		t.setId(cityCentre);
		return t;
	}
	private static Player getPlayer(Long owner) {
		Player p = new Player();
		p.setId(owner);
		return p;
	}
	public static CityDTO getCityDTO(City city){
		CityDTO cityDto = new CityDTO();
		cityDto.setId(city.getId());
		cityDto.setName(city.getName());
		cityDto.setOwner(city.getOwner().getId());
		cityDto.setCityCentre(city.getCityCentre().getId());
		
		Set<Long> homeUnits = new HashSet<Long>();
		for(Unit u:city.getHomeUnits()){
			homeUnits.add(u.getId());
		}
		cityDto.setHomeUnits(homeUnits);
		
		Set<String>improvements = new HashSet<String>();
		for(CityImprovement imp:city.getImprovements()){
			improvements.add(imp.getIdent());
		}
		cityDto.setImprovements(improvements);
		
		Set<String>enabledImprovements = new HashSet<String>();
		for(CityImprovement imp:city.getEnabledImprovements()){
			enabledImprovements.add(imp.getIdent());
		}
		cityDto.setEnabledImprovements(enabledImprovements);
		
		Set<String> enabledUnitTypes = new HashSet<String>();
		for(UnitType u: city.getEnabledUnitTypes()){
			enabledUnitTypes.add(u.getIdent());
		}
		cityDto.setEnabledUnitTypes(enabledUnitTypes);
		
		Set<Long> managedTiles = new HashSet<Long>();
		for(Tile t: city.getManagedTiles()){
			managedTiles.add(t.getId());
		}
		cityDto.setManagedTiles(managedTiles);
		
		Set<TradeRouteDTO> tradeRoutes = new HashSet<TradeRouteDTO>();
		for(TradeRoute route:city.getTradeRoutes()){
			tradeRoutes.add(DTOHelper.getTradeRouteDTO(route));
		}
		cityDto.setTradeRoutes(tradeRoutes);
		
		cityDto.setCorruption(city.getCorruption());
		cityDto.setCurrentImprovement(city.getCurrentImprovement().getIdent());
		cityDto.setCurrentUnit(city.getCurrentUnit().getIdent());
		cityDto.setDisorder(city.getDisorder());
		cityDto.setFoodConsumption(city.getFoodConsumption());
		cityDto.setFoodProduction(city.getFoodProduction());
		cityDto.setFoodStock(city.getFoodStock());
		cityDto.setFoodSurplus(city.getFoodSurplus());
		cityDto.setLuxuriesAmount(city.getLuxuriesAmount());
		cityDto.setLuxuriesSpent(city.getLuxuriesSpent());
		cityDto.setPeopleContent(city.getPeopleContent());
		cityDto.setPeopleEntertainers(city.getPeopleEntertainers());
		cityDto.setPeopleHappy(city.getPeopleHappy());
		cityDto.setPeopleScientists(city.getPeopleScientists());
		cityDto.setPeopleTaxmen(city.getPeopleTaxmen());
		cityDto.setPeopleUnhappy(city.getPeopleUnhappy());
		cityDto.setResearchAmount(city.getResearchAmount());
		cityDto.setResourcesConsumption(city.getResourcesConsumption());
		cityDto.setResourcesProduction(city.getResourcesProduction());
		cityDto.setResourcesSurplus(city.getResourcesSurplus());
		cityDto.setSize(city.getSize());
		cityDto.setTaxesAmount(city.getTaxesAmount());
		cityDto.setTradeProduction(city.getTradeProduction());
		cityDto.setWeLoveDay(city.getWeLoveDay());
		cityDto.setImprovementsUpkeep(city.getImprovementsUpkeep());
		cityDto.setUnitsSupport(city.getUnitsSupport());
		cityDto.setPollutionChance(city.getPollutionChance());
		return cityDto;
	}
	
	public static Player getPlayer(PlayerDTO pDto) {
		Player p = new Player();
		p.setId(pDto.getId());
		p.setName(pDto.getName());
		
		if(pDto.getCurrentAdvance()!=null){
			p.setCurrentAdvance(DTOHelper.getAdvance(pDto.getCurrentAdvance()));
		}
		Set<Advance> advances = new HashSet<Advance>();
		for(String a: pDto.getAdvances()){
			advances.add(DTOHelper.getAdvance(a));
		}
		p.setAdvances(advances);
		
		Set<Advance> enabledAdvances = new HashSet<Advance>();
		for(String a: pDto.getEnabledAdvances()){
			enabledAdvances.add(DTOHelper.getAdvance(a));
		}
		p.setEnabledAdvances(enabledAdvances);
		
		Set<City> cities = new HashSet<City>();
		for(Long c:pDto.getCities()){
			cities.add(DTOHelper.getCity(c));
		}
		p.setCities(cities);
		
		Set<Government> enabledGovernments = new HashSet<Government>();
		for(String s: pDto.getEnabledGovernments()){
			enabledGovernments.add(DTOHelper.getGovernment(s));
		}
		p.setEnabledGovernments(enabledGovernments);
		
		p.setGovernment(DTOHelper.getGovernment(pDto.getGovernment()));
		
		Set<Unit>units = new HashSet<Unit>();
		for(Long u:pDto.getUnits()){
			units.add(DTOHelper.getUnit(u));
		}
		p.setUnits(units);
		
		p.setLuxuriesRatio(pDto.getLuxuriesRatio());
		p.setResearch(pDto.getResearch());
		p.setResearchRatio(pDto.getResearchRatio());
		p.setResearchSpent(pDto.getResearchSpent());
		p.setTaxesRatio(pDto.getTaxesRatio());
		p.setTreasury(pDto.getTreasury());
		p.setTurnsAvailable(pDto.getTurnsAvailable());
		return p;
	}
	
	private static City getCity(Long c) {
		City city = new City();
		city.setId(c);
		return city;
	}
	public static PlayerDTO getPlayerDTO(Player player){
		PlayerDTO pDto = new PlayerDTO();
		pDto.setId(player.getId());
		pDto.setName(player.getName());
		if(player.getCurrentAdvance()!=null){
			pDto.setCurrentAdvance(player.getCurrentAdvance().getIdent());
		}
		
		if(player.getGovernment()!=null){
			pDto.setGovernment(player.getGovernment().getIdent());
		}
		
		Set<String> advances = new HashSet<String>();
		for(Advance a: player.getAdvances()){
			advances.add(a.getIdent());
		}
		pDto.setAdvances(advances);
		
		Set<String> enabledAdvances = new HashSet<String>();
		for(Advance a: player.getEnabledAdvances()){
			enabledAdvances.add(a.getIdent());
		}
		pDto.setEnabledAdvances(enabledAdvances);
		
		Set<Long> cities = new HashSet<Long>();
		for(City c:player.getCities()){
			cities.add(c.getId());
		}
		pDto.setCities(cities);
		
		Set<Long> units = new HashSet<Long>();
		for(Unit u:player.getUnits()){
			units.add(u.getId());
		}
		pDto.setUnits(units);
		
		pDto.setLuxuriesRatio(player.getLuxuriesRatio());
		pDto.setResearch(player.getResearch());
		pDto.setResearchRatio(player.getResearchRatio());
		pDto.setResearchSpent(player.getResearchSpent());
		pDto.setTaxesRatio(player.getTaxesRatio());
		pDto.setTreasury(player.getTreasury());
		pDto.setTurnsAvailable(player.getTurnsAvailable());
		
		return pDto;
	}
//	
//	public static PlayerDTOExtension getPlayerDTOExtension(Player player) {
//		PlayerDTOExtension ext = new PlayerDTOExtension();
//		ext.setAdvanceCurrent(DTOHelper.getAdvanceDTO(player.getAdvanceCurrent()));
//		List<AdvanceDTO> advances = new ArrayList<AdvanceDTO>();
//		for(Advance a: player.getAdvances()){
//			advances.add(DTOHelper.getAdvanceDTO(a));
//		}
//		ext.setAdvances(advances);
//		List<CityDTO> cities = new ArrayList<CityDTO>();
//		for(City c:player.getCities()){
//			cities.add(DTOHelper.getCityDTO(c));
//		}
//		ext.setCities(cities);
//		ext.setGovernment(DTOHelper.getGovernmentDTO(player.getGovernment()));
//		List<UnitDTO> units = new ArrayList<UnitDTO>();
//		for(Unit u:player.getUnits()){
//			units.add(DTOHelper.getUnitDTO(u, DTOType.BRIEF));
//		}
//		ext.setUnits(units);
//		return ext;
//	}
	

	public static CityImprovement getCityImprovement(CityImprovementDTO impDto) {
		CityImprovement imp = new CityImprovement();
		imp.setId(impDto.getId());
		imp.setIdent(impDto.getIdent());
		imp.setName(impDto.getName());
		imp.setDescription(impDto.getDescription());
		imp.setWonder(impDto.getWonder());
		imp.setObsoletedByAdvance(DTOHelper.getAdvance(impDto.getObsoletedByAdvance()));
		imp.setObsoletedByImprovement(DTOHelper.getCityImprovement(impDto.getObsoletedByImprovement()));
		imp.setConstructionCost(impDto.getConstructionCost());
		imp.setUpkeepCost(impDto.getUpkeepCost());
		return imp;
	}


	private static CityImprovement getCityImprovement(String obsoletedByImprovement) {
		CityImprovement imp = new CityImprovement();
		imp.setIdent(obsoletedByImprovement);
		return null;
	}
	
	public static CityImprovementDTO getCityImprovementDTO(CityImprovement imp) {
		CityImprovementDTO impDto = new CityImprovementDTO();
		impDto.setId(imp.getId());
		impDto.setIdent(imp.getIdent());
		impDto.setName(imp.getName());
		impDto.setDescription(imp.getDescription());
		impDto.setWonder(imp.getWonder());
		if(imp.getObsoletedByAdvance()!=null){
			impDto.setObsoletedByAdvance(imp.getObsoletedByAdvance().getIdent());
		}
		if(imp.getObsoletedByImprovement()!=null){
			impDto.setObsoletedByImprovement(imp.getObsoletedByImprovement().getIdent());
		}
		impDto.setUpkeepCost(imp.getUpkeepCost());
		impDto.setConstructionCost(imp.getConstructionCost());
		return impDto;
	}
	
	public static Advance getAdvance(AdvanceDTO dto) {
		Advance advance = new Advance();
		advance.setId(dto.getId());
		advance.setCost(dto.getCost());
		advance.setDescription(dto.getDescription());
		advance.setIdent(dto.getIdent());
		advance.setName(dto.getName());
		Set<Advance> enabledAdvances = new HashSet<Advance>();
		for(String s:dto.getEnabledAdvances()){
			enabledAdvances.add(DTOHelper.getAdvance(s));
		}
		advance.setEnabledAdvances(enabledAdvances);
		Set<Advance> requiredAdvances = new HashSet<Advance>();
		for(String s:dto.getRequiredAdvances()){
			requiredAdvances.add(DTOHelper.getAdvance(s));
		}
		advance.setRequiredAdvances(requiredAdvances);
		Set<CityImprovement> enabledCityImprovements = new HashSet<CityImprovement>();
		for(String s: dto.getEnabledCityImprovements()){
			enabledCityImprovements.add(DTOHelper.getCityImprovement(s));
		}
		advance.setEnabledCityImprovements(enabledCityImprovements);
		Set<Government> enabledGovernments = new HashSet<Government>();
		for(String s: dto.getEnabledGovernments()){
			enabledGovernments.add(DTOHelper.getGovernment(s));
		}
		advance.setEnabledGovernments(enabledGovernments);
		Set<UnitType> enabledUnitTypes = new HashSet<UnitType>();
		for(String s:dto.getEnabledUnitTypes()){
			enabledUnitTypes.add(DTOHelper.getUnitType(s));
		}
		advance.setEnabledUnitTypes(enabledUnitTypes);
		return advance;
	}
	
	private static UnitType getUnitType(String s) {
		UnitType type = new UnitType();
		type.setIdent(s);
		return type;
	}
	private static Government getGovernment(String s) {
		if(s==null) return null;
		Government gov = new Government();
		gov.setIdent(s);
		return gov;
	}
	public static AdvanceDTO getAdvanceDTO(Advance advance) {
		AdvanceDTO advanceDto = new AdvanceDTO();
		advanceDto.setId(advance.getId());
		advanceDto.setIdent(advance.getIdent());
		advanceDto.setName(advance.getName());
		advanceDto.setDescription(advance.getDescription());
		Set<String> enabledGovernments = new HashSet<String>();
		for(Government g:advance.getEnabledGovernments()){
			enabledGovernments.add(g.getIdent());
		}
		advanceDto.setEnabledGovernments(enabledGovernments);
		Set<String>enabledImprovements = new HashSet<String>();
		for(CityImprovement i:advance.getEnabledCityImprovements()){
			enabledImprovements.add(i.getIdent());
		}
		advanceDto.setEnabledCityImprovements(enabledImprovements);
		Set<String> enabledUnitTypes = new HashSet<String>();
		for(UnitType u:advance.getEnabledUnitTypes()){
			enabledUnitTypes.add(u.getIdent());
		}
		advanceDto.setEnabledUnitTypes(enabledUnitTypes);
		Set<String> enabledAdvances = new HashSet<String>();
		for(Advance a: advance.getEnabledAdvances()){
			enabledAdvances.add(a.getIdent());
		}
		advanceDto.setEnabledAdvances(enabledAdvances);
		Set<String> requiredAdvances = new HashSet<String>();
		for(Advance a: advance.getRequiredAdvances()){
			requiredAdvances.add(a.getIdent());
		}
		advanceDto.setRequiredAdvances(requiredAdvances);
		advanceDto.setCost(advance.getCost());
		return advanceDto;
	}
	public static Government getGovernment(GovernmentDTO govDto){
		Government gov = new Government();
		gov.setId(govDto.getId());
		gov.setIdent(govDto.getIdent());
		gov.setName(govDto.getName());
		gov.setDescription(govDto.getDescription());
		return gov;
	}
	public static GovernmentDTO getGovernmentDTO(Government g) {
		GovernmentDTO govDto = new GovernmentDTO();
		govDto.setId(g.getId());
		govDto.setIdent(g.getIdent());
		govDto.setName(g.getName());
		govDto.setDescription(g.getDescription());
		return govDto;
	}

	public static Unit getUnit(UnitDTO uDto) {
		Unit u = new Unit();
		u.setId(uDto.getId());
		u.setOwner(DTOHelper.getPlayer(uDto.getOwner()));
		u.setTile(DTOHelper.getTile(uDto.getTile()));
		u.setType(DTOHelper.getUnitType(uDto.getType()));
		u.setAttackStrength(uDto.getAttackStrength());
		u.setCurrentAction(DTOHelper.getAction(uDto.getCurrentAction()));
		u.setDefenseStrength(uDto.getDefenseStrength());
		u.setDistanceHome(uDto.getDistanceHome());
		u.setHealthPoints(uDto.getHealthPoints());
		u.setMovementPoints(uDto.getMovementPoints());
		u.setTargetTile(DTOHelper.getTile(uDto.getTargetTile()));
		u.setVeteran(uDto.getVeteran());
		Set<Action> actions = new HashSet<Action>();
		for(String a:uDto.getActions()){
			actions.add(DTOHelper.getAction(a));
		}
		u.setActions(actions);
		
		return u;
	}
	
	public static UnitDTO getUnitDTO(Unit u) {
		UnitDTO uDto = new UnitDTO();
		uDto.setId(u.getId());
		uDto.setOwner(u.getOwner().getId());
		uDto.setTile(u.getTile().getId());
		uDto.setType(u.getType().getIdent());
		uDto.setAttackStrength(u.getAttackStrength());
		if(u.getCurrentAction()!=null){
			uDto.setCurrentAction(u.getCurrentAction().getIdent());
		}
		uDto.setDefenseStrength(u.getDefenseStrength());
		uDto.setDistanceHome(u.getDistanceHome());
		uDto.setHealthPoints(u.getHealthPoints());
		uDto.setMovementPoints(u.getMovementPoints());
		if(u.getTargetTile()!=null){
			uDto.setTargetTile(u.getTargetTile().getId());
		}
		uDto.setVeteran(u.getVeteran());
		Set<String> actions = new HashSet<String>();
		for(Action a:u.getActions()){
			actions.add(a.getIdent());
		}
		uDto.setActions(actions);
		
		
		return uDto;
	}


	public static Action getAction(ActionDTO aDto) {
		Action a = new Action();
		a.setId(aDto.getId());
		a.setIdent(aDto.getIdent());
		a.setDescription(aDto.getDescription());
		a.setName(aDto.getName());
		return a;
	}
	
	public static ActionDTO getActionDTO(Action a) {
		ActionDTO aDto = new ActionDTO();
		aDto.setId(a.getId());
		aDto.setIdent(a.getIdent());
		aDto.setName(a.getName());
		aDto.setDescription(a.getDescription());
		return aDto;
	}
	
	public static UnitType getUnitType(UnitTypeDTO uDto) {
		UnitType u = new UnitType();
		u.setId(uDto.getId());
		u.setIdent(uDto.getIdent());
		u.setName(uDto.getName());
		u.setDescription(uDto.getDescription());
		u.setAttackStrength(uDto.getAttackStrength());
		u.setCost(uDto.getCost());
		u.setDefenseStrength(uDto.getDefenseStrength());
		u.setMilitary(uDto.getMilitary());
		u.setMovementPoints(uDto.getMovementPoints());
		Set<Action> actions = new HashSet<Action>();
		for(String action: uDto.getActions()){
			actions.add(DTOHelper.getAction(action));
		}
		u.setActions(actions);
		u.setObsoletedByAdvance(DTOHelper.getAdvance(uDto.getObsoletedByAdvance()));
		u.setMovementArea(MovementArea.valueOf(uDto.getMovementArea()));
		return u;
	}
	
	private static Action getAction(String action) {
		Action act = new Action();
		act.setIdent(action);
		return act;
	}
	private static Advance getAdvance(String obsoletedByAdvance) {
		Advance advance = new Advance();
		advance.setIdent(obsoletedByAdvance);
		return advance;
	}
	public static UnitTypeDTO getUnitTypeDTO(UnitType u) {
		UnitTypeDTO uDto = new UnitTypeDTO();
		uDto.setId(u.getId());
		uDto.setIdent(u.getIdent());
		uDto.setName(u.getName());
		uDto.setDescription(u.getDescription());
		uDto.setAttackStrength(u.getAttackStrength());
		uDto.setCost(u.getCost());
		uDto.setDefenseStrength(u.getDefenseStrength());
		uDto.setMilitary(u.getMilitary());
		uDto.setMovementPoints(u.getMovementPoints());
		uDto.setMovementArea(u.getMovementArea().name());
		Set<String> actions = new HashSet<String>();
		for(Action a: u.getActions()){
			actions.add(a.getIdent());
		}
		uDto.setActions(actions);
		return uDto;
	}
	public static TradeRouteDTO getTradeRouteDTO(TradeRoute route) {
		TradeRouteDTO tDto = new TradeRouteDTO();
		tDto.setId(route.getId());
		tDto.setDestination(DTOHelper.getCityDTO(route.getDestination()));
		return tDto;
	}
	
	public static TradeRoute getTradeRoute(TradeRouteDTO tDto) {
		TradeRoute route = new TradeRoute();
		route.setId(tDto.getId());
		route.setDestination(DTOHelper.getCity(tDto.getDestination()));
		return route;
	}
	
	
	public static Tile getTile(TileDTO tDto){
		Tile tile = new Tile();
		
		tile.setId(tDto.getId());
		tile.setPosX(tDto.getPosX());
		tile.setPosY(tDto.getPosY());
		tile.setCity(DTOHelper.getCity(tDto.getCity()));
		tile.setOwnedBy(DTOHelper.getCity(tDto.getOwnedBy()));
		tile.setTerrain(DTOHelper.getTerrain(tDto.getTerrain()));
		tile.setSpecial(DTOHelper.getSpecial(tDto.getSpecial()));
		
		tile.setDefenseBonus(tDto.getDefenseBonus());
		tile.setMovementCost(tDto.getMovementCost());
		
		tile.setFoodProduction(tDto.getFoodProduction());
		tile.setResourcesProduction(tDto.getResourcesProduction());
		tile.setTradeProduction(tDto.getTradeProduction());
		
		Set<TileImprovement>improvements = new HashSet<TileImprovement>();
		for(String imp:tDto.getImprovements()){
			improvements.add(DTOHelper.getTileImprovement(imp));
		}
		tile.setImprovements(improvements);
		
		Set<Unit> units = new HashSet<Unit>();
		for(Long u:tDto.getUnits()){
			units.add(DTOHelper.getUnit(u));
		}
		tile.setUnits(units);
		
		
		return tile;
	}

	private static TileImprovement getTileImprovement(String imp) {
		TileImprovement t = new TileImprovement();
		t.setIdent(imp);
		return t;
	}
	private static Special getSpecial(String special) {
		Special s = new Special();
		s.setIdent(special);
		return s;
	}
	private static Terrain getTerrain(String terrain) {
		Terrain t = new Terrain();
		t.setIdent(terrain);
		return t;
	}
	public static TileDTO getTileDTO(Tile tile){
		TileDTO tDto = new TileDTO();
		tDto.setId(tile.getId());
		tDto.setPosX(tile.getPosX());
		tDto.setPosY(tile.getPosY());
		tDto.setTerrain(tile.getTerrain().getIdent());
		tDto.setSpecial(tile.getSpecial().getIdent());
		if(tile.getCity()!=null){
			tDto.setCity(tile.getCity().getId());
		}
		Set<String>improvements = new HashSet<String>();
		for(TileImprovement imp:tile.getImprovements()){
			improvements.add(imp.getIdent());
		}
		tDto.setImprovements(improvements);
		
		if(tile.getOwnedBy()!=null){
			tDto.setOwnedBy(tile.getOwnedBy().getId());
		}
		
		Set<Long>units = new HashSet<Long>();
		for(Unit u:tile.getUnits()){
			units.add(u.getId());
		}
		tDto.setUnits(units);
		
		tDto.setDefenseBonus(tile.getDefenseBonus());
		tDto.setFoodProduction(tile.getFoodProduction());
		tDto.setMovementCost(tile.getMovementCost());
		tDto.setResourcesProduction(tile.getResourcesProduction());
		tDto.setTradeProduction(tile.getTradeProduction());
		
		return tDto;
	}
	
	public static TileImprovement getTileImprovement(TileImprovementDTO tDto) {
		TileImprovement imp = new TileImprovement();
		imp.setId(tDto.getId());
		imp.setIdent(tDto.getIdent());
		imp.setDescription(tDto.getDescription());
		imp.setCost(tDto.getCost());
		
		return imp;
	}
	
	public static TileImprovementDTO getTileImprovementDTO(TileImprovement imp) {
		TileImprovementDTO tDto = new TileImprovementDTO();
		tDto.setId(imp.getId());
		tDto.setIdent(imp.getIdent());
		tDto.setDescription(imp.getDescription());
		tDto.setCost(imp.getCost());
		
		return tDto;
	}

	
	public static Terrain getTerrain(TerrainDTO tDto) {
		Terrain terrain = new Terrain();
		terrain.setId(tDto.getId());
		terrain.setIdent(tDto.getIdent());
		terrain.setName(tDto.getName());
		terrain.setDescription(tDto.getDescription());
		terrain.setMovementArea(MovementArea.valueOf(tDto.getIdent()));
		Set<Special> specials = new HashSet<Special>();
		for(String s:tDto.getSpecials()){
			specials.add(DTOHelper.getSpecial(s));
		}
		terrain.setSpecials(specials);
		
		return terrain;
	}
	
	public static TerrainDTO getTerrainDTO(Terrain terrain) {
		TerrainDTO tDto = new TerrainDTO();
		tDto.setId(terrain.getId());
		tDto.setIdent(terrain.getIdent());
		tDto.setName(terrain.getName());
		tDto.setDescription(terrain.getDescription());
		tDto.setMovementArea(terrain.getMovementArea().name());
		Set<String> specials = new HashSet<String>();
		for(Special s: terrain.getSpecials()){
			specials.add(s.getIdent());
		}
		tDto.setSpecials(specials);
		return tDto;
	}
	
	public static Special getSpecial(SpecialDTO sDto) {
		Special special = new Special();
		special.setId(sDto.getId());
		special.setIdent(sDto.getIdent());
		special.setName(sDto.getName());
		special.setDescription(sDto.getDescription());
		
		return special;
	}

	public static SpecialDTO getSpecialDTO(Special special) {
		SpecialDTO sDto = new SpecialDTO();
		sDto.setId(special.getId());
		sDto.setIdent(special.getIdent());
		sDto.setName(special.getName());
		sDto.setDescription(special.getDescription());
		
		return sDto;
	}
}
	
