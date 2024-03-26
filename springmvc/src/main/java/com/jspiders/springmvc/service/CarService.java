package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.CarDAO;
import com.jspiders.springmvc.dto.CarDTO;

@Component
public class CarService {

	@Autowired
	private CarDAO carDAO;

	public CarDTO addCar(String name, String brand, double price) {
		CarDTO carDTO = new CarDTO();
		carDTO.setName(name);
		carDTO.setBrand(brand);
		carDTO.setPrice(price);
		return carDAO.addCar(carDTO);
	}

	public List<CarDTO> findAllCars() {
		List<CarDTO> cars = carDAO.findAllCars();
		if (cars != null && cars.size() > 0) {
			return cars;
		} else {
			return null;
		}
	}

}
