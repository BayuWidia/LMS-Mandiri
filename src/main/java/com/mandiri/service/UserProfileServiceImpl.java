package com.mandiri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mandiri.model.Userprofile;
//import com.mandiri.model.Role;
//import com.mandiri.repository.RoleRepository;
import com.mandiri.repository.UserProfileRepository;


@Service("userService")
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	
//	@Autowired
//	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Override
//	public User findUserByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
	
	@Override
	public Userprofile findUserProfileByUsername(String username) {
		return userProfileRepository.findByUsername(username);
	}

	@Override
	public void saveUserProfile(Userprofile user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setActive(1);
//		Role userRole = roleRepository.findByName("admin");
//		user.setRole(null);
//		user.setRoles(Set<Role> userRole);
//		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//		userRepository.save((Iterable<S>) user);
	}

}
