package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mandiri.model.TCustomerResponse;

@Repository("customerRepository")
public interface TCpiRepository extends JpaRepository<TCustomerResponse, Long> {
	 
	TCustomerResponse findTCustomerResponseByCif(Long cif);
}