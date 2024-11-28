package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.bean.Restaurant;
import example.dao.DaoInterface;
import example.dao.RestaurantDao;

/**
 * Servlet implementation class RestaurantSearchServlet
 */
@WebServlet("/search")
public class RestaurantSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("r_id");
		int restaurantId= Integer.parseInt(id);
		DaoInterface <Restaurant,Integer> daoRef= new RestaurantDao();
		
		Restaurant foundRestaurant =daoRef.retrieveOne(restaurantId);
		
		if(foundRestaurant==null) {
			//obtain REquestDispatcher for search_restaurant.html
			//Display appropriate message and divert the control to that HTML
			RequestDispatcher dispatcher=
			request.getRequestDispatcher("search_restaurant.html");
			out.println("<h2>Restaurant with given ID not found.Please Try Again!!</h2>");
			dispatcher.include(request, response);
		}else {
			//Obtain RequestDispatcher for next servlet: /display
			RequestDispatcher dispatcher=
			request.getRequestDispatcher("display");
			//Attach the Restaurant data to the current request
			request.setAttribute("searchRestaurant",foundRestaurant);
			dispatcher.forward(request, response);
			//Forward the request to the next servlet 
		}
		
		//System.out.println("found Restaurant");
		
		
		
	}

}
