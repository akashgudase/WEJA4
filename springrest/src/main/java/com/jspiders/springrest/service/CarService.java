package com.jspiders.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.Car;
import com.jspiders.springrest.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public Car addCar(Car car) {
		return carRepository.addCar(car);
	}

	public List<Car> findAllCars() {
		List<Car> cars = carRepository.findAllCars();
		if (cars != null && cars.size() > 0) {
			return cars;
		} else {
			return null;
		}
	}

	public Car deleteCar(int id) {
		return carRepository.deleteCar(id);
	}

	public Car updateCar(Car car) {
		return carRepository.updateCar(car);
	}

}
