package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private static final String update="update livres set titre=? ,auteur=? ,disponible=? ,description=? ,image=? WHERE id=? ";
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session= request.getSession();	
		
		int id=Integer.parseInt(request.getParameter("id"));
		String titre=request.getParameter("titre");
		String auteur=request.getParameter("auteur");
		String disponible=request.getParameter("disponible");
		String description=request.getParameter("description");
		String image=request.getParameter("img");
		
		

		PrintWriter out=response.getWriter();
		
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String password="";
	
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement pst=con.prepareStatement(update);
			pst.setString(1, titre);
			pst.setString(2, auteur);
			pst.setString(3, disponible);
			pst.setString(4, description);
			pst.setString(5, image);
            pst.setInt(6, id);
            pst.executeUpdate();
			int count =pst.executeUpdate();
//		if(count==1) {
//			out.println("<h2> book updated successfly </h2>");
//		}else 		out.println("<h2>book didn't updated </h2>");

	
			response.sendRedirect("index.jsp");
		}catch(Exception e) {
		System.out.println("ther is an error at=>"+e);
		}
//	out.println("<a href='index.jsp'>List of books</a>");	
		}

}
