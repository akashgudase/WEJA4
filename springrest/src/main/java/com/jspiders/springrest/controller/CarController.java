package com.jspiders.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.Car;
import com.jspiders.springrest.reponse.ResponseStructure;
import com.jspiders.springrest.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping(path = "/car")
	public ResponseEntity<ResponseStructure<Car>> addCar(@RequestBody Car car) {
		Car addedCar = carService.addCar(car);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Car added");
		responseStructure.setData(addedCar);
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
	}

	@GetMapping(path = "/cars")
	public ResponseEntity<ResponseStructure<List<Car>>> findAllCars() {
		List<Car> cars = carService.findAllCars();
		ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
		if (cars != null) {
			responseStructure.setMessage("Cars found");
			responseStructure.setData(cars);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Cars not found");
			responseStructure.setData(cars);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/car")
	public ResponseEntity<ResponseStructure<Car>> deleteCar(@RequestParam(name = "carId") int carId,
			@RequestParam(name = "userId") int userId) {
		Car deletedCar = carService.deleteCar(carId, userId);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if (deletedCar != null) {
			responseStructure.setMessage("Car deleted");
			responseStructure.setData(deletedCar);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Car not found");
			responseStructure.setData(deletedCar);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/car")
	public ResponseEntity<ResponseStructure<Car>> updateCar(@RequestBody Car car) {
		Car updatedCar = carService.updateCar(car);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if (updatedCar != null) {
			responseStructure.setMessage("Car updated");
			responseStructure.setData(updatedCar);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Car not found");
			responseStructure.setData(updatedCar);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
