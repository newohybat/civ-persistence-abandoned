package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.drools.definition.type.PropertyReactive;
@PropertyReactive
public class TileDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3244012016540558408L;
	private Long id;
	private Long posX;
	private Long posY;
	private String terrain;
	private String special;
	private Long city;
	private Set<String> improvements;
	private Set<Long> units;
	private Long ownedBy;
	private Integer foodProduction;
	private Integer resourcesProduction;
	private Integer tradeProduction;
	private Integer movementCost;
	private Integer defenseBonus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(this.id!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.id = id;
	}
	public Long getPosX() {
		return posX;
	}
	public void setPosX(Long posX) {
		this.posX = posX;
	}
	public Long getPosY() {
		return posY;
	}
	public void setPosY(Long posY) {
		this.posY = posY;
	}
	
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	
	
public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public Long getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Long ownedBy) {
		this.ownedBy = ownedBy;
	}
	
	public Set<String> getImprovements() {
		return improvements;
	}
	public void setImprovements(Set<String> improvements) {
		this.improvements = improvements;
	}
	public Set<Long> getUnits() {
		return units;
	}
	public void setUnits(Set<Long> units) {
		this.units = units;
	}
	public Integer getFoodProduction() {
		return foodProduction;
	}
	public void setFoodProduction(Integer foodProduction) {
		this.foodProduction = foodProduction;
	}
	public Integer getResourcesProduction() {
		return resourcesProduction;
	}
	public void setResourcesProduction(Integer resourcesProduction) {
		this.resourcesProduction = resourcesProduction;
	}
	public Integer getTradeProduction() {
		return tradeProduction;
	}
	public void setTradeProduction(Integer tradeProduction) {
		this.tradeProduction = tradeProduction;
	}
	public Integer getMovementCost() {
		return movementCost;
	}
	public void setMovementCost(Integer movementCost) {
		this.movementCost = movementCost;
	}
	public Integer getDefenseBonus() {
		return defenseBonus;
	}
	public void setDefenseBonus(Integer defenseBonus) {
		this.defenseBonus = defenseBonus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posX == null) ? 0 : posX.hashCode());
		result = prime * result + ((posY == null) ? 0 : posY.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TileDTO other = (TileDTO) obj;
		if (posX == null) {
			if (other.posX != null)
				return false;
		} else if (!posX.equals(other.posX))
			return false;
		if (posY == null) {
			if (other.posY != null)
				return false;
		} else if (!posY.equals(other.posY))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TileDTO [id=" + id + ", posX=" + posX + ", posY=" + posY
				+ ", terrain=" + terrain + ", special=" + special + ", city="
				+ city + ", improvements=" + improvements + ", units=" + units
				+ ", ownedBy=" + ownedBy + ", foodProduction=" + foodProduction
				+ ", resourcesProduction=" + resourcesProduction
				+ ", tradeProduction=" + tradeProduction + ", movementCost="
				+ movementCost + ", defenseBonus=" + defenseBonus + "]";
	}
	
	
	
}
