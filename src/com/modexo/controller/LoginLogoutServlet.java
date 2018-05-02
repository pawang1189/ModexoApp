package com.modexo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginLogoutServlet
 */
@WebServlet("/LoginLogoutServlet")
public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		String username = request.getParameter("empid");
		String password = request.getParameter("emppassword");
		String role = request.getParameter("role");
		
		boolean status = LoginOut.validate(username, password, role);
		if (status) {
			session.setAttribute("session", "TRUE");
			session.setAttribute("empid", Integer.parseInt(username));
//			response.sendRedirect("EmployeeHomePage.jsp"); 
			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeHomePage.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().append("Sorry, Employee ID or Password is incorrect");
		}

	}

}
