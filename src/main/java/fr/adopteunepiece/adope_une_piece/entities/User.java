package fr.adopteunepiece.adope_une_piece.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "users", uniqueConstraints = {
@UniqueConstraint(columnNames = {
"username"
}),
})

public abstract class User{
@NaturalId
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String username;

private String password;

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "user_roles", 
joinColumns = @JoinColumn(name = "user_id"), 
inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<Role> roles = new HashSet<>();

public User() {}

public User(String username,String password) {
this.username = username;
this.password = password;
}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	

}
