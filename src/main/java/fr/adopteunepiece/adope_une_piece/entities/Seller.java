package fr.adopteunepiece.adope_une_piece.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String raisonSociale;
	@Column(name = "adresse1")
	private String adresse1;
	@Column(name = "adresse2")
	private String adresse2;
	@Column(name = "codepostal")
	private String codePostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "telephone")
	private String telephone;
	private String siren;
	@Column(name = "email")
	private String email;
	private String nomG;
	private String prenomG;
	private String telephoneG;
	@Column(name = "active")
	private Boolean active;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @OneToMany(mappedBy="sellman", cascade = CascadeType.ALL )
    private Set<Announce> announces;
	
	public Seller () {}

	public Seller(String username, String password, String raisonSociale, String adresse1, String adresse2, String codePostal, String ville,
			String telephone, String siren, String email,  String nomG, String prenomG,
			String telephoneG) {
		super(username, password);
		this.raisonSociale = raisonSociale;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.siren = siren;
		this.email = email;
		this.nomG = nomG;
		this.prenomG = prenomG;
		this.telephoneG = telephoneG;
		this.active = true;
		this.announces= new HashSet<Announce>();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSiren() {
		return siren;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNomG() {
		return nomG;
	}

	public void setNomG(String nomG) {
		this.nomG = nomG;
	}

	public String getPrenomG() {
		return prenomG;
	}

	public void setPrenomG(String prenomG) {
		this.prenomG = prenomG;
	}

	public String getTelephoneG() {
		return telephoneG;
	}

	public void setTelephoneG(String telephoneG) {
		this.telephoneG = telephoneG;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Announce> getAnnounces() {
		return announces;
	}

	public void setAnnounces(Set<Announce> announces) {
 	this.announces = announces;
	}
	
	

}

