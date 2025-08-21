<%@page import="java.util.List"%>
<%@page import="com.entity.Note"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="all_js_css.jsp" %>
<title>All notes : Todo-maker</title>
</head>
<body>
	<div class="container">
  		 <%@include file="navbar.jsp" %>
  		 <br>
  		 <h1 class="text-uppercase">All Notes: </h1>
  		 <div class="row">
  		 	<div class="col-12">
  		 	<%   Session s=FactoryProvider.getFatory().openSession();
  		 			Query<Note> q=s.createQuery("from Note",Note.class);
  		 			List<Note> l=q.list();
  		 			for(Note n : l){
  		 	%>
				<div class="card m-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px" src="img/note.png" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%out.println(n.getTitle());%></h5>
						<p class="card-text"><%out.println(n.getContent()); %></p>
						<p><b>Last updated at:&nbsp;<b class="text-primary"><%=n.getDate() %></b></p>
						
						<div class="continer text-center">
						<a href="DeleteServlet?id=<%=n.getId() %>" class="btn btn-danger">Delete</a>
						<a href="editpage.jsp?updid=<%=n.getId()%>" class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>
				<%
				}
				s.close();
				%>
  		 	
  		 	</div>
  		 </div>

  	</div>
</body>
</html>