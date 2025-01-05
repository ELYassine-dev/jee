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


@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	PrintWriter out=response.getWriter();
	String url="jdbc:mysql://localhost:3306/bibliothèque";
	String user="root";
	String pass="";
	
	String book=request.getParameter("book");
	String name=request.getParameter("name");
	String emailac=request.getParameter("emailac");
	int phone= Integer.parseInt( request.getParameter("phone"));
	String bd=request.getParameter("b_date");
	java.sql.Date b_date=java.sql.Date.valueOf(bd);
	String rd=request.getParameter("r_date");
	java.sql.Date r_date=java.sql.Date.valueOf(rd);

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement pst=con.prepareStatement("insert into history(book_name,borrow_name,email,phone,borrow_date,return_date) values(?,?,?,?,?,?)");
		pst.setString(1, book);
		pst.setString(2,name);
		pst.setString(3,emailac);
		pst.setInt(4,phone);
		pst.setDate(5,b_date);
		pst.setDate(6,r_date);
		int rows=pst.executeUpdate();
		if(rows>0) {
			System.out.println("reservation accepted");
		
			out.println("<script> alert('reservation accepted successfly')</script>");

			
//			response.sendRedirect("demand_Reservation.jsp");

		}else {
			System.out.println("reservation didn't accepted");
		}
		
	}catch(Exception e) {
System.out.println("errrrrrror=>"+e);	}
	
	
	
	}

}
