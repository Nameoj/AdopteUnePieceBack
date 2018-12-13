package fr.adopteunepiece.adope_une_piece.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name="civilite")
	private String civilite;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "adresse1")
	private String adresse1;
	@Column(name = "adresse2")
	private String adresse2;
	@Column(name = "codepostal")
	private String codepostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "active")
	private Boolean active;
	
	public Buyer () {}

	public Buyer(String email, String password, String civilite, String prenom, String nom, String telehone, String adresse1,
			String adresse2, String codepostal, String ville, Boolean active) {
		this.email = email;
		this.password = password;
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telehone;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codepostal = codepostal;
		this.ville = ville;
		this.active = true;
	}

	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelehone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse1() {
		return adresse1;
	}
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	public String getAdresse2() {
		return adresse2;
	}
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Buyer [id=" + id + ", email=" + email + ", civilite=" + civilite +  ", password=" + password + ", prenom=" + prenom + ", nom=" + nom
				+ ", telephone=" + telephone + ", adresse1=" + adresse1 + ", adresse2=" + adresse2 + ", codepostal="
				+ codepostal + ", ville=" + ville + ", active=" + active + "]";
	}	

}
