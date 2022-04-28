package net.javaguides.registration.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.javaguides.registration.dao.UploadAssignmentDao;
import net.javaguides.registration.model.UploadAssignment;

@WebServlet("/uploadAssignment")
public class AssignmentUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UploadAssignmentDao uploadassignmentdao = new UploadAssignmentDao();
	
    public AssignmentUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/uploadAssignment.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ClassName = request.getParameter("ClassName");
		String ProblemStatement = request.getParameter("Statement");
		String ProblemDescription = request.getParameter("Description");
		String ClassCode = request.getParameter("CourseCode");
		String Deadline = request.getParameter("DeadlineDate");
		String Code = request.getParameter("GenerateCode");
		
		System.out.println(ClassName);
		System.out.println(ProblemStatement);
		System.out.println(ProblemDescription);
		System.out.println(Deadline);
		
		
		UploadAssignment uploadAssignment = new UploadAssignment();
		uploadAssignment.setClassName(ClassName);
		uploadAssignment.setProblemDescription(ProblemDescription);
		uploadAssignment.setProblemStatement(ProblemStatement);
		uploadAssignment.setCourseCode(ClassCode);
		uploadAssignment.setDate(Deadline);
		uploadAssignment.setCode(Code);
		
		int result = uploadassignmentdao.UploadAssignment(uploadAssignment);
		if(result == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/teacher.jsp");
			dispatcher.forward(request, response);
		
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error.jsp");
			dispatcher.forward(request, response);
		
		}
		
		
	}

}
