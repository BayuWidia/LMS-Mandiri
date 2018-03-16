package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Viewprogram;

@Repository
public interface ViewProgramRepository extends JpaRepository<Viewprogram, Long>{
//	@Query(value = "SELECT c FROM Program c where c.productGroup = 'ALL' OR c.productGroup = :group")
//	List<Program> findbyGroup(@Param("group") String group);
	@Query(value = "SELECT c FROM Viewprogram c where c.productId = :productid")
	List<Viewprogram> findbyProductid(@Param("productid") String productid);
}
