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
			+ " where (:userNip is null or (:userNip is not null and ua.user_nip = :userNip)) order by ua.user_nip desc limit 10 ", nativeQuery = true)
	List<Object[]> findTAuditTrail(@Param("userNip") String userNip);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Nik is null or (:Nik is not null and lower(cpi.nik) LIKE CONCAT('%', :Nik, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNik(@Param("Nik") String Nik);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Phone is null or (:Phone is not null and lower(cus.phone) LIKE CONCAT('%', :Phone, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByPhone(@Param("Phone") String Phone);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Name is null or (:Name is not null and lower(cpi.name) LIKE CONCAT('%', :Name, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByName(@Param("Name") String Name);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Cif is null or (:Cif is not null and CAST(cus.cif AS TEXT) LIKE CONCAT('%', :Cif, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByCif(@Param("Cif") BigInteger Cif);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Norek is null or (:Norek is not null and CAST(cus.account_number AS TEXT) LIKE CONCAT('%', :Norek, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNorek(@Param("Norek") BigInteger Norek);
	
	@Query(value = "SELECT cus.cif, cpi.name, cpi.nik, cpi.email, cus.phone, cpi.address, cpi.birthdate, cpi.birthplace, "
			+ "cpi.identity, cpi.gender, cpi.branch, cpi.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cpi.cif as cpi_cif, "
			+ "cus.account_number, cpi.createdon as cpi_createdon, "
			+ "cpi.createdby as cpi_createdby, cpi.modifiedon as cpi_modifiedon, cpi.modifiedby as cpi_modifiedby, "
			+ "cph.account_number as cph_account_number, cph.card_number as cph_card_number "
			+ "FROM dev_lms.t_customer_response cus "
			+ "inner join dev_lms.t_cpi cpi on cus.cif = cpi.cif "
			+ "inner join dev_lms.t_cph cph on cus.cif = cph.cif "
			+ "where (:Nokar is null or (:Nokar is not null and CAST(cph.card_number AS TEXT) LIKE CONCAT('%', :Nokar, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNokar(@Param("Nokar") BigInteger Nokar);
}