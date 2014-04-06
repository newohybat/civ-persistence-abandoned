package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Advance
 *
 */
@Entity

public class Advance implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true, nullable=false)
	private String ident;
	@Column(nullable=false)
	private String name;
	private String description;
	@ManyToMany
	@JoinTable(name = "ADVANCE_ENABLED", 
			joinColumns = {
			 @JoinColumn(name = "enablement", referencedColumnName = "id", nullable = false)},
			inverseJoinColumns = {
			 @JoinColumn(name = "requirement", referencedColumnName = "id", nullable = false)}
	)
	private Set<Advance> enabledAdvances;
	@ManyToMany(mappedBy = "enabledAdvances")
	private Set<Advance> requiredAdvances;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<CityImprovement> enabledCityImprovements;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<UnitType> enabledUnitTypes;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Government> enabledGovernments;
	private Integer cost;
	
	private static final long serialVersionUID = 1L;

	public Advance() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getIdent() {
		return this.ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}   
	
	public Set<Advance> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<Advance> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public Set<Advance> getRequiredAdvances() {
		return requiredAdvances;
	}
	public void setRequiredAdvances(Set<Advance> requiredAdvances) {
		this.requiredAdvances = requiredAdvances;
	}
	public Set<CityImprovement> getEnabledCityImprovements() {
		return enabledCityImprovements;
	}
	public void setEnabledCityImprovements(
			Set<CityImprovement> enabledCityImprovements) {
		this.enabledCityImprovements = enabledCityImprovements;
	}
	
	
	public Set<UnitType> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<UnitType> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	
	public Set<Government> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<Government> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((enabledGovernments == null) ? 0 : enabledGovernments
						.hashCode());
		result = prime
				* result
				+ ((enabledCityImprovements == null) ? 0 : enabledCityImprovements
						.hashCode());
		result = prime * result
				+ ((enabledUnitTypes == null) ? 0 : enabledUnitTypes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ident == null) ? 0 : ident.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Advance other = (Advance) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabledGovernments == null) {
			if (other.enabledGovernments != null)
				return false;
		} else if (!enabledGovernments.equals(other.enabledGovernments))
			return false;
		if (enabledCityImprovements == null) {
			if (other.enabledCityImprovements != null)
				return false;
		} else if (!enabledCityImprovements.equals(other.enabledCityImprovements))
			return false;
		if (enabledUnitTypes == null) {
			if (other.enabledUnitTypes != null)
				return false;
		} else if (!enabledUnitTypes.equals(other.enabledUnitTypes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ident == null) {
			if (other.ident != null)
				return false;
		} else if (!ident.equals(other.ident))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
