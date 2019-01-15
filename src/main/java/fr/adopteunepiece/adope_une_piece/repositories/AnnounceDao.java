package fr.adopteunepiece.adope_une_piece.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.Announce;

@Repository
public interface AnnounceDao extends JpaRepository<Announce, Long> {

	List<Announce> findBySeller (String seller);

}
