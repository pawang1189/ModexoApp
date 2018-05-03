package com.modexo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClockInClockOutServlet
 */
@WebServlet("/ClockInClockOutServlet")
public class ClockInClockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClockInClockOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = ClockInOut.validate(request.getParameter("empid"), request.getParameter("emppassword") );

		session = request.getSession();

		if (status) {
			session.setAttribute("session", "TRUE");
			session.setAttribute("empid", request.getParameter("empid")); //getAttribute in EmployeeHomePage.jsp
			ClockInOut.ClockInOutEntry(request.getParameter("empid"), request.getParameter("emppassword"));
			response.getWriter().append("<meta http-equiv='refresh' content='3;URL=clockinclockout.jsp'>"); //redirects after 3 seconds
			response.getWriter().append("<p style='color:green;'>Your Shift starts now..Have a great time</p>");
			//Meta refresh is a method of instructing a web browser to automatically refresh the current web page or frame after a given time interval, 
			//using an HTML meta element with the http-equiv parameter set to " refresh " and a content parameter giving the time interval in seconds.

		}
	}

}
