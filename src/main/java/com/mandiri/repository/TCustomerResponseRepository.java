package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCustomerResponse;

@Repository
public interface TCustomerResponseRepository extends JpaRepository<TCustomerResponse, String>{

}
