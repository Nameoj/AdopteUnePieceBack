package fr.adopteunepiece.adope_une_piece.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
	@JsonProperty(access=Access.WRITE_ONLY)
	private MotoBrand motoBrand; 
	@Column(name="modelInfo")
	@OneToMany(mappedBy="motoModel", cascade=CascadeType.ALL)
	private Set<MotoModelInfo> motoModelInfo;
	public MotoModel() {
	}
	public MotoModel(@NotEmpty String modelName, MotoBrand motoBrand, Set<MotoModelInfo> motoModelInfo) {
		this.modelName = modelName;
		this.motoBrand = motoBrand;
		this.motoModelInfo = motoModelInfo;
	}
	public MotoModel(@NotEmpty String modelName, MotoBrand motoBrand) {
		this.modelName = modelName;
		this.motoBrand = motoBrand;
	}
	public MotoModel(@NotEmpty String modelName) {
		this.modelName = modelName;
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
	public Set<MotoModelInfo> getMotoModelInfo() {
		return motoModelInfo;
	}
	public void setMotoModelInfo(Set<MotoModelInfo> motoModelInfo) {
		this.motoModelInfo = motoModelInfo;
	}
	
	
	
	
	
	
}

