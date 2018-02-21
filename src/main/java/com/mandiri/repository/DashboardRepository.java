package com.mandiri.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mandiri.model.UserActivity;

@Repository("dashboardRepository")
public interface DashboardRepository extends JpaRepository<UserActivity, Long> {

	@Query(value = "SELECT ua.id, ua.action, ua.cif, ua.createdon, ua.createdby FROM public.user_activities ua "
			+ "where (:createdBy is null or (:createdBy is not null and ua.createdby= :createdBy)) order by ua.createdon desc limit 10 ", nativeQuery = true)
	List<Object[]> findUserActivity(@Param("createdBy") String createdBy);

	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Nik is null or (:Nik is not null and lower(cus.nik) LIKE CONCAT('%', :Nik, '%'))) "
			+ "and (:Phone is null or (:Phone is not null and lower(cus.phone) LIKE CONCAT('%', :Phone, '%'))) "
			+ "and (:Name is null or (:Name is not null and lower(cus.name) LIKE CONCAT('%', :Name, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByParam(@Param("Nik") String Nik,
			@Param("Phone") String Phone,
			@Param("Name") String Name);
	
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Nik is null or (:Nik is not null and lower(cus.nik) LIKE CONCAT('%', :Nik, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNik(@Param("Nik") String Nik);
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Phone is null or (:Phone is not null and lower(cus.phone) LIKE CONCAT('%', :Phone, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByPhone(@Param("Phone") String Phone);
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Name is null or (:Name is not null and lower(cus.name) LIKE CONCAT('%', :Name, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByName(@Param("Name") String Name);
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Cif is null or (:Cif is not null and CAST(cus.cif AS TEXT) LIKE CONCAT('%', :Cif, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByCif(@Param("Cif") BigInteger Cif);
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Norek is null or (:Norek is not null and CAST(cusp.accountno AS TEXT) LIKE CONCAT('%', :Norek, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNorek(@Param("Norek") BigInteger Norek);
	
	@Query(value = "SELECT cus.cif, cus.name, cus.nik, cus.email, cus.phone, cus.address, cus.birthdate, cus.birthplace, "
			+ "cus.indentitytype, cus.gender, cus.branchid, cus.mothername, cus.createdon as cus_createdon, "
			+ "cus.modifiedon as cus_modifiedon, cus.createdby as cus_createdby, cus.modifiedby as cus_modifiedby, cusp.id as cusp_id, "
			+ "cusp.productid, cusp.accountno, cusp.cardno, cusp.leanno, cusp.createdon as cusp_createdon, "
			+ "cusp.createdby as cusp_createdby, cusp.modifiedon as cusp_modifiedon, cusp.modifiedby as cusp_modifiedby "
			+ "FROM public.customer cus inner join public.customer_product cusp on cus.cif = cusp.cif "
			+ "where (:Nokar is null or (:Nokar is not null and CAST(cusp.cardno AS TEXT) LIKE CONCAT('%', :Nokar, '%'))) ",
			nativeQuery = true)
	List<Object[]> findJoinSearchByNokar(@Param("Nokar") BigInteger Nokar);
}