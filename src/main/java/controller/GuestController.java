package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.*;

/**
 * Servlet implementation class GuestController
 */
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String guestICNumber;
	private String action = "", forward = "";
	private static String LIST = "staffGuestList.jsp";
	private static String VIEW = "guestView.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		action = request.getParameter("action");

		if (action.equalsIgnoreCase("view")) {
			forward = VIEW;
			// get bookingId from the request
			String ICNumber = request.getParameter("ICNumber");
			// set attribute to a servlet request and call getCustomerBooking() method in
			// BookingDAO 

			request.setAttribute("guest", GuestDAO.getGuestById(guestICNumber));
			RequestDispatcher view = request.getRequestDispatcher("guestProfile.jsp");
			view.forward(request, response);
		}

		if (action.equalsIgnoreCase("list")) {
			forward = LIST;

			// set attribute to a servlet request and call getCustomerBookings() method in
			// BookingDAO
			request.setAttribute("bookings", BookingDAO.getCustomerBookings());
			RequestDispatcher view = request.getRequestDispatcher("bookingList.jsp");
			view.forward(request, response);
		}

		if (action.equalsIgnoreCase("delete")) {
			forward = LIST;
			// get bookingId from the request
			int idbookingId = Integer.parseInt(request.getParameter("bookingId"));
			// invoke method deleteBooking() in BookingDAO
			dao.deleteBooking(bookingId);

			// set attribute to a servlet request and call getCustomerBookings() method in
			// BookingDAO
			request.setAttribute("bookings", BookingDAO.getCustomerBookings());
			RequestDispatcher view = request.getRequestDispatcher("bookingList.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
