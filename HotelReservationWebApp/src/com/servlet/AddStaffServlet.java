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
 * Servlet implementation class AddStaffServlet
 */
@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStaffServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Staff staff = new Staff();

		staff.setName(request.getParameter("staffName"));
		staff.setAddress(request.getParameter("address"));
		staff.setOccupation(request.getParameter("occupation"));
		staff.setEmail(request.getParameter("email"));
		staff.setPhone(request.getParameter("phone"));
		staff.setUserName(request.getParameter("userName"));
		staff.setGender(request.getParameter("gender"));

		IStaffService iStaffService = new StaffServiceImpl();
		iStaffService.addStaff(staff);

		request.setAttribute("staff", staff);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStaff.jsp");
		dispatcher.forward(request, response);
	}
}
