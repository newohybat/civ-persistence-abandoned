package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.drools.definition.type.PropertyReactive;

@PropertyReactive
public class UnitTypeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 866499471859790148L;
	private Long id;
	private String ident;
	private String name;
	private String description;
	private Boolean military;
	private Integer attackStrength;
	private Integer defenseStrength;
	private Integer movementPoints;
	private Set<String> actions;
	private Integer cost;
	private String obsoletedByAdvance;
	private String movementArea;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
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
	public Integer getAttackStrength() {
		return attackStrength;
	}
	public void setAttackStrength(Integer attackStrength) {
		this.attackStrength = attackStrength;
	}
	public Integer getDefenseStrength() {
		return defenseStrength;
	}
	public void setDefenseStrength(Integer defenseStrength) {
		this.defenseStrength = defenseStrength;
	}
	public Integer getMovementPoints() {
		return movementPoints;
	}
	public void setMovementPoints(Integer movementPoints) {
		this.movementPoints = movementPoints;
	}
	public Boolean getMilitary() {
		return military;
	}
	public void setMilitary(Boolean military) {
		this.military = military;
	}
	public Set<String> getActions() {
		return actions;
	}
	public void setActions(Set<String> actions) {
		this.actions = actions;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(String obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public String getMovementArea() {
		return movementArea;
	}
	public void setMovementArea(String movementArea) {
		this.movementArea = movementArea;
	}
	
	
	
}
