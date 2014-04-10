package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;


public class SpecialDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 708300063719118397L;
	private Long id;
	private String ident;
	private String name;
	private String description;
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
	
}
