package net.javaguides.registration.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.joinclass;

public class joinclassdao extends Session{

	public int joinClass(joinclass joinclass) {
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Classes");
        
        FindIterable<Document> iterDoc = col.find();
        boolean isfound = false;
        try {
	        for(Document d:iterDoc) {
	        	System.out.println(d);
	        	if(d.getString("ClassCode").equals(joinclass.getClassCode())) {
	        		isfound = true;
	        		Document document = new Document();
	        		document.append("StudentName",  session.getAttribute("StudentName"));
	        		document.append("StudentUsername", session.getAttribute("StudentUsername"));
	        		document.append("TeacherName", d.getString("TeacherName"));
	        		document.append("TeacherUsername", d.getString("TeacherUsername"));
	        		document.append("ClassName", d.getString("ClassName"));
	        		document.append("CourseCode", d.getString("CourseCode"));
	        		document.append("ClassCode", d.getString("ClassCode"));
	        		
	        		System.out.println(document);
	        		
	        		db.getCollection("Student").insertOne(document);
	        		client.close();
	        		return 1;
	        	}
	        }
        }catch(Exception e) {
    		return 0;	
        }
        return 0;
        
	}
	
}
