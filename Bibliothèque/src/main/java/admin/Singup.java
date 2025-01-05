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

/**
 * Servlet implementation class Singup
 */
@WebServlet("/Singup")
public class Singup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	
	String url="jdbc:mysql://localhost:3306/bibliothèque";
	String user="root";
	String passe="";
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	PrintWriter out=response.getWriter();
	String query="SELECT email From admin WHERE email=? ";

	
	
	
	if(request.getParameter("email")!=null) {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,passe);
			if(!email.equalsIgnoreCase(query)) {
			PreparedStatement pst=con.prepareStatement("insert into admin(name,email,password) values (?,?,?) ");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, password);
			pst.executeUpdate();
			session.setAttribute("email",email);
			response.sendRedirect("index.jsp");
			pst.close();
			con.close();
			
			}else if(email.equalsIgnoreCase(query)) {
				session.setAttribute("email",email);
				response.sendRedirect("index.jsp");
						}
				
		
			
		}catch(Exception e) {out.println("there i an error ->"+e);}
		
		
		
	}else response.sendRedirect("Singup.jsp");
	
	
	}

}
