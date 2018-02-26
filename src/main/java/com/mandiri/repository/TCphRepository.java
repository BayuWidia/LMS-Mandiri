package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCph;

@Repository
public interface TCphRepository extends JpaRepository<TCph, String>{
	@Query(value = "SELECT c FROM TCph c where c.TCpi.cif = :cif")
	List<TCph> findbyCif(@Param("cif") String cif);
}
