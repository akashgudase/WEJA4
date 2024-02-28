package com.jspiders.onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebi.dto.AadharDTO;
import com.jspiders.onetoonebi.dto.PersonDTO;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		PersonDTO person = new PersonDTO();
		person.setName("Ram");
		person.setEmail("ram@gmail.com");
		person.setMobile(9876543210l);

		AadharDTO aadhar = new AadharDTO();
		aadhar.setAadharNumber(123456789876l);

		person.setAadhar(aadhar);
		aadhar.setPerson(person);

		openConnection();
		entityTransaction.begin();

		entityManager.persist(aadhar);
		entityManager.persist(person);

		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("person");
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
