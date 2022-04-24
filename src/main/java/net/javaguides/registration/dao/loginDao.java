package net.javaguides.registration.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.login;

public class loginDao {
	
	public int checkCredentials(login login) {
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Credentials");
        
        String username = login.getUsername();
        String password = login.getPassword();
        
        FindIterable<Document> iterDoc = col.find();
        
        boolean isfound = false;
        
        for(Document d:iterDoc) {
        	if(d.getString("username").equals(username) && d.getString("password").equals(password)) {
        		isfound = true;
        	}
        }
        
        if(isfound) {
        	return 1;
	    }
		
		return 0;
	}

}
