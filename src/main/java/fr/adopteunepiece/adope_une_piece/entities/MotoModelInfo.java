package fr.adopteunepiece.adope_une_piece.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table
public class MotoModelInfo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="motoModel")
	private MotoModel motoModel;
	@Column(name="motoCylinder")
	private String motoCylinder;
	@Column(name="motoYear")
	private String motoYear;
	
	public MotoModelInfo() {
	}
	
	public MotoModelInfo(Long id) {
		this.id = id;
	}
	public MotoModelInfo(Long id, MotoModel motoModel, String motoCylinder, String motoYear) {
		this.id = id;
		this.motoModel = motoModel;
		this.motoCylinder = motoCylinder;
		this.motoYear = motoYear;
	}
	public MotoModelInfo(MotoModel motoModel, String motoCylinder, String motoYear) {
		this.motoModel = motoModel;
		this.motoCylinder = motoCylinder;
		this.motoYear = motoYear;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MotoModel getMotoModel() {
		return motoModel;
	}
	public void setMotoModel(MotoModel motoModel) {
		this.motoModel = motoModel;
	}
	public String getMotoCylinder() {
		return motoCylinder;
	}
	public void setMotoCylinder(String motoCylinder) {
		this.motoCylinder = motoCylinder;
	}
	public String getMotoYear() {
		return motoYear;
	}
	public void setMotoYear(String motoYear) {
		this.motoYear = motoYear;
	}
	
	
}
