package net.javaguides.registration.dao;


import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.UploadAssignment;

public class UploadAssignmentDao extends Session{

	public int UploadAssignment(UploadAssignment uploadAssignment) {
		
		try {
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Assignments");
        
        Document document = new Document();
        

        document.append("Teacher-Name", session.getAttribute("TeacherName"));
        document.append("Teacher-Username", session.getAttribute("TeacherUsername"));
        document.append("Problem-Statement", uploadAssignment.getProblemStatement());
        document.append("Problem-Description", uploadAssignment.getProblemDescription());
        document.append("Course-Code", uploadAssignment.getCourseCode());
        document.append("Class-Name", uploadAssignment.getClassName());
        document.append("Deadline", uploadAssignment.getDate());
        
        col.insertOne(document);
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		return 1;
        
   }
	
}
