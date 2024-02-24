package com.jspiders.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.CompanyDTO;
import com.jspiders.onetomany.dto.EmployeeDTO;

public class CompanyDAO3 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		CompanyDTO company = new CompanyDTO();
		company.setName("Tata");
		company.setLocation("Pune");

		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setName("Ramesh");
		employee1.setEmail("ramesh@gmail.com");
		employee1.setMobile(9876543210l);

		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setName("Suresh");
		employee2.setEmail("suresh@gmail.com");
		employee2.setMobile(9876543211l);

		EmployeeDTO employee3 = new EmployeeDTO();
		employee3.setName("Mahesh");
		employee3.setEmail("mahesh@gmail.com");
		employee3.setMobile(9876543212l);

		EmployeeDTO employee4 = new EmployeeDTO();
		employee4.setName("Umesh");
		employee4.setEmail("umesh@gmail.com");
		employee4.setMobile(9876543213l);

		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);

		company.setEmployees(employees);

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
