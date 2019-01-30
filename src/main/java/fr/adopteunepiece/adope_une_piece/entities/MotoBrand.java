package fr.adopteunepiece.adope_une_piece.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="motoBrand")
public class MotoBrand {

	@Id
	@NotEmpty
	@Column(unique=true, name="name")
	private String name;
	@Column
	@OneToMany(mappedBy="motoBrand", cascade=CascadeType.ALL)
	private List<MotoModel> motoModels;

	public MotoBrand() {
	}

	public MotoBrand(@NotEmpty String name, List<MotoModel> motoModels) {
		this.name = name;
		this.motoModels = motoModels;
	}
	
	public MotoBrand(@NotEmpty String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MotoModel> getMotoModels() {
		return motoModels;
	}

	public void setMotoModels(List<MotoModel> motoModels) {
		this.motoModels = motoModels;
	}
	
	
	
}
