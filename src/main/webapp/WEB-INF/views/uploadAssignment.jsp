<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
	<title>Post Assignment</title>
  
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<style>

@import url('https://fonts.googleapis.com/css?family=Numans');

html,body{
background-image: url('https://i.pinimg.com/originals/3b/16/97/3b16973a3f2dc8323c0d0dbfbbafef73.jpg');
background-size: cover;
background-repeat: no-repeat;
font-family: 'Numans', sans-serif;
}

.container{
height: 95%;
align-content: center;
}

.card{
margin-top: auto;
margin-bottom: auto;
width:800px;
background-color: rgba(0,0,0,0.5) !important;
}

.social_icon span{
font-size: 60px;
margin-left: 10px;
color: #FFC312;
}

.social_icon span:hover{
color: white;
cursor: pointer;
}

.card-header h3{
color: white;
}

.social_icon{
position: absolute;
right: 20px;
top: -45px;
}

.input-group-prepend span{
width: 50px;
background-color: #FFC312;
color: black;
border:0 !important;
}

input:focus{
outline: 0 0 0 0  !important;
box-shadow: 0 0 0 0 !important;

}

.remember{
color: white;
}

.remember input
{
width: 20px;
height: 20px;
margin-left: 15px;
margin-right: 5px;
}

.login_btn{
color: black;
background-color: #FFC312;
width: 100px;
}

.login_btn:hover{
color: black;
background-color: white;
}

.links{
color: white;
}

.links a{
margin-left: 4px;
}
</style>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Post Assignment</h3>
			</div>
			<div class="card-body">
				<form action="<%= request.getContextPath() %>/uploadAssignment" method="post">
                    <div class="input-group form-group">
						<input type="text" class="form-control" name = "ClassName" placeholder="Class-Name">	
					</div>
					<div class="input-group form-group">
						<input type="text" class="form-control" name = "CourseCode" placeholder="Course-Code">	
					</div>
					<div class="input-group form-group">
						<textarea class="form-control"  name = "Statement" placeholder="Problem-Statement"></textarea>
					</div>
					<div class="input-group form-group">
						<textarea class="form-control"  style = "height:400px; width:400px;" name = "Description" placeholder="Problem-Description"></textarea>
					</div>
					<div class="input-group form-group">
						<h5 style = "color:white; height:20px;">Select DeadLine</h5>
						<input type="date" name = "DeadlineDate">
					</div>
		
					<div class="form-group">
						<input type="submit" value="Submit" class="btn float-right login_btn">
					</div>
					<div class="form-group">
						<input type="button" value="Back" class="btn float-left login_btn">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>