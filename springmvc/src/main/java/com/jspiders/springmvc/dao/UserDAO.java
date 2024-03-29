package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.CarDTO;
import com.jspiders.springmvc.dto.UserDTO;

@Component
public class UserDAO {

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

	public UserDTO addUser(UserDTO userDTO) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		closeConnection();
		return userDTO;
	}

	public List<UserDTO> findAllUsers() {
		openConnection();
		Query query = entityManager.createQuery("SELECT user FROM UserDTO user");
		@SuppressWarnings("unchecked")
		List<UserDTO> users = query.getResultList();
		closeConnection();
		return users;
	}

	public void updateUser(int userId, int carId) {
		openConnection();
		UserDTO user = entityManager.find(UserDTO.class, userId);
		CarDTO car = entityManager.find(CarDTO.class, carId);
		List<CarDTO> cars = user.getCars();
		cars.add(car);
		user.setCars(cars);
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		closeConnection();
	}

	public void deleteUser(int id) {
		openConnection();
		UserDTO user = entityManager.find(UserDTO.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		closeConnection();
	}

}
