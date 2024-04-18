package com.jspiders.cardekho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho.pojo.Car;
import com.jspiders.cardekho.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	public Car findCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Car> findAllCars() {
		List<Car> cars = carRepository.findAll();
		if (cars.size() > 0) {
			return cars;
		} else {
			return null;
		}
	}

	public Car deleteCar(Integer id) {
		if (id != null) {
			Car carToBeDeleted = findCarById(id);
			carRepository.deleteById(id);
			return carToBeDeleted;
		} else {
			return null;
		}
	}

	public Car findCarByBrand(String brand) {
		return carRepository.findCarByBrand(brand);
	}

}
