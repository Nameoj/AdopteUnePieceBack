package fr.adopteunepiece.adope_une_piece.repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adopteunepiece.adope_une_piece.entities.Role;
import fr.adopteunepiece.adope_une_piece.entities.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Set<Role> findByName(RoleName roleName);

}
