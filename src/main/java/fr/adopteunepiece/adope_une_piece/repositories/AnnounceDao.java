package fr.adopteunepiece.adope_une_piece.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.Announce;

@Repository
public interface AnnounceDao extends JpaRepository<Announce, Long> {

	List<Announce> findBySeller (String seller);

	Optional<Announce> findByModel(String model);

	List<Announce> findByModelAndYearAndCylinder(String model, String year, String cylinder);

}
