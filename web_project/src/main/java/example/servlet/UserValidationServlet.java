package example.servlet;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;

import example.bean.User;
import example.bean.UserValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/doValidate")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		//capturing values of 2 request parameters : uid,pwd
		String userId = request.getParameter("uid");
		String password= request.getParameter("pwd");
		
		//creating a user object based upon userId password
		User currentUser = new User(userId,password);
		//Passing current er object to userValidator's isValid() method for checking the validity
		boolean valid = UserValidator.isValid(currentUser);
		
		
		String successResponse="<h1 style='color:#ffafcc'>✅ Congratulations!! you are IN</h1>";
		String failureResponse="<h1 style='color:red'>❎ So Sorry!! access denied due to invalid credentials </h1>";
		
		if(valid)
			out.println(successResponse);
		else
			out.println(failureResponse);
		
//		if(userId.equals("admin") && password.equals("phoenix123"))
//			out.println(successResponse);
//		else
//			out.println(failureResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
