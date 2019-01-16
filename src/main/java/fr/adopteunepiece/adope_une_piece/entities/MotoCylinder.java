package fr.adopteunepiece.adope_une_piece.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="motoCylinder")
public class MotoCylinder {
	
	@Id
	@NotEmpty
	@Column(unique=true, name="cylinderName", columnDefinition="VARCHAR(64)")
	private String cylinderName; 
	@ManyToMany(mappedBy="motoCylinders")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<MotoModel> motoModels;
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="MOTOCYLINDER_MOTOYEAR", 
	joinColumns= {
			@JoinColumn(name="MOTOCYLINDER_CYLINDERNAME", referencedColumnName="cylinderName")},
	inverseJoinColumns = {
			@JoinColumn(name="MOTOYEAR_YEARNAME", referencedColumnName="yearName")
	})
	private Set<MotoYear> motoYears;
	
	public MotoCylinder() {
		this.cylinderName="";
	}
	
	public MotoCylinder(@NotEmpty String cylinderName, Set<MotoModel> motoModels, Set<MotoYear> motoYears) {
		this.cylinderName = cylinderName;
		this.motoModels = motoModels;
		this.motoYears = motoYears;
	}

	public MotoCylinder(@NotEmpty String cylinderName, Set<MotoModel> motoModels) {
		this.cylinderName = cylinderName;
		this.motoModels = motoModels;
	}
	
	public MotoCylinder(@NotEmpty String cylinderName) {
		this.cylinderName = cylinderName;
	}

	public String getCylinderName() {
		return cylinderName;
	}

	public void setCylinderName(String cylinderName) {
		this.cylinderName = cylinderName;
	}

	public Set<MotoModel> getMotoModels() {
		return motoModels;
	}

	public void setMotoModels(Set<MotoModel> motoModels) {
		this.motoModels = motoModels;
	}

	public Set<MotoYear> getMotoYears() {
		return motoYears;
	}

	public void setMotoYears(Set<MotoYear> motoYears) {
		this.motoYears = motoYears;
	}
	
	
	
	
	
	
	
}
