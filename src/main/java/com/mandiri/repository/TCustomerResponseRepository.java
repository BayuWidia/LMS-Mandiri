package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCustomerResponse;

@Repository
public interface TCustomerResponseRepository extends JpaRepository<TCustomerResponse, String>{
	@Query(value = "SELECT c FROM TCustomerResponse c where c.TCpi.cif = :cif")
	List<TCustomerResponse> findbyCif(@Param("cif") String cif);
}
