package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;

/**
 * Entity implementation class for Entity: UnitType
 *
 */
/**
 * @author newohybat
 *
 */
@Entity

public class UnitType implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true,nullable=false)
	private String ident;
	@Column(nullable=false)
	private String name;
	private String description;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name="UNIT_TYPE_ACTION",
	        joinColumns={@JoinColumn(name="UNIT_TYPE_ID", referencedColumnName="ID")},
	        inverseJoinColumns={@JoinColumn(name="ACTION_ID", referencedColumnName="ID")})
	private Set<Action> actions;
	@ManyToOne
	private Advance obsoletedByAdvance;
	private Boolean military;
	private Integer attackStrength;
	private Integer defenseStrength;
	private Integer movementPoints;
	private Integer cost;
	@Enumerated(EnumType.STRING)
	private MovementArea movementArea;
	private static final long serialVersionUID = 1L;

	public UnitType() {
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
	
	public Set<Action> getActions() {
		return actions;
	}
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	public Advance getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(Advance obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public Boolean getMilitary() {
		return military;
	}
	public void setMilitary(Boolean military) {
		this.military = military;
	}
	
	public MovementArea getMovementArea() {
		return movementArea;
	}
	public void setMovementArea(MovementArea movementArea) {
		this.movementArea = movementArea;
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
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitType other = (UnitType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (obsoletedByAdvance == null) {
			if (other.obsoletedByAdvance != null)
				return false;
		} else if (!obsoletedByAdvance.equals(other.obsoletedByAdvance))
			return false;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ident == null) ? 0 : ident.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((obsoletedByAdvance == null) ? 0 : obsoletedByAdvance.hashCode());
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		return result;
	}
   
}
