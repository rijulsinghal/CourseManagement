package net.javaguides.registration.dao;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.submitAssignment;

public class SubmitAssignmentDao extends Session{

	public int submitassignment(submitAssignment submitassignment) {
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("AssignmentSolution");
        
        Document document = new Document();
        document.append("AssignmentId", submitassignment.getAssignmentId());
        document.append("AssignmentSolution", submitassignment.getSolution());
        document.append("StudentName", session.getAttribute("StudentName"));
        document.append("StudentUserName", session.getAttribute("StudentUsername"));
        
        col.insertOne(document);
        client.close();
		
		return 1;
		
	}
	
}
