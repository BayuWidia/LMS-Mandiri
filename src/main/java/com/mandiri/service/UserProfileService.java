package com.mandiri.service;

import com.mandiri.model.Userprofile;

public interface UserProfileService {
//	public User findUserByEmail(String email);
	public void saveUserProfile(Userprofile user);
	public Userprofile findUserProfileByUsername(String username);
}
