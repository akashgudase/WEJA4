package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.CarDTO;
import com.jspiders.springmvc.dto.UserDTO;
import com.jspiders.springmvc.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(path = "/add_page", method = RequestMethod.GET)
	public String getAddPage(HttpSession httpSession) {
		UserDTO signedInUser = (UserDTO) httpSession.getAttribute("user");
		if (signedInUser != null) {
			return "add_car";
		} else {
			return "sign_in";
		}
	}

	@RequestMapping(path = "/add_car", method = RequestMethod.POST)
	public String addCar(@RequestParam(name = "name") String name, @RequestParam(name = "brand") String brand,
			@RequestParam(name = "price") double price, ModelMap modelMap, HttpSession httpSession) {
		UserDTO signedInUser = (UserDTO) httpSession.getAttribute("user");
		if (signedInUser != null) {
			carService.addCar(name, brand, price);
			modelMap.addAttribute("message", "Car details added");
			return "add_car";
		} else {
			return "sign_in";
		}
	}

	@RequestMapping(path = "/cars", method = RequestMethod.GET)
	public String findAllCars(ModelMap modelMap, HttpSession httpSession) {
		UserDTO signedInUser = (UserDTO) httpSession.getAttribute("user");
		if (signedInUser != null) {
			List<CarDTO> cars = carService.findAllCars();
			if (cars != null) {
				modelMap.addAttribute("cars", cars);
			} else {
				modelMap.addAttribute("message", "Cars not available");
			}
			return "cars";
		} else {
			return "sign_in";
		}
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpSession httpSession) {
		UserDTO signedInUser = (UserDTO) httpSession.getAttribute("user");
		if (signedInUser != null) {
			return "home";
		} else {
			return "sign_in";
		}
	}

}
