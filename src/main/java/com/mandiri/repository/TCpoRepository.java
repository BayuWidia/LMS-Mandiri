package com.mandiri.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCpo;

@Repository
public interface TCpoRepository extends JpaRepository<TCpo, String>{
//	@Query(value = "SELECT c FROM TCpo c where c.TCpi.cif = :cif and c.TProduct.group != 'TRASH' ")
//	List<TCpo> findbyCif(@Param("cif") String cif);
	
	@Query(value = "SELECT c FROM TCpo c where c.TCpi.cif = :cif and c.status = 0 ")
	List<TCpo> findbyCif(@Param("cif") String cif);
	
	@Query(value = "SELECT c FROM TCpo c where c.cpoId = :id and c.status = 0 ")
	TCpo findbyId(@Param("id") String id);
	
	// Example with positional params
	@Modifying
	@Query("update TCpo c set c.status = 9 where c.cpoId = ?1")
	Integer setFlagTcpo(String cpoId);
}
