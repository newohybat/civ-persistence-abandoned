package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: CityImprovement
 *
 */
@Entity

public class CityImprovement implements Serializable {   
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true,nullable=false)
	private String ident;
	@Column(nullable=false)
	private String name;
	private String description;
	private Boolean wonder;
	@ManyToOne
	private Advance obsoletedByAdvance;
	@ManyToOne
	private CityImprovement obsoletedByImprovement;
	private Integer constructionCost;
	private Integer upkeepCost;
	
	private static final long serialVersionUID = 1L;

	public CityImprovement() {
		super();
	}   
	public Long getId() {
		return this.id;
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
	public Boolean getWonder() {
		return this.wonder;
	}

	public void setWonder(Boolean wonder) {
		this.wonder = wonder;
	}
	public Advance getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(Advance obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public CityImprovement getObsoletedByImprovement() {
		return obsoletedByImprovement;
	}
	public void setObsoletedByImprovement(CityImprovement obsoletedByImprovement) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((wonder == null) ? 0 : wonder.hashCode());
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
		CityImprovement other = (CityImprovement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (wonder == null) {
			if (other.wonder != null)
				return false;
		} else if (!wonder.equals(other.wonder))
			return false;
		return true;
	}
	
   
}
