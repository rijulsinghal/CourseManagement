package net.javaguides.registration.dao;



import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MakeClassDao extends Session {

	public int makeclass(String classname , String classcode , String coursecode,HttpServletRequest request) {
		
		try {
			MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
	        MongoDatabase db = client.getDatabase("CourseManagement");
	        MongoCollection col = db.getCollection("Classes");
	        
	        Document document = new Document();
	        document.append("TeacherName", session.getAttribute("TeacherName"));
	        document.append("TeacherUsername", session.getAttribute("TeacherUsername"));
	        document.append("ClassName", classname);
	        document.append("ClassCode", classcode);
	        document.append("CourseCode", coursecode);
	        
	        System.out.println("TeacherName is: " + session.getAttribute("TeacherName"));
	        System.out.println("TeacherUserName is: " + session.getAttribute("TeacherUsername"));
	        
	        col.insertOne(document);
	        client.close();
	    }
		catch(Exception e) {
			return 0;
		}
		
		return 1;
		
	}
	
}
