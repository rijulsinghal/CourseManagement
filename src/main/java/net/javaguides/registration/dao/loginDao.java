package net.javaguides.registration.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.login;

public class loginDao extends  Session{
	
	public int checkCredentials(login login,HttpServletRequest request) {
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col;
        
        String username = login.getUsername();
        String password = login.getPassword();
        String checkboxval = login.getcheckboxval();
        String TeacherName = "";
        String StudentName = "";
        if((checkboxval == null)) {
        	col = db.getCollection("Credentials");
            
        }else{
        	col = db.getCollection("TeacherCredentials");
            
        }
        
        FindIterable<Document> iterDoc = col.find();
        
        int isfound = 0;
        
        for(Document d:iterDoc) {
//        	System.out.println(d);
        	if(d.getString("username").equals(username) && d.getString("password").equals(password)) {
        		if(checkboxval != null) {
        			TeacherName = d.getString("name ");
            		isfound = 1;
        		}else {
        			StudentName = d.getString("fullname");
            		isfound = 2;
        		}
        	}
        }
        
        if(isfound == 1) {
        	session = request.getSession();
        	session.setAttribute("TeacherUsername", username);
        	session.setAttribute("TeacherName", TeacherName);
        	
        	// Getting Class Info
        	List<Document> ClassInfo = new ArrayList<Document>();
        	List<Document> Assignments = new ArrayList<Document>();
        	List<Document> Query = new ArrayList<Document>();
        	
        	
        	iterDoc = db.getCollection("Classes").find();
        	for(Document d:iterDoc) {
            	System.out.println(d);
            	if(d.getString("TeacherUsername").equals(username)) {
            		ClassInfo.add(d);
            	}
            }
        	
        	iterDoc = db.getCollection("Assignments").find();
        	for(Document d:iterDoc) {
            	System.out.println(d);
            	if(d.getString("Teacher-Username").equals(username)) {
            		Assignments.add(d);
            	}
            }
        	
        	iterDoc = db.getCollection("Query").find();
        	for(Document d:iterDoc) {
            	System.out.println(d);
            	if(d.getString("TeacherUsername").equals(username)) {
            		Query.add(d);
            	}
            }
        	
//
        	session.setAttribute("Assignments", Assignments);
        	session.setAttribute("ClassInfo", ClassInfo);
        	session.setAttribute("Query", Query);
        	client.close();
        	return 2;
        }
        
        else if(isfound == 2) {
        	session = request.getSession();
        	session.setAttribute("StudentUsername", username);
        	session.setAttribute("StudentName", StudentName);
        	
        	
//        	Getting Classes;
        	
        	col = db.getCollection("Student");
        	List<String> ClassCode = new ArrayList<String>();
        	iterDoc = col.find();
        	
        	for(Document d:iterDoc) {
//            	System.out.println(d);
            	if(d.getString("StudentUsername").equals(username) && d.getString("StudentName").equals(StudentName)) {
            		ClassCode.add(d.getString("ClassCode"));
            	}
            }
        	
        	List<Document> ClassInfo = new ArrayList<Document>();
        	
        	for(String i:ClassCode) {
        		
        		BasicDBObject query = new BasicDBObject(); 
        		query.put("ClassCode", i);
        		
        		FindIterable<Document> cursor = db.getCollection("Classes").find(query);
        		for(Document d:cursor) {
//                	System.out.println(d);
                	ClassInfo.add(d);
                	
                }
        		
        	}
        	
        	session.setAttribute("ClassInfo", ClassInfo);
        	
//        	Getting Assignments 
        	List<Document> Assignments = new ArrayList<Document>();
        	for(String i:ClassCode) {
        		
        		BasicDBObject query = new BasicDBObject(); 
        		query.put("ClassCode", i);
        		
        		FindIterable<Document> cursor = db.getCollection("Assignments").find(query);
        		for(Document d:cursor) {
//                	System.out.println(d);
                	Assignments.add(d);
                	
                }
        		
        	}
        	
        	session.setAttribute("Assignments", Assignments);
        	client.close();
        	return 1;
	    }
		
		return 0;
	}

}
