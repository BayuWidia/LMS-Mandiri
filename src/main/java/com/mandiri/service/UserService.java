package com.mandiri.service;

import com.mandiri.filter.UserProfile;

public interface UserService {
//	public User findUserByEmail(String email);
	public void saveUserProfile(UserProfile user);
	public UserProfile findUserProfileByUsername(String username);
}
