package com.mandiri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandiri.filter.UserProfile;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserProfile, Long> {
//	 User findByEmail(String email);
	 
	UserProfile findByUsername(String username);
}