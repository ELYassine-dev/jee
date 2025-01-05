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


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String passwords="";
		String email=request.getParameter("email");
		PrintWriter out=response.getWriter();
String query="YassineElmansoury@gmail.com";
		
if(email.equalsIgnoreCase(query)) {
	session.setAttribute("email", email);
    response.sendRedirect("index.jsp");	
}else {
	out.println("<script> alert('your email or password inccorect')</script>");

}
//		String query="SELECT email From admin WHERE email=? ";

	
//		if(request.getParameter("email")!=null) {

//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection con=DriverManager.getConnection(url,user,passwords);
//				PreparedStatement pst=con.prepareStatement(query);
//			    pst.setString(1, email);
//				ResultSet res=pst.executeQuery();
////				if(email.equalsIgnoreCase(query)) {	
//				session.setAttribute("email", email);
//		        response.sendRedirect("index.jsp");						
//					
//		        res.close();
//				pst.close();
//				con.close();

//				}else response.sendRedirect("Singin.jsp");
                
				
				
				
//			}catch(Exception e) {
//		out.println("ther is an error at =>"+e);
//			}
			
			
	
	}

}
