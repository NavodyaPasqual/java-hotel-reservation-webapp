package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStaffServlet
 */
@WebServlet("/ListStaffServlet")
public class ListStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListStaffServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStaff.jsp");
		dispatcher.forward(request, response);
	}

}
