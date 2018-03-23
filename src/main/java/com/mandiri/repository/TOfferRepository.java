package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TOffer;

@Repository
public interface TOfferRepository extends JpaRepository<TOffer, Long> {
	@Query(value = "SELECT c FROM TOffer c where c.TCpi.cif = :cif and c.status = 0 ")
	List<TOffer> findbyCif(@Param("cif") String cif);
}
