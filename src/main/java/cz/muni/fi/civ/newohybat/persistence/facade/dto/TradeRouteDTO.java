package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;

public class TradeRouteDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2745186027075510835L;
	private Long id;
	private CityDTO destination;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CityDTO getDestination() {
		return destination;
	}
	public void setDestination(CityDTO destination) {
		this.destination = destination;
	}
	
}
