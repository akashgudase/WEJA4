package com.jspiders.onetomanybi.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.CompanyDTO;
import com.jspiders.onetomanybi.dto.EmployeeDTO;

public class CompanyDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		CompanyDTO company = new CompanyDTO();
		company.setName("Tata");
		company.setLocation("Pune");

		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setName("Raj");
		employee1.setEmail("raj@gmail.com");
		employee1.setMobile(9876543210l);
		employee1.setCompany(company);

		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setName("Rahul");
		employee2.setEmail("rahul@gmail.com");
		employee2.setMobile(9876543211l);
		employee2.setCompany(company);

		company.setEmployees(Arrays.asList(employee1, employee2));

		openConnection();
		entityTransaction.begin();

		entityManager.persist(company);

		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("company");
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
