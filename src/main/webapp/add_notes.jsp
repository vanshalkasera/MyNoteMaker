<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.util.Date"%>
<%@page import="com.entity.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="all_js_css.jsp" %>
<title>Add Notes</title>
</head>
<body>
	<div class="container">
  		 <%@include file="navbar.jsp" %>
  	
  	<br>
  	<!--this is add form  -->
	 <form action="SaveNoteServlet" method="post">
		<div class="form-group">
			<label for="title">Note title</label> 
			<input name="title" required type="text" class="form-control" id="title"
				aria-describedby="emailHelp" placeholder="Enter here">
		</div>
		<div class="form-group">
			<label for="content">Note Content</label> 
			<textarea name="content" required id="content" placeholder="Enter Your Content Here" class="form-control" style= "height: 300px"></textarea>
		</div>
		<div class="container text-center"><button type="submit" class="btn btn-primary">Add</button></div>
	</form> 
	</div>
	
</body>
</html>