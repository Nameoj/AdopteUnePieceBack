package fr.adopteunepiece.adope_une_piece.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.Buyer;
import fr.adopteunepiece.adope_une_piece.entities.User;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	Buyer findByEmail(String email);
    Optional<Buyer> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
