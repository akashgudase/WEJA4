package com.jspiders.hibernatejpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatejpa.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(2);
		studentDTO.setName("Suresh");
		studentDTO.setEmail("suresh@gmail.com");
		studentDTO.setMobile(9876543211l);
		studentDTO.setAge(25);

		openConnection();
		entityTransaction.begin();

		entityManager.persist(studentDTO);

		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {

		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	private static void closeConnection() {

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

}
