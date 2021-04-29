package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.StaffServiceImpl;
import com.service.IStaffService;

/**
 * Servlet implementation class DeleteStaffServlet
 */
@WebServlet("/DeleteStaffServlet")
public class DeleteStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStaffServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String staffID = request.getParameter("staffID");
		IStaffService iStaffService = new StaffServiceImpl();
		iStaffService.removeStaff(staffID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStaff.jsp");
		dispatcher.forward(request, response);
	}

}
