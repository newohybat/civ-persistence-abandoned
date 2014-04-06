package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;

import org.drools.definition.type.PropertyReactive;

@PropertyReactive
public class CityImprovementDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7925970213597161705L;
	private Long id;
	private String ident;
	private String name;
	private String description;
	private Boolean wonder;
	private String obsoletedByAdvance;
	private String obsoletedByImprovement;
	private Integer constructionCost;
	private Integer upkeepCost; 
	
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
	public Boolean getWonder() {
		return wonder;
	}
	public void setWonder(Boolean wonder) {
		this.wonder = wonder;
	}
	
	public String getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(String obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public String getObsoletedByImprovement() {
		return obsoletedByImprovement;
	}
	public void setObsoletedByImprovement(String obsoletedByImprovement) {
		this.obsoletedByImprovement = obsoletedByImprovement;
	}
	
	public Integer getConstructionCost() {
		return constructionCost;
	}
	public void setConstructionCost(Integer constructionCost) {
		this.constructionCost = constructionCost;
	}
	public Integer getUpkeepCost() {
		return upkeepCost;
	}
	public void setUpkeepCost(Integer upkeepCost) {
		this.upkeepCost = upkeepCost;
	}

	
}
