package fr.adopteunepiece.adope_une_piece.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String marque;
    
    private String modele;
    
    private String cylindree;
    
    private String annee;

	public Vehicule() {
	}

	public Vehicule(Long id, String marque, String modele, String cylindree, String annee) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.cylindree = cylindree;
		this.annee = annee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCylindree() {
		return cylindree;
	}

	public void setCylindree(String cylindree) {
		this.cylindree = cylindree;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
    
    

}
