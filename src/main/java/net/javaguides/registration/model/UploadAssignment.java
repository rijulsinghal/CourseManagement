package net.javaguides.registration.model;

import java.io.InputStream;

public class UploadAssignment {

	String ClassName;
	String ProblemStatement;
	String ProblemDescription;
	String CourseCode;
	String Date;
	String Code;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getProblemStatement() {
		return ProblemStatement;
	}
	public void setProblemStatement(String problemStatement) {
		ProblemStatement = problemStatement;
	}
	public String getProblemDescription() {
		return ProblemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		ProblemDescription = problemDescription;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
}
