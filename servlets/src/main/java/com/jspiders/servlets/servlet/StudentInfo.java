package com.jspiders.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student_info")
public class StudentInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		int age = Integer.parseInt(req.getParameter("age"));
		String[] courses = req.getParameterValues("course");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<div align='center'><table border = '1px solid'>" + "<tr>" + "<td>Id</td>" + "<td>" + id
				+ "</td>" + "</tr>" + "<tr>" + "<td>Name</td>" + "<td>" + name + "</td>" + "</tr>" + "<tr>"
				+ "<td>Email</td>" + "<td>" + email + "</td>" + "</tr>" + "<tr>" + "<td>Mobile</td>" + "<td>" + mobile
				+ "</td>" + "</tr>" + "<tr>" + "<td>Age</td>" + "<td>" + age + "</td>" + "</tr>" + "</table></div>");

	}

}
