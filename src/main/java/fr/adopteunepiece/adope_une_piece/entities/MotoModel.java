package fr.adopteunepiece.adope_une_piece.entities;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="motoModel")
public class MotoModel {
	@Id
	@NotEmpty
	@Column(unique=true, name="modelName", columnDefinition="VARCHAR(64)")
	private String modelName;
	@ManyToOne
	@JoinColumn(name="motoBrand")
	@JsonProperty(access = Access.WRITE_ONLY)
	private MotoBrand motoBrand; 
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="MOTOMODEL_MOTOCYLINDER", 
		joinColumns= {
				@JoinColumn(name="MOTOMODEL_MODELNAME", referencedColumnName="modelName")},
		inverseJoinColumns = {
				@JoinColumn(name="MOTOCYLINDER_CYLINDERNAME", referencedColumnName="cylinderName")
		})
	private Set<MotoCylinder> motoCylinders;
	
	public MotoModel() {
	}
	
	public MotoModel(@NotEmpty String modelName) {
		this.modelName = modelName;
	}

	public MotoModel(@NotEmpty String modelName, MotoBrand motoBrand, Set<MotoCylinder> motoCylinders) {
		this.modelName = modelName;
		this.motoBrand = motoBrand;
		this.motoCylinders = motoCylinders;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public MotoBrand getMotoBrand() {
		return motoBrand;
	}

	public void setMotoBrand(MotoBrand motoBrand) {
		this.motoBrand = motoBrand;
	}

	public Set<MotoCylinder> getMotoCylinders() {
		return motoCylinders;
	}

	public void setMotoCylinders(Set<MotoCylinder> motoCylinders) {
		this.motoCylinders = motoCylinders;
	}
	
	
	
	
	
}
