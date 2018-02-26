package com.mandiri.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TProduct;

@Repository
public interface TProductRepository extends JpaRepository<TProduct, Long> {

}