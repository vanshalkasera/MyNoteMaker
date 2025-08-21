import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Note;
import com.helper.FactoryProvider;


public class UpdateNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteIdd=Integer.parseInt(request.getParameter("fetchedId").trim());
			Session s=FactoryProvider.getFatory().openSession();
			Transaction tx=s.beginTransaction();
			
			
			Note n= (Note) s.get(Note.class,noteIdd);
			
			n.setTitle(title);
			n.setContent(content);
			n.setDate(new Date());
			tx.commit();
			s.close();
			
			response.sendRedirect("all_notes.jsp");
		}
		catch(Exception e) {
			
		e.printStackTrace();
		}
	}

}
