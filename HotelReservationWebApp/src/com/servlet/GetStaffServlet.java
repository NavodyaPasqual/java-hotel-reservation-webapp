package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Staff;
import com.service.StaffServiceImpl;
import com.service.IStaffService;

/**
 * Servlet implementation class GetStaffServlet
 */
@WebServlet("/GetStaffServlet")
public class GetStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetStaffServlet() {
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
		Staff staff = iStaffService.getStaffByID(staffID);

		request.setAttribute("staff", staff);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetStaff.jsp");
		dispatcher.forward(request, response);
	}

}
