package fr.adopteunepiece.adope_une_piece.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="motoYear")
public class MotoYear {
	@Id
	@NotEmpty
	@Column(unique=true, name="yearName")
	private String yearName; 
	@ManyToMany(mappedBy="motoYears")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<MotoCylinder> motoCylinders;
	
	public MotoYear() {
	}

	public MotoYear(@NotEmpty String yearName, Set<MotoCylinder> motoCylinders) {
		this.yearName = yearName;
		this.motoCylinders = motoCylinders;
	}
	
	public MotoYear(@NotEmpty String yearName) {
		this.yearName = yearName;
		this.motoCylinders = new HashSet<>();
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public Set<MotoCylinder> getMotoCylinders() {
		return motoCylinders;
	}

	public void setMotoCylinders(Set<MotoCylinder> motoCylinders) {
		this.motoCylinders = motoCylinders;
	}
	
	
	
	

}
