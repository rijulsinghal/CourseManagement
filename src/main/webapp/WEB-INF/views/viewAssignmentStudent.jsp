<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My-Assignments</title>
</head>
<style>
	.flex-container {
	  display: flex;
	  flex-wrap: nowrap;
	}
      table {
      	padding:20px;
      	margin:30px;
      	margin-left:80px;
      	font-size:22px;
      	text-align:center;
  		border: 5px solid #FFC312;
  		width: 40%;
  		height: 40%;
	  }
	
	 th, td {
       padding: 8px;
       text-align: left;
       border-bottom: 1px solid #DDD;
     }

     tr:hover {background-color: #D6EEEE;}

</style>

  <body>
  <h1 style="text-align:center;">My-Assignments</h1>
  		<div class = "flex-container">
  		  	<c:forEach items="${Assignments}" var="item">
		    		<table>
					  <tr>
					    <td>Teacher-Name</td>
					    <td>${item.getString('Teacher-Name')}</td>
					  </tr>
					  <tr>
					    <td>Class-Name</td>
					    <td>${item.getString('Class-Name')}</td>
					  </tr>
					  <tr>
					    <td>Course-Code</td>
					    <td>${item.getString('Course-Code')}</td>
					  </tr>
					  <tr>
					    <td>Problem-Statement</td>
					    <td>${item.getString('Problem-Statement')}</td>
					  </tr>
					  <tr>
					    <td>Problem-Description</td>
					    <td>${item.getString('Problem-Description')}</td>
					  </tr>
					  <tr>
					    <td>Deadline</td>
					    <td>${item.getString('Deadline')}</td>
					  </tr>
					  <tr>
					    <td>Assignment-Id</td>
					    <td>${item.getString('Code')}</td>
					  </tr>
					  
				</table>
		      		
		   </c:forEach>
	  	</div>
	  	
	  	

  </body>
</html>