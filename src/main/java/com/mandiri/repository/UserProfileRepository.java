package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.filter.UserProfileFilter;
import com.mandiri.model.Userprofile;

@Repository("UserProfileRepository")
public interface UserProfileRepository extends JpaRepository<Userprofile, String> {
//	 User findByEmail(String email);
	 
	Userprofile findByName(String name);
}