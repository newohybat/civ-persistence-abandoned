package cz.muni.fi.civ.newohybat.persistence.facade.dto;

public class TradeRouteDTO {
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
