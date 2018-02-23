package com.mandiri.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{
	@Query(value = "SELECT c FROM Campaign c where c.TProduct.productId = :productId")
	List<Campaign> findbyProductId(@Param("cif") String productId);
	
//	@Query(value = "SELECT c FROM CustomerCampaign c where c.customer.cif = :cif and c.status = :status")
//	List<CustomerCampaign> findbyCifandStatus(@Param("cif") Long cif, @Param("status") int status);
}
