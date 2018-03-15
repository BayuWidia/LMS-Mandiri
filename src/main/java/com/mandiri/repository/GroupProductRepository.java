package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.GroupProduct;

@Repository
public interface GroupProductRepository extends JpaRepository<GroupProduct, Long> {

}
