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


@WebServlet("/Updateurl")
public class Updateurl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session= request.getSession();
		
    String email="";
    if(session.getAttribute("email")!=null){
    	
    	email=session.getAttribute("email").toString();
    }else response.sendRedirect("Singin.jsp");
    
    
		int id=Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String url="jdbc:mysql://localhost:3306/bibliothèque";
		String user="root";
		String password="";
		out.println("<div align='right'> Welcome,"+ email+"<br>"+ "<a href='Logout'>Logout</a>"		+ "</div>");
	
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement pst=con.prepareStatement("SELECT titre,auteur,disponible,description,image FROM livres WHERE id=? ");
            pst.setInt(1, id);
			ResultSet res=pst.executeQuery();
			res.next();
			out.println("<form action='Update?id="+id+"' method='POST' >");		
			out.println("Title: <input type='text' name='titre' value='"+res.getString(1)+"'> <br>");
			out.println("Auther: <input type='text' name='auteur' value='"+res.getString(2)+"' ><br>");
			out.println("Availble: <input type='text' name='disponible' value='"+res.getString(3)+"' ><br>");
			out.println("Description: <input type='text' name='description' value='"+res.getString(4)+"'> <br>");
			
			out.print("Image: <input type='file' name='image' >");
			out.println(res.getString(5)+"<br>");
			
			out.println("<input align='center' type='submit' value='Update' >");
			
			out.println("</form>");
			out.println("<div align='left'><a href='index.jsp' >Return</a></div>");

			
		}catch(Exception e) {
		System.out.println("ther is an error at=>"+e);
		}
	}

	

}
