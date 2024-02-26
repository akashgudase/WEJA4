package com.jspiders.manytomany.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.CourseDTO;
import com.jspiders.manytomany.dto.StudentDTO;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {

		StudentDTO student1 = new StudentDTO();
		student1.setName("Amar");
		student1.setEmail("amar@gmail.com");
		student1.setMobile(9876543210l);

		StudentDTO student2 = new StudentDTO();
		student2.setName("Rani");
		student2.setEmail("rani@gmail.com");
		student2.setMobile(9876543211l);

		CourseDTO course1 = new CourseDTO();
		course1.setName("SQL");
		course1.setFees(10000.00);

		CourseDTO course2 = new CourseDTO();
		course2.setName("CORE JAVA");
		course2.setFees(15000.00);

		CourseDTO course3 = new CourseDTO();
		course3.setName("WEB TECH");
		course3.setFees(20000.00);

		student1.setCourses(Arrays.asList(course1, course2));
		student2.setCourses(Arrays.asList(course2, course3));

		openConnection();
		entityTransaction.begin();

		entityManager.persist(student1);
		entityManager.persist(student2);

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
