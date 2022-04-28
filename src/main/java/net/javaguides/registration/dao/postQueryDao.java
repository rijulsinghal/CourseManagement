package net.javaguides.registration.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.javaguides.registration.model.postQuery;

public class postQueryDao extends Session{

	public int postQuery(postQuery postquery) {
		
		MongoClient client = MongoClients.create("mongodb+srv://admin:admin1234@cluster0.jq3gg.mongodb.net/CourseManagement?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("CourseManagement");
        MongoCollection col = db.getCollection("Student");
        
        FindIterable<Document> iterDoc = col.find();
        System.out.println(session.getAttribute("StudentName"));
        try {
	        for(Document d:iterDoc) {
	        	System.out.println(d);
	        	System.out.println(session.getAttribute("StudentName"));
	        	if(d.getString("StudentName").equals(session.getAttribute("StudentName")) && d.getString("ClassName").equals(postquery.getClassName())
	        			&& d.getString("CourseCode").equals(postquery.getCourseCode())) {
	        		Document document = new Document();
	        		document.append("StudentName",  d.getString("StudentName"));
	        		document.append("StudentUsername", session.getAttribute("StudentUsername"));
	        		document.append("ClassName", d.getString("ClassName"));
	        		document.append("CourseCode", d.getString("CourseCode"));
	        		document.append("TeacherName", d.getString("TeacherName"));
	        		document.append("TeacherUsername", d.getString("TeacherUsername"));
	        		document.append("ClassCode", d.getString("ClassCode"));
	        		
	        		document.append("Query", postquery.getQuery());
	        		System.out.println(document);
	        		
	        		db.getCollection("Query").insertOne(document);
	        		return 1;
	        	}
	        }
        }catch(Exception e) {
        	return 0;
        }
        
        return 0;
	}
	
}
