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
	@Column(name="title")
	private String title;
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
	
	public Announce() {
		
	}
	
	public Announce(String title, String seller, String image, String description, String note,
			String postDate, Double price) {
		this.title = title;
		this.seller = seller;
		this.image = image;
		this.description = description;
		this.note = note;
		this.postDate = postDate;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setId(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Announce [id=" + id + ", title=" + title + ", seller=" + seller + ", image=" + image + ", description="+ description 
				+ ", note=" + ", postDate=" + postDate + ", price=" + price + "]";
	}
	
}
