package fr.adopteunepiece.adope_une_piece.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adopteunepiece.adope_une_piece.entities.MotoModel;
import fr.adopteunepiece.adope_une_piece.entities.MotoModelInfo;

@Repository
public interface MotoModelInfoRepository extends JpaRepository<MotoModelInfo, Long>{

	List<MotoModelInfo> findByMotoModel(MotoModel motoModel);

}
