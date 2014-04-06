package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.drools.definition.type.PropertyReactive;

@PropertyReactive
public class CityDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7120676160672613111L;
	private Long id;
	private String name;
	private Long cityCentre;
	private Long owner;
	private Set<String> improvements;
	private String currentImprovement;
	private Set<String> enabledImprovements;
	private Set<Long> homeUnits;
	private String currentUnit;
	private Set<String> enabledUnitTypes;
	private Set<TradeRouteDTO> tradeRoutes;
	private Set<Long> managedTiles;
	private Integer size;
	private Boolean weLoveDay;
	private Boolean disorder;
	private Integer foodProduction;
	private Integer foodConsumption;
	private Integer foodSurplus;
	private Integer foodStock;
	private Integer resourcesProduction;
	private Integer resourcesConsumption;
	private Integer resourcesSurplus;
	private Integer tradeProduction;
	private Integer corruption; // lost of trade
	private Integer luxuriesAmount;
	private Integer luxuriesSpent;
	private Integer taxesAmount;
	private Integer researchAmount;
	private Integer peopleHappy;
	private Integer peopleUnhappy;
	private Integer peopleContent;
	private Integer peopleEntertainers;
	private Integer peopleTaxmen;
	private Integer peopleScientists;
	private Integer pollutionChance;
	private Integer improvementsUpkeep; // lost of taxesAmount
	private Integer unitsSupport;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(this.id!=null) throw new IllegalStateException("Attempt to change unchangable property.");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getImprovements() {
		return improvements;
	}
	public void setImprovements(Set<String> improvements) {
		this.improvements = improvements;
	}
	public Set<String> getEnabledImprovements() {
		return enabledImprovements;
	}
	public void setEnabledImprovements(Set<String> enabledImprovements) {
		this.enabledImprovements = enabledImprovements;
	}
	public Set<Long> getHomeUnits() {
		return homeUnits;
	}
	public void setHomeUnits(Set<Long> homeUnits) {
		this.homeUnits = homeUnits;
	}
	public Set<String> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<String> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	public Set<TradeRouteDTO> getTradeRoutes() {
		return tradeRoutes;
	}
	public void setTradeRoutes(Set<TradeRouteDTO> tradeRoutes) {
		this.tradeRoutes = tradeRoutes;
	}
	public Set<Long> getManagedTiles() {
		return managedTiles;
	}
	public void setManagedTiles(Set<Long> managedTiles) {
		this.managedTiles = managedTiles;
	}
	public Long getCityCentre() {
		return cityCentre;
	}
	public void setCityCentre(Long cityCentre) {
		this.cityCentre = cityCentre;
	}
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
		
	public String getCurrentImprovement() {
		return currentImprovement;
	}
	public void setCurrentImprovement(String currentImprovement) {
		this.currentImprovement = currentImprovement;
	}
	public String getCurrentUnit() {
		return currentUnit;
	}
	public void setCurrentUnit(String currentUnit) {
		this.currentUnit = currentUnit;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Boolean getWeLoveDay() {
		return weLoveDay;
	}
	public void setWeLoveDay(Boolean weLoveDay) {
		this.weLoveDay = weLoveDay;
	}
	public Boolean getDisorder() {
		return disorder;
	}
	public void setDisorder(Boolean disorder) {
		this.disorder = disorder;
	}
	public Integer getFoodProduction() {
		return foodProduction;
	}
	public void setFoodProduction(Integer foodProduction) {
		this.foodProduction = foodProduction;
	}
	public Integer getFoodConsumption() {
		return foodConsumption;
	}
	public Integer getUnitsSupport() {
		return unitsSupport;
	}
	public void setUnitsSupport(Integer unitsSupport) {
		this.unitsSupport = unitsSupport;
	}
	public void setFoodConsumption(Integer foodConsumption) {
		this.foodConsumption = foodConsumption;
	}
	public Integer getFoodSurplus() {
		return foodSurplus;
	}
	public void setFoodSurplus(Integer foodSurplus) {
		this.foodSurplus = foodSurplus;
	}
	public Integer getFoodStock() {
		return foodStock;
	}
	public void setFoodStock(Integer foodStock) {
		this.foodStock = foodStock;
	}
	public Integer getResourcesProduction() {
		return resourcesProduction;
	}
	public void setResourcesProduction(Integer resourcesProduction) {
		this.resourcesProduction = resourcesProduction;
	}
	public Integer getResourcesConsumption() {
		return resourcesConsumption;
	}
	public void setResourcesConsumption(Integer resourcesConsumption) {
		this.resourcesConsumption = resourcesConsumption;
	}
	public Integer getResourcesSurplus() {
		return resourcesSurplus;
	}
	public void setResourcesSurplus(Integer resourcesSurplus) {
		this.resourcesSurplus = resourcesSurplus;
	}
	public Integer getTradeProduction() {
		return tradeProduction;
	}
	public void setTradeProduction(Integer tradeProduction) {
		this.tradeProduction = tradeProduction;
	}
	public Integer getCorruption() {
		return corruption;
	}
	public void setCorruption(Integer corruption) {
		this.corruption = corruption;
	}
	public Integer getLuxuriesAmount() {
		return luxuriesAmount;
	}
	public void setLuxuriesAmount(Integer luxuriesAmount) {
		this.luxuriesAmount = luxuriesAmount;
	}
	public Integer getLuxuriesSpent() {
		return luxuriesSpent;
	}
	public void setLuxuriesSpent(Integer luxuriesSpent) {
		this.luxuriesSpent = luxuriesSpent;
	}
	public Integer getTaxesAmount() {
		return taxesAmount;
	}
	public void setTaxesAmount(Integer taxAmount) {
		this.taxesAmount = taxAmount;
	}
	public Integer getResearchAmount() {
		return researchAmount;
	}
	public void setResearchAmount(Integer researchAmount) {
		this.researchAmount = researchAmount;
	}
	public Integer getPeopleHappy() {
		return peopleHappy;
	}
	public void setPeopleHappy(Integer peopleHappy) {
		this.peopleHappy = peopleHappy;
	}
	public Integer getPeopleUnhappy() {
		return peopleUnhappy;
	}
	public void setPeopleUnhappy(Integer peopleUnhappy) {
		this.peopleUnhappy = peopleUnhappy;
	}
	public Integer getPeopleContent() {
		return peopleContent;
	}
	public void setPeopleContent(Integer peopleContent) {
		this.peopleContent = peopleContent;
	}
	public Integer getPeopleEntertainers() {
		return peopleEntertainers;
	}
	public void setPeopleEntertainers(Integer peopleEntertainers) {
		this.peopleEntertainers = peopleEntertainers;
	}
	public Integer getPeopleTaxmen() {
		return peopleTaxmen;
	}
	public void setPeopleTaxmen(Integer peopleTaxmen) {
		this.peopleTaxmen = peopleTaxmen;
	}
	public Integer getPeopleScientists() {
		return peopleScientists;
	}
	public void setPeopleScientists(Integer peopleScientists) {
		this.peopleScientists = peopleScientists;
	}
	public Integer getPollutionChance() {
		return pollutionChance;
	}
	public void setPollutionChance(Integer pollutionChance) {
		this.pollutionChance = pollutionChance;
	}
	public Integer getImprovementsUpkeep() {
		return improvementsUpkeep;
	}
	public void setImprovementsUpkeep(Integer improvementsUpkeep) {
		this.improvementsUpkeep = improvementsUpkeep;
	}
	
	
	
	
	
}
