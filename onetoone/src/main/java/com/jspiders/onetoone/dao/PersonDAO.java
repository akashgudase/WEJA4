package com.jspiders.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoone.dto.AadharCardDTO;
import com.jspiders.onetoone.dto.PersonDTO;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		PersonDTO person = new PersonDTO();
		person.setName("Ramesh");
		person.setEmail("ramesh@gmail.com");
		person.setMobile(9876543210l);
		person.setAge(25);

		AadharCardDTO aadharCard = new AadharCardDTO();
		aadharCard.setAadharNumber(123456789876l);

		person.setAadharCard(aadharCard);

		openConnection();

		entityTransaction.begin();

		entityManager.persist(aadharCard);
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
