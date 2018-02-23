package com.mandiri.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.mandiri.filter.UserProfileFilter;

@Controller
public class SessionController {
	
	@Autowired
	UserProfileFilter userProfile;
	
	
	public void getSession(Model model, HttpSession session){
		userProfile = (UserProfileFilter) session.getAttribute("userProfile");
		model.addAttribute("userProfile", userProfile);
	}
}
