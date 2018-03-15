package com.mandiri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.Keytracking;

@Repository
public interface KeytrackingRepository extends JpaRepository<Keytracking, Long> {
	@Query(value = "SELECT c FROM Keytracking c where c.program.id = :programid")
	List<Keytracking> findbyProgramid(@Param("programid") Long programid);
}
