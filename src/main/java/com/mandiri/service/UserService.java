package com.mandiri.service;

import com.mandiri.model.User;

public interface UserService {
//	public User findUserByEmail(String email);
	public void saveUser(User user);
	public User findUserByUsername(String username);
}
