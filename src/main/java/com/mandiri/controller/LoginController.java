package com.mandiri.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mandiri.model.User;
import com.mandiri.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;


	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		Date date = new Date();

		DateFormat fmtDate = new SimpleDateFormat("dd MMMM yyyy");
		DateFormat fmtDay = new SimpleDateFormat("EEEE");
		String strDate = fmtDate.format(date);
		String strDay = fmtDay.format(date);

		modelAndView.addObject("strDay", strDay);
		modelAndView.addObject("strDate", strDate);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUsername(user.getUsername());
		System.out.println("REG username:::"+user.getUsername());
		System.out.println("REG fullname:::"+user.getFullname());
		System.out.println("REG password:::"+user.getPassword());
		
		if (userExists != null) {
			bindingResult.rejectValue("Username", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}


}
