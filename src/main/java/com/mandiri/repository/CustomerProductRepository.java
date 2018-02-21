package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  com.mandiri.model.CustomerProduct;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {
	@Query(value = "SELECT c FROM CustomerProduct c where c.customer.cif = :cif")
	List<CustomerProduct> findbyCif(@Param("cif") Long cif);
}
