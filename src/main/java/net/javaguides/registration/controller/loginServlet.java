package net.javaguides.registration.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.loginDao;
import net.javaguides.registration.model.login;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private loginDao logindao = new loginDao();
    public loginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String checkboxval = request.getParameter("teacherlogin");
		System.out.println("checkboxval is: " + checkboxval);
		
		login login = new login();
		login.setPassword(password);
		login.setUsername(username);
		login.setcheckboxval(checkboxval);
		
		int result = logindao.checkCredentials(login,request);
		if(result == 1) {
			//TODO --> MAP TO STUDENT DASHBOARD;
			
			System.out.println("Account Verified!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentdash.jsp");
			dispatcher.forward(request, response);
			
		}
		else if(result == 2) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/teacher.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			System.out.println("Account Not Verified!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
