package com.mandiri.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.TAuditTrail;
//import com.mandiri.model.UserActivity;

@Repository("dashboardRepository")
public interface DashboardRepository extends JpaRepository<TAuditTrail, Long> {

	@Query(value = "SELECT ua.id, ua.info, ua.user_nip, ua.createdon, ua.criteria, ua.audited, ua.modifiedon, ua.createdby, ua.modifiedby"
			+ " FROM dev_lms.t_audit_trail ua"
			+ " where (:userNip is null or (:userNip is not null and ua.createdby = :userNip)) order by ua.createdon desc limit 10 ", nativeQuery = true)
	List<Object[]> findTAuditTrail(@Param("userNip") String userNip);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Nik is null or (:Nik is not null and lower(cpi.nik) LIKE CONCAT('%', :Nik, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNik(@Param("Nik") String Nik);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Phone is null or (:Phone is not null and lower(cpi.hp) LIKE CONCAT('%', :Phone, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByPhone(@Param("Phone") String Phone);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Name is null or (:Name is not null and lower(cpi.name) LIKE CONCAT('%', :Name, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByName(@Param("Name") String Name);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Cif is null or (:Cif is not null and CAST(cpi.cif AS TEXT) LIKE CONCAT('%', :Cif, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByCif(@Param("Cif") BigInteger Cif);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Norek is null or (:Norek is not null and CAST(cph.account_number AS TEXT) LIKE CONCAT('%', :Norek, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNorek(@Param("Norek") BigInteger Norek);
	
	@Query(value = "SELECT cpi.cif, cpi.name, cpi.nik, cpi.email, cpi.hp, cpi.address, cpi.birth_date, cpi.birth_place, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mother_name, cpi.createdon as cpi_createdon, "
			+ "cpi.modifiedon as cpi_modifiedon, cpi.createdby as cpi_createdby, cpi.modifiedby as cpi_modifiedby, "
			+ "cpi.cif as cpi_cif, cph.account_number, cph.account_number as cph_account_number, "
			+ "cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_cpi cpi inner join dev_lms.t_cph cph on cpi.cif = cph.cif "
			+ "where (:Nokar is null or (:Nokar is not null and CAST(cph.card_number AS TEXT) LIKE CONCAT('%', :Nokar, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNokar(@Param("Nokar") BigInteger Nokar);
}