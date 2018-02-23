package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCph;

@Repository
public interface TCphRepository extends JpaRepository<TCph, String>{

}
