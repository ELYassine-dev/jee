package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Demand_Reservation
 */
@WebServlet("/Demand_Reservation")
public class Demand_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
int id=Integer.parseInt(request.getParameter("id"));
		
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement pst=con.prepareStatement("DELETE FROM reservation WHERE id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			
			
			pst.close();
			con.close();
			
			response.sendRedirect("demand_Reservation.jsp");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
	
	
	}

	
	
}
