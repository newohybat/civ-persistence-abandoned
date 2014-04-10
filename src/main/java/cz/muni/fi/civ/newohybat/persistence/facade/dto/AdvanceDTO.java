package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.drools.definition.type.PropertyReactive;

@PropertyReactive
public class AdvanceDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 92045097809768765L;
	private Long id;
	private String ident;
	private String name;
	private String description;
	private Set<String> enabledAdvances;
	private Set<String> requiredAdvances;
	private Set<String> enabledCityImprovements;
	private Set<String> enabledUnitTypes;
	private Set<String> enabledGovernments;
	private Integer cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(this.id!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		if(this.ident!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.ident = ident;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<String> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public Set<String> getRequiredAdvances() {
		return requiredAdvances;
	}
	public void setRequiredAdvances(Set<String> requiredAdvances) {
		this.requiredAdvances = requiredAdvances;
	}
	public Set<String> getEnabledCityImprovements() {
		return enabledCityImprovements;
	}
	public void setEnabledCityImprovements(Set<String> enabledCityImprovements) {
		this.enabledCityImprovements = enabledCityImprovements;
	}
	public Set<String> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<String> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	public Set<String> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<String> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	
	
}
