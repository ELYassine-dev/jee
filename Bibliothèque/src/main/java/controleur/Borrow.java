package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/Borrow")
public class Borrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String passwords="";
		
		String book_name=request.getParameter("book_name");
		String book_writer=request.getParameter("book_writer");
		String name=request.getParameter("name");
		String email_academic=request.getParameter("email_academic");
		int phone_number=Integer.parseInt( request.getParameter("phone_number"));
		String adress=request.getParameter("adress");

		
		PrintWriter out=response.getWriter();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,passwords);
			PreparedStatement pst=con.prepareStatement("insert into reservation(book_name,book_writer,name,email_academic,phone_number,adress) values(?,?,?,?,?,?) ");
		    pst.setString(1, book_name);
		    pst.setString(2, book_writer);
		    pst.setString(3, name);
		    pst.setString(4, email_academic);
		    pst.setInt(5, phone_number);
		    pst.setString(6, adress );
			pst.executeUpdate();
			
			response.sendRedirect("home.jsp");

		pst.close();
		con.close();
		
		
		}catch(Exception e) {System.out.println("error here=> "+e);}
			
	
	
	
	
	
	}
	}

