package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCpi;
import com.mandiri.model.TCustomerResponse;

@Repository("customerRepository")
public interface TCpiRepository extends JpaRepository<TCpi, Long> {
	
	@Query(value = "SELECT c FROM TCpi c where c.cif = :cif")
	TCpi findbyCif(@Param("cif") String cif);
	
	TCustomerResponse findTCustomerResponseByCif(Long cif);
}