package fr.adopteunepiece.adope_une_piece.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "raison_sociale")
	private String raisonSociale;
	@Column(name = "siret_number")
	private String siretNumber;
	@Column(name = "siren_number")
	private String sirenNumber;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "codepostal")
	private String codepostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "managing_director_name")
	private String managingDirectorName;
	@Column(name = "managing_director_surname")
	private String managingDirectorSurname;
	@Column(name = "managing_director_phone")
	private String managingDirectorPhone;
	@Column(name = "active")
	private Boolean active;
	
	public Seller () {}
	
	public Seller (String email, String password, String raisonSociale, String siretNumber, String sirenNumber,
			String telephone, String adresse, String codepostal, String ville, String managingDirectorName,
			String managingDirectorSurname, String managingDirectorPhone, Boolean active) {
		this.email = email;
		this.password = password;
		this.raisonSociale = raisonSociale;
		this.siretNumber = siretNumber;
		this.sirenNumber = sirenNumber;
		this.telephone = telephone;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.managingDirectorName = managingDirectorName;
		this.managingDirectorSurname = managingDirectorSurname;
		this.managingDirectorPhone = managingDirectorPhone;
		this.active = true;
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

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public String getSirenNumber() {
		return sirenNumber;
	}

	public void setSirenNumber(String sirenNumber) {
		this.sirenNumber = sirenNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getManagingDirectorName() {
		return managingDirectorName;
	}

	public void setManagingDirectorName(String managingDirectorName) {
		this.managingDirectorName = managingDirectorName;
	}

	public String getManagingDirectorSurname() {
		return managingDirectorSurname;
	}

	public void setManagingDirectorSurname(String managingDirectorSurname) {
		this.managingDirectorSurname = managingDirectorSurname;
	}

	public String getManagingDirectorPhone() {
		return managingDirectorPhone;
	}

	public void setManagingDirectorPhone(String managingDirectorPhone) {
		this.managingDirectorPhone = managingDirectorPhone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
