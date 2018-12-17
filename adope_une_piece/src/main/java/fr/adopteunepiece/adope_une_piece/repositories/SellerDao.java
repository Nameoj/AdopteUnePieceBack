package fr.adopteunepiece.adope_une_piece.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Long>{

}
