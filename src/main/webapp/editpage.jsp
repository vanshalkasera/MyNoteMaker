<%@page import="com.entity.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Udate Page</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">
  		 <%@include file="navbar.jsp" %>
  		 <br>
  		 <h1>Here You Can Update Your Notes</h1>
  		 
  		<% int updateid=Integer.parseInt(request.getParameter("updid").trim());
  		 Session s=FactoryProvider.getFatory().openSession();
  		 Note n=(Note) s.get(Note.class, updateid);
  		 %>
  		 <form action="UpdateNote" method="post">
  		 <input value="<%=n.getId() %>" type="hidden" name="fetchedId">
		<div class="form-group">
			<label for="title">Note title</label> 
			<input name="title" required type="text" class="form-control" id="title"
				aria-describedby="emailHelp" placeholder="Enter here" value="<%=n.getTitle()%>">
		</div>
		<div class="form-group">
			<label for="content">Note Content</label> 
			<textarea name="content" required id="content" placeholder="Enter Your Content Here" class="form-control" style= "height: 300px"><%=n.getContent() %></textarea>
		</div>
		<div class="container text-center"><button type="submit" class="btn btn-success">Update Note</button></div>
	</form>
  	</div>

</body>
</html>