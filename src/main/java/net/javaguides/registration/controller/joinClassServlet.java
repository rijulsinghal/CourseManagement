package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.model.joinclass;
import net.javaguides.registration.dao.joinclassdao;

@WebServlet("/joinclass")
public class joinClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private joinclassdao  joinclassdao = new joinclassdao();  
    public joinClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/joinclass.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ClassCode = request.getParameter("ClassCode");
		System.out.println(ClassCode);
		joinclass joinclass = new joinclass();
		joinclass.setClassCode(ClassCode);
		int result = joinclassdao.joinClass(joinclass);
		System.out.println("result is: " + result);
		if(result == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentdash.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
