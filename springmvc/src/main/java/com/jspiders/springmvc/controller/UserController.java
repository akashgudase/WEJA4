package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/sign_up", method = RequestMethod.GET)
	public String getSignUpPage() {
		return "sign_up";
	}

	@RequestMapping(path = "/add_user", method = RequestMethod.POST)
	public String addUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
			ModelMap modelMap) {
		UserDTO addedUser = userService.addUser(email, password);
		if (addedUser != null) {
			modelMap.addAttribute("message", "Signed up");
			return "sign_in";
		} else {
			modelMap.addAttribute("message", "Email already exists");
			return "sign_up";
		}
	}

	@RequestMapping(path = "/sign_in", method = RequestMethod.GET)
	public String getSignInPage() {
		return "sign_in";
	}

	@RequestMapping(path = "/check_user", method = RequestMethod.POST)
	public String checkUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap, HttpSession httpSession) {
		UserDTO signedInUser = userService.checkUser(email, password);
		if (signedInUser != null) {
			httpSession.setAttribute("user", signedInUser);
			httpSession.setMaxInactiveInterval(1200);
			return "home";
		} else {
			modelMap.addAttribute("message", "Inavlid Email or Password");
			return "sign_in";
		}
	}

	@RequestMapping(path = "/sign_out", method = RequestMethod.GET)
	public String signOut(ModelMap modelMap, HttpSession httpSession) {
		modelMap.addAttribute("message", "Signed out");
		httpSession.invalidate();
		return "sign_in";
	}

	@RequestMapping(path = "/delete_user", method = RequestMethod.GET)
	public String deleteUser(ModelMap modelMap, HttpSession httpSession) {
		UserDTO signedInUser = (UserDTO) httpSession.getAttribute("user");
		userService.deleteUser(signedInUser);
		modelMap.addAttribute("message", "User deleted");
		return "sign_in";
	}

}
