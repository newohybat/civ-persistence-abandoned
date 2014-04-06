package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.util.List;
import java.util.Set;

import org.drools.definition.type.PropertyReactive;

@PropertyReactive
public class PlayerDTO {
	private Long id;
	private String name;
	private Set<Long> cities;
	private Set<Long> units;
	private String government;
	private Set<String> enabledGovernments;
	private String currentAdvance;
	private Set<String> advances;
	private Set<String> enabledAdvances;
	private Integer treasury;
	private Integer research;
	private Integer researchSpent;
	private Integer turnsAvailable;
	private Integer luxuriesRatio;
	private Integer taxesRatio;
	private Integer researchRatio;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(this.id!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGovernment() {
		return government;
	}
	public void setGovernment(String government) {
		this.government = government;
	}
	
	public Set<Long> getCities() {
		return cities;
	}
	public void setCities(Set<Long> cities) {
		this.cities = cities;
	}
	public Set<Long> getUnits() {
		return units;
	}
	public void setUnits(Set<Long> units) {
		this.units = units;
	}
	public Set<String> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<String> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public void setAdvances(Set<String> advances) {
		this.advances = advances;
	}
	public void setEnabledAdvances(Set<String> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public String getCurrentAdvance() {
		return currentAdvance;
	}
	public void setCurrentAdvance(String currentAdvance) {
		this.currentAdvance = currentAdvance;
	}
	public Set<String> getAdvances() {
		return advances;
	}
	public Set<String> getEnabledAdvances() {
		return enabledAdvances;
	}
	public Integer getTreasury() {
		return treasury;
	}
	public void setTreasury(Integer treasury) {
		this.treasury = treasury;
	}
	public Integer getResearch() {
		return research;
	}
	public void setResearch(Integer research) {
		this.research = research;
	}
	public Integer getResearchSpent() {
		return researchSpent;
	}
	public void setResearchSpent(Integer researchSpent) {
		this.researchSpent = researchSpent;
	}
	public Integer getTurnsAvailable() {
		return turnsAvailable;
	}
	public void setTurnsAvailable(Integer turnsAvailable) {
		this.turnsAvailable = turnsAvailable;
	}
	public Integer getLuxuriesRatio() {
		return luxuriesRatio;
	}
	public void setLuxuriesRatio(Integer luxuriesRatio) {
		this.luxuriesRatio = luxuriesRatio;
	}
	public Integer getTaxesRatio() {
		return taxesRatio;
	}
	public void setTaxesRatio(Integer taxesRatio) {
		this.taxesRatio = taxesRatio;
	}
	public Integer getResearchRatio() {
		return researchRatio;
	}
	public void setResearchRatio(Integer researchRatio) {
		this.researchRatio = researchRatio;
	}
	

	
}
