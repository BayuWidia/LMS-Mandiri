package com.mandiri.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  com.mandiri.model.CustomerCampaign;

@Repository
public interface CustomerCampaignRepository extends JpaRepository<CustomerCampaign, Long>{
	@Query(value = "SELECT c FROM CustomerCampaign c where c.customer.cif = :cif")
	List<CustomerCampaign> findbyCif(@Param("cif") Long cif);
	
	@Query(value = "SELECT c FROM CustomerCampaign c where c.customer.cif = :cif and c.status = :status")
	List<CustomerCampaign> findbyCifandStatus(@Param("cif") Long cif, @Param("status") int status);
}
