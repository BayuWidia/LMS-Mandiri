package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TOccupation;
import com.mandiri.model.Userprofile;


@Repository("TOccupationRepository")
public interface TOccupationRepository extends JpaRepository<TOccupation, String> {
//	 User findByEmail(String email);
	 
	@Query("select p from TOccupation p")
	public List<TOccupation> findAll();
	
	TOccupation findByOccp(String occp);
}