package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Register Servlet");
		PrintWriter out=response.getWriter();
		out.print("<h3>"+"Welcome to Java Server side Programming"+"</h3>");
		//Fetch Data from input tag in Html/Jsp
		String username=request.getParameter("username");
		String pass=request.getParameter("password");
        String doj = request.getParameter("doj");	
        System.out.println(doj);
		String salary=request.getParameter("salary");
        User user=new User();
		user.setUsername(username);
        user.setPassword(pass);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
			user.setDateOfBirth(sdf.parse(doj));
		} catch (ParseException e) {
			System.out.println("Enter only yyyy-MM-dd");
		}
        user.setSalary(Double.parseDouble(salary));
        request.setAttribute("employee",user);
        //pass data from servlets to jsp/html page
		request.setAttribute("user1",username);
		request.setAttribute("pass1",pass);
		
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
