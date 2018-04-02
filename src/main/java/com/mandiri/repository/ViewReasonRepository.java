package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Viewreason;

@Repository
public interface ViewReasonRepository extends JpaRepository<Viewreason, Long> {

	@Query(value = "SELECT c FROM Viewreason c where c.productGroup = :productGroup")
	List<Viewreason> findbyGroup(@Param("productGroup") String productGroup);
}
