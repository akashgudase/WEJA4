package com.jspiders.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.Car;
import com.jspiders.springrest.pojo.User;

@Repository
public class CarRepository {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public Car addCar(Car car) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(car);
		entityTransaction.commit();
		closeConnection();
		return car;
	}

	@SuppressWarnings("unchecked")
	public List<Car> findAllCars() {
		openConnection();
		Query query = entityManager.createQuery("SELECT car FROM Car car");
		List<Car> cars = query.getResultList();
		closeConnection();
		return cars;
	}

	public Car deleteCar(int carId, int userId) {
		openConnection();
		User user = entityManager.find(User.class, userId);
		List<Car> cars = user.getCars();
		Car carToBeDeleted = null;
		for (Car car : cars) {
			if (car.getId() == carId) {
				carToBeDeleted = car;
				break;
			}
		}
		cars.remove(carToBeDeleted);
		user.setCars(cars);
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		Car car = entityManager.find(Car.class, carId);
		entityTransaction.begin();
		if (car != null) {
			entityManager.remove(car);
		}
		entityTransaction.commit();
		closeConnection();
		return car;
	}

	public Car updateCar(Car car) {
		openConnection();
		Car carToBeUpdated = entityManager.find(Car.class, car.getId());
		entityTransaction.begin();
		if (carToBeUpdated != null) {
			carToBeUpdated.setName(car.getName());
			carToBeUpdated.setBrand(car.getBrand());
			carToBeUpdated.setPrice(car.getPrice());
			entityManager.persist(carToBeUpdated);
		}
		entityTransaction.commit();
		closeConnection();
		return carToBeUpdated;
	}

}
