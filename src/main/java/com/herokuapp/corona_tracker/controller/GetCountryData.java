package com.herokuapp.corona_tracker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.herokuapp.corona_tracker.model.LatestStatByCountryList;

/**
 * Servlet implementation class GetCountryData
 */
public class GetCountryData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country_name");
		APIController controller = new APIController(
				getServletContext().getInitParameter("host"),
				getServletContext().getInitParameter("key"));
	 	LatestStatByCountryList list = controller.getLatestStatByCountry(country);
	 	request.getSession().setAttribute("country_data", list);
	 	response.sendRedirect("country_data.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
