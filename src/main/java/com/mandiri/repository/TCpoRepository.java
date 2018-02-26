package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TCpo;

@Repository
public interface TCpoRepository extends JpaRepository<TCpo, String>{

}
