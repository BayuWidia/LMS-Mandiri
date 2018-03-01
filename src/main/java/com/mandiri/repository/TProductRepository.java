package com.mandiri.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TProduct;

@Repository
public interface TProductRepository extends JpaRepository<TProduct, String> {
	@Query(value = "SELECT c FROM TProduct c where c.productId = :id")
	TProduct findbyId(@Param("id") String id);
	
	@Query(value = "SELECT c FROM TProduct c where c.group != 'TRASH' ")
	List<TProduct> findExceptTrash();
}
