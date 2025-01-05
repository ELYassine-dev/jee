package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Change_status
 */
@WebServlet("/Change_status")
public class Change_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String pass="";
		String book=request.getParameter("book");
		String disponible=request.getParameter("disponible");
	
		if(disponible.equalsIgnoreCase("availble")) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst=con.prepareStatement("update livres set disponible=? where titre=?");
		pst.setString(1,disponible);
		pst.setString(2,book);
		pst.executeUpdate();
		
		response.sendRedirect("index.jsp");
		
	}catch(Exception e) {
		System.out.println("errrrrrrrror=>"+e);
	}
		}else if(disponible.equalsIgnoreCase("non_availble")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,user,pass);
				PreparedStatement pst=con.prepareStatement("update livres set disponible=? where titre=?");
				pst.setString(1,disponible);
				pst.setString(2,book);
				pst.executeUpdate();
				
				response.sendRedirect("index.jsp");
				
			}catch(Exception e) {
				System.out.println("errrrrrrrror=>"+e);
			}
				} else {System.out.println("there is an error ....");}
		
		
		
		
		
		
	
	
	
	
	}

}
