package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.signupDao;
import net.javaguides.registration.model.signup;

@WebServlet("/signup")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private signupDao signupdao = new signupDao();
       
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		
		if(password.equals(re_password)) {
			signup signup = new signup();
			signup.setFullname(fullname);
			signup.setUsername(username);
			signup.setPassword(password);
			signup.setRepassword(re_password);
			
			try {
				int result = signupdao.addCredentials(signup);
				if(result == 2) {
					System.out.println("Account Exist!");
				}
				if(result == 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
