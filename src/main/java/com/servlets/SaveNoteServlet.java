package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			
		String  title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Note note=new Note(title, content,new Date());
		
		Session s=FactoryProvider.getFatory().openSession();
		Transaction transact=s.beginTransaction();
		
		
		s.save(note);
		transact.commit();
		s.close();
		out.println("<!doctype html>\r\n"
					+ "<html lang='en'>\r\n"
					+ "  <head>\r\n"
					+ "    <!-- Required meta tags -->\r\n"
					+ "    <meta charset='utf-8'>\r\n"
					+ "    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>\r\n"		
					+ " <title>Todo-maker : Home</title>\r\n"
					+ " 	    <!-- Bootstrap CSS -->\r\n"
					+ "    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>\r\n"
					+ " <link href='css/style.css' rel='stylesheet'/> \r\n"
					+ " <!-- Optional JavaScript -->\r\n"
					+ "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n"
					+ "    <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>\r\n"
					+ "    <script src='https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>\r\n"
					+ "    <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script> \r\n"
					+ "  </head>\r\n"
					+ "  <body>"
					+ "<div class='container'>\r\n"
					+ "  		 <nav class='navbar navbar-expand-lg navbar-dark purple'>\r\n"
					+ "  <a class='navbar-brand' href='index.jsp'>Todo-maker</a>\r\n"
					+ "  <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>\r\n"
					+ "    <span class='navbar-toggler-icon'></span>\r\n"
					+ "  </button>\r\n"
					+ "  <div class='collapse navbar-collapse' id='navbarSupportedContent'>\r\n"
					+ "    <ul class='navbar-nav mr-auto'>\r\n"
					+ "      <li class='nav-item active'>\r\n"
					+ "        <a class='nav-link' href='index.jsp'>Home <span class='sr-only'>(current)</span></a>\r\n"
					+ "      </li>\r\n"
					+ "      <li class='nav-item active'>\r\n"
					+ "        <a class='nav-link' href='add_notes.jsp'>Add Note</a>\r\n"
					+ "      </li>\r\n"
					+ "      <li class='nav-item active'>\r\n"
					+ "        <a class='nav-link' href='all_notes.jsp'>Show Notes</a>\r\n"
					+ "      </li>\r\n"
					+ "    </ul>\r\n"
					+ "    <form class='form-inline my-2 my-lg-0'>\r\n"
					+ "      <input class='form-control mr-sm-2' type='search' placeholder='Search' aria-label='Search'>\r\n"
					+ "      <button class='btn btn-outline-light my-2 my-sm-0' type='submit'>Search</button>\r\n" 	
					+ "    </form>\r\n"
					+ "  </div>\r\n"
					+ "</nav>"
					+ "  	\r\n"
					+ "  	<br>\r\n"
					+ "  	<!--this is add form  -->\r\n"
					+ "	 <form action='SaveNoteServlet' method='post'>\r\n"
					+ "		<div class='form-group'>\r\n"
					+ "			<label for='title'>Note title</label> \r\n"
					+ "			<input name='title' required type='text' class='form-control' id='title'\r\n"
					+ "				aria-describedby='emailHelp' placeholder='Enter here'>\r\n"
					+ "		</div>\r\n"
					+ "		<div class='form-group'>\r\n"
					+ "			<label for='content'>Note Content</label> \r\n"
					+ "			<textarea name='content' required id='content' placeholder='Enter Your Content Here' class='form-control' style= 'height: 300px'></textarea>\r\n"
					+ "		</div>\r\n"
					+ "		<div class='container text-center'><button type='submit' class='btn btn-primary'>Add</button></div>\r\n"
					+ "		\r\n"
					+ " <h1 class='text-success text-center'>Added Successfully</h1>\r\n"
					+ "	</form> \r\n"
					+ "	</div>\r\n"
					+ "	\r\n"
					+ "</body>\r\n"
					+ "</html>");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
