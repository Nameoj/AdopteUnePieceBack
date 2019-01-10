package fr.adopteunepiece.adope_une_piece.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

	Seller findByEmail(String email);
    Optional<Seller> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
