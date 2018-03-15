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
	
	//@Query(value = "SELECT c FROM TProduct c where c.groupProduct.id = :groupproductid ")
	@Query(value = "SELECT * FROM dev_lms.t_product where group_product_id = :groupproductid ", nativeQuery=true)
	List<TProduct> findbyGroupProductid(@Param("groupproductid") Long groupproductid);
	
	//TProduct findByGroupProduct(Long groupproductid);
}
