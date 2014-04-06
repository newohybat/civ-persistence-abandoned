package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="owner",fetch = FetchType.EAGER)
	private Set<City> cities;
	
	@OneToMany(mappedBy="owner",fetch = FetchType.EAGER)
	private Set<Unit> units;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	private Government government;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ENABLED_GOVERNMENTS",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="GOVERNMENT_ID", referencedColumnName="ID")})
	private Set<Government> enabledGovernments;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	private Advance currentAdvance;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ADVANCE",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="ADVANCE_ID", referencedColumnName="ID")})
	private Set<Advance> advances;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ENABLED_ADVANCE",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="ADVANCE_ID", referencedColumnName="ID")})
	private Set<Advance> enabledAdvances;
	
	private Integer treasury;
	private Integer research;
	private Integer researchSpent;
	private Integer turnsAvailable;
	private Integer luxuriesRatio;
	private Integer taxesRatio;
	private Integer researchRatio;
	
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	public Set<Unit> getUnits() {
		return units;
	}
	public void setUnits(Set<Unit> units) {
		this.units = units;
	}
	public void setAdvances(Set<Advance> advances) {
		this.advances = advances;
	}
	public Government getGovernment() {
		return government;
	}
	public void setGovernment(Government government) {
		this.government = government;
	}
	
	public Advance getCurrentAdvance() {
		return currentAdvance;
	}
	public void setCurrentAdvance(Advance currentAdvance) {
		this.currentAdvance = currentAdvance;
	}
	public Set<Advance> getAdvances() {
		return advances;
	}
	public Set<Government> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<Government> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public Set<Advance> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<Advance> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}

	public Integer getTreasury() {
		return treasury;
	}
	public void setTreasury(Integer treasury) {
		this.treasury = treasury;
	}
	public Integer getResearch() {
		return research;
	}
	public void setResearch(Integer research) {
		this.research = research;
	}
	public Integer getResearchSpent() {
		return researchSpent;
	}
	public void setResearchSpent(Integer researchSpent) {
		this.researchSpent = researchSpent;
	}
	public Integer getTurnsAvailable() {
		return turnsAvailable;
	}
	public void setTurnsAvailable(Integer turnsAvailable) {
		this.turnsAvailable = turnsAvailable;
	}
	public Integer getLuxuriesRatio() {
		return luxuriesRatio;
	}
	public void setLuxuriesRatio(Integer luxuriesRatio) {
		this.luxuriesRatio = luxuriesRatio;
	}
	public Integer getTaxesRatio() {
		return taxesRatio;
	}
	public void setTaxesRatio(Integer taxesRatio) {
		this.taxesRatio = taxesRatio;
	}
	public Integer getResearchRatio() {
		return researchRatio;
	}
	public void setResearchRatio(Integer researchRatio) {
		this.researchRatio = researchRatio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		Player other = (Player) obj;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		return true;
	}
   
}
