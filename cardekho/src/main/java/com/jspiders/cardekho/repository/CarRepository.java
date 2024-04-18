package com.jspiders.cardekho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.cardekho.pojo.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	Car findCarByBrand(String brand);
}
