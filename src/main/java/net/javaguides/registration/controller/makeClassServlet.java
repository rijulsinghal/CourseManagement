package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.MakeClassDao;
import net.javaguides.registration.model.MakeClass;

@WebServlet("/makeClass")
public class makeClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MakeClassDao makeclassdao = new MakeClassDao();
    public makeClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/makeClass.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Class_Name = request.getParameter("ClassName");
		String Course_Code = request.getParameter("ClassCode");
		String Generate_Code = request.getParameter("GenerateCode");
		
		MakeClass makeclass = new MakeClass();
		makeclass.setClassname(Class_Name);
		makeclass.setCoursecode(Course_Code);
		makeclass.setClasscode(Generate_Code);
		
		int result = makeclassdao.makeclass(Class_Name, Generate_Code, Course_Code,request);
		if(result == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/teacher.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
