package com.coursemanagement.coursemanagement.controller;

public class StudentController {
    String studentName;    
    String studentId;
    int contactInfo;
    String email;
    String address;
    public void viewStudentInfo(int id){
        //select from database where id is the given ID then print
        System.out.println("Name:"+this.studentName+"\nID:"+this.studentId+"\nContact Info:"+this.contactInfo+"\nEmail:"+this.email+"\nAddress:"+this.address);
    }
    public void assignmentSubmit(){
        //add the uploaded file to the database
    }
    public void viewAssign(){
        //show the document selected
    }
    public void postQuery(){
        //takes to the query page and posts the required query
    }
    public String respondQuery(){
        // String query=input();
        // return query;
        return null;
    }
}
