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


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session=request.getSession();
//		if(session.getAttribute("name")!=null) {
//			
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst=con.prepareStatement("DELETE FROM livres WHERE id=?");
			pst.setInt(1, id);
//			pst.executeUpdate();
			
			int rows=pst.executeUpdate();
			if(rows==0) {
			
				out.println("<script> alert('Item deleted successfly')</script>");

			}else {
				System.out.println("Item didn't delete");
			}
			pst.close();
			con.close();
			
			response.sendRedirect("index.jsp");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
//		}else response.sendRedirect("login.jsp");
	
	
	
	
	
	
	
	
	}

	
}
