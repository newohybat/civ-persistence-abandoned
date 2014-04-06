package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.util.List;
import java.util.Set;


public class TerrainDTO {
	private Long id;
	private String ident;
	private String name;
	private String description;
	private Set<String> specials;
	private String movementArea;
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
	
	public Set<String> getSpecials() {
		return specials;
	}
	public void setSpecials(Set<String> specials) {
		this.specials = specials;
	}
	public String getMovementArea() {
		return movementArea;
	}
	public void setMovementArea(String movementArea) {
		this.movementArea = movementArea;
	}
	
	
}
