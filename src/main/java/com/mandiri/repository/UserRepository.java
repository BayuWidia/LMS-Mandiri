package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.filter.UserProfileFilter;
import com.mandiri.model.Userprofile;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserProfileFilter, Long> {
//	 User findByEmail(String email);
	 
	Userprofile findByUsername(String username);
}