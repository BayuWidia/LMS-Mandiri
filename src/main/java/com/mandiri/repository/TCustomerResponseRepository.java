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
	
	
	@Query(value = "SELECT cus.customer_response_id, cus.reminder, cpi.name as nama_cpi, prod.product_name as product_name, "
			+ "cus.user_id, cus.status FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_product prod on cus.product_id = prod.product_id "
			+ "where cus.status = 'f' and CAST(cus.reminder AS DATE) = CURRENT_DATE "
			+ "and (:userNip is null or (:userNip is not null and cus.user_id = :userNip)) order by cus.reminder asc", nativeQuery = true)
	List<Object[]> findReminderOn(@Param("userNip") String userNip);
}
