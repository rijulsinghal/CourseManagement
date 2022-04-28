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
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Classes");
        
        Document document = new Document();
        
        FindIterable<Document> iterDoc = col.find();
        boolean isfound = false;
        
        for(Document d:iterDoc) {
        	System.out.println(d);
        	if(d.getString("TeacherUsername").equals(session.getAttribute("TeacherUsername")) && 
        			d.getString("TeacherName").equals(session.getAttribute("TeacherName")) &&
        			d.getString("ClassName").equals(uploadAssignment.getClassName()) &&
        			d.getString("CourseCode").equals(uploadAssignment.getCourseCode())) 
        	{
        	
        		document.append("Teacher-Name", session.getAttribute("TeacherName"));
                document.append("Teacher-Username", session.getAttribute("TeacherUsername"));
                document.append("Problem-Statement", uploadAssignment.getProblemStatement());
                document.append("Problem-Description", uploadAssignment.getProblemDescription());
                document.append("Course-Code", uploadAssignment.getCourseCode());
                document.append("Class-Name", uploadAssignment.getClassName());
                document.append("Deadline", uploadAssignment.getDate());
                document.append("ClassCode", d.getString("ClassCode"));
                document.append("Code", uploadAssignment.getCode());
                
                
                isfound = true;
                
        	}
        }
        
        if(isfound) {
        	db.getCollection("Assignments").insertOne(document);
        	return 1;
        }else {
        	return 0;
        }
        
   }
	
}
