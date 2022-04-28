package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.postQueryDao;
import net.javaguides.registration.model.postQuery;

@WebServlet("/postQuery")
public class postQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private postQueryDao postquerydao = new postQueryDao();
    public postQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PostQuery.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ClassName = request.getParameter("ClassName");
		String CourseCode = request.getParameter("CourseCode");
		String Query = request.getParameter("Query");
		
		postQuery postquery = new postQuery();
		postquery.setClassName(ClassName);
		postquery.setCourseCode(CourseCode);
		postquery.setQuery(Query);
		
		int result = postquerydao.postQuery(postquery);
		if(result == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentdash.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
