package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Reason;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {

	@Query(value = "SELECT c FROM Reason c where c.productGroup = :productGroup")
	List<Reason> findbyGroup(@Param("productGroup") String productGroup);
}
