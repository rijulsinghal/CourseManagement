package net.javaguides.registration.dao;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.bson.Document;

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
        if((checkboxval == null)) {
        	col = db.getCollection("Credentials");
            
        }else{
        	col = db.getCollection("TeacherCredentials");
            
        }
        
        FindIterable<Document> iterDoc = col.find();
        
        boolean isfound = false;
        
        for(Document d:iterDoc) {
        	System.out.println(d);
        	if(d.getString("username").equals(username) && d.getString("password").equals(password)) {
        		if(checkboxval != null) {
        			TeacherName = d.getString("name ");
        		}
        		isfound = true;
        	}
        }
        
        if(isfound && checkboxval != null) {
        	session = request.getSession();
        	session.setAttribute("TeacherUsername", username);
        	session.setAttribute("TeacherName", TeacherName);
        	
        	return 2;
        }
        
        if(isfound) {
        	
        	return 1;
	    }
		
		return 0;
	}

}
