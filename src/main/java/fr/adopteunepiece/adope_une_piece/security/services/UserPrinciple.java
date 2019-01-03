package fr.adopteunepiece.adope_une_piece.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.adopteunepiece.adope_une_piece.entities.User;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	@JsonIgnore
	private String password;
	
	private String username;

	private String civilite;

	private String prenom;
	
	private String nom;
	
	private String telephone;
	
	private String adresse1;
	
	private String adresse2;
	
	private String codepostal;
	
	private String ville;
	
	private Boolean active;
	 
    private Collection<? extends GrantedAuthority> authorities;
    
    public UserPrinciple(Long id, String email, String username, String password, String civilite, String prenom,
			String nom, String telephone, String adresse1, String adresse2, String codepostal, String ville,
			Boolean active, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codepostal = codepostal;
		this.ville = ville;
		this.active = active;
		this.authorities = authorities;
	}
 
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getCivilite(),
                user.getPrenom(),
                user.getNom(),
                user.getTelephone(),
                user.getAdresse1(),
                user.getAdresse2(),
                user.getCodepostal(),
                user.getVille(),
                user.getActive(),
                authorities
        );
    }

    public String getCivilite() {
		return civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public String getVille() {
		return ville;
	}

	public Boolean getActive() {
		return active;
	}

	public Long getId() {
        return id;
    }
 
    public String getEmail() {
        return email;
    }
 
    @Override
    public String getUsername() {
        return username;
    }
 
    @Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

}
