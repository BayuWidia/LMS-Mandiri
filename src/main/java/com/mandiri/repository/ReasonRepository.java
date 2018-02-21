package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Reason;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {

}
