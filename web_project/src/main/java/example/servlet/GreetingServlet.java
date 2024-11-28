package example.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init() {
		System.out.println("Inside init()");
	}
	@Override
	public void destroy() {
		System.out.println("Inside Destroy");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//this method gets invoked when the servlet is requested
		//this method is sending HTML response back to client
		//setting the MIME type for HTML response
		//MIME =>Multi-purpose Internet MAil Extension(text/html)

		System.out.println("Inside doGet()");

		response.setContentType("text/html");
		//obtaining a writer object to send the response
		PrintWriter out = response.getWriter();
		//setting the responseText
		String responseText="<h1 style='color:red'>Welcome to Servlets</h1>";
		//sending the response
		out.println(responseText);
	}

}
