package com.jspiders.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany.dto.CompanyDTO;
import com.jspiders.onetomany.dto.EmployeeDTO;

public class CompanyDAO4 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		openConnection();
		entityTransaction.begin();
		
		CompanyDTO company = entityManager.find(CompanyDTO.class, 2);
		List<EmployeeDTO> employees = company.getEmployees();
		EmployeeDTO employeeToBeDeleted = null;
		for (EmployeeDTO employee : employees) {
			if(employee.getId() == 8) {
				employeeToBeDeleted = employee;
				break;
			}
		}
		employees.remove(employeeToBeDeleted);
		company.setEmployees(employees);
		entityManager.persist(company);
		
		entityManager.remove(employeeToBeDeleted);

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
