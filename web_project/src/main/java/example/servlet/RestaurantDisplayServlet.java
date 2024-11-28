package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.Restaurant;

/**
 * Servlet implementation class RestaurantDisplayServlet
 */
@WebServlet("/display")
public class RestaurantDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Object obj =request.getAttribute("searchRestaurant");
	//obj.getName();
	Restaurant currentRestaurant =(Restaurant)obj;
	String name =currentRestaurant.getName();
	String cuisine =currentRestaurant.getCuisine();
	int branchCount = currentRestaurant.getBranchCount();
	out.println("<h1>Restaurant Details: </h1>");
	out.println("<h2>Name: "+ name +"</h2>");
	out.println("<h2>Cuisine: "+ cuisine +"</h2>");
	out.println("<h2>branchCount: "+ branchCount +"</h2>");
	
	
	}

}
