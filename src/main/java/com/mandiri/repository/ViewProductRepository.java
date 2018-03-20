package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Viewproduct;

@Repository
public interface ViewProductRepository extends JpaRepository<Viewproduct, String> {
	@Query(value = "SELECT c FROM Viewproduct c where c.groupProductId = :groupproductid ")
	List<Viewproduct> findbyGroupProductid(@Param("groupproductid") Long groupproductid);
}
