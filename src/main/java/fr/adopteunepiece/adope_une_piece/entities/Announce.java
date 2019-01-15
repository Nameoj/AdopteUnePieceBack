package fr.adopteunepiece.adope_une_piece.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="announce")
public class Announce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="seller")
	private String seller;
	@Column(name="image")
	private String image;

	@Column(name="description")
	private String description;
	@Column(name="note")
	private String note;
	@Column(name="postDate")
	private String postDate;
	@Column(name="price")
	private Double price;
	
	@Column(name="charge")
	private Double charge;
	@Column(name="pieceName")
	private String pieceName;
	@Column(name="model")
	private String model;
	@Column(name="year")
	private String year;
	@Column(name="brand")
	private String brand;
	@Column(name="cylinder")
	private String cylinder;
	
	@Column(name="active")
	private Boolean active;
	
	public Announce() {
		
	}
	
	

	public Announce(String seller, String image, String description, String note,
			String postDate, Double price, Double charge, String pieceName, String model, String year, String brand, String cylinder) {
		this.seller = seller;
		this.image = image;
		this.description = description;
		this.note = note;
		this.postDate = postDate;
		this.price = price;
		this.charge = charge;
		this.pieceName = pieceName;
		this.model = model;
		this.year = year;
		this.brand = brand;
		this.cylinder = cylinder;
		this.active=true;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	public String getSeller() {
		return seller;
	}



	public void setSeller(String seller) {
		this.seller = seller;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public String getPostDate() {
		return postDate;
	}



	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Double getCharge() {
		return charge;
	}



	public void setCharge(Double charge) {
		this.charge = charge;
	}



	public String getPieceName() {
		return pieceName;
	}



	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getCylinder() {
		return cylinder;
	}



	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}



	public Boolean getActive() {
		return active;
	}



	public void setActive(Boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "Announce [id=" + id + ", seller=" + seller + ", image=" + image + ", description="+ description 
				+ ", note=" + ", postDate=" + postDate + ", price=" + price + "]";
	}
	
}
