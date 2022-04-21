package net.javaguides.registration.dao;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.signup;

public class signupDao {
	
	public void addCredentials(signup signup){
		

		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Credentials");
        
		Document document = new Document();
		document.append("fullname", signup.getFullname());
		document.append("username", signup.getUsername());
		document.append("password", signup.getPassword());
		
		col.insertOne(document);
		
		return;
	}

}
