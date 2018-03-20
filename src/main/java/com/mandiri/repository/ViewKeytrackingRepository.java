package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Viewkeytracking;

@Repository
public interface ViewKeytrackingRepository extends JpaRepository<Viewkeytracking, Long> {
	@Query(value = "SELECT c FROM Viewkeytracking c where c.programId = :programid")
	List<Viewkeytracking> findbyProgramid(@Param("programid") Long programid);
}
