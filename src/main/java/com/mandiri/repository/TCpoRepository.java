package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCpo;

@Repository
public interface TCpoRepository extends JpaRepository<TCpo, String>{
	@Query(value = "SELECT c FROM TCpo c where c.TCpi.cif = :cif and c.TProduct.group != 'TRASH' ")
	List<TCpo> findbyCif(@Param("cif") String cif);
}
