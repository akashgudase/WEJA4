package com.jspiders.cardekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho.pojo.Car;
import com.jspiders.cardekho.response.ResponseStructure;
import com.jspiders.cardekho.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/cars")
	protected ResponseEntity<ResponseStructure<Car>> addCar(@RequestBody Car car) {
		Car addedCar = carService.addCar(car);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Car added");
		responseStructure.setData(addedCar);
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/car{id}")
	protected ResponseEntity<ResponseStructure<Car>> findCarById(@PathVariable int id) {
		Car car = carService.findCarById(id);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if (car != null) {
			responseStructure.setMessage("Car found");
			responseStructure.setData(car);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Car not found");
			responseStructure.setData(car);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cars")
	protected ResponseEntity<ResponseStructure<List<Car>>> findAllCars() {
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
	
	@PutMapping("/car")
	protected ResponseEntity<ResponseStructure<Car>> updateCar(@RequestBody Car car){
		Car updatedCar = carService.addCar(car);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Car updated");
		responseStructure.setData(updatedCar);
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
	}
	
	@DeleteMapping("/car")
	protected ResponseEntity<ResponseStructure<Car>> deleteCar(@RequestParam(name = "id") Integer id){
		Car deletedCar = carService.deleteCar(id);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if(deletedCar != null) {
			responseStructure.setMessage("Car deleted");
			responseStructure.setData(deletedCar);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Car not deleted");
			responseStructure.setData(deletedCar);
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/car")
	protected ResponseEntity<ResponseStructure<Car>> findCarByBrand(@RequestParam(name = "brand") String brand) {
		Car car = carService.findCarByBrand(brand);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if (car != null) {
			responseStructure.setMessage("Car found");
			responseStructure.setData(car);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Car not found");
			responseStructure.setData(car);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Car>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
