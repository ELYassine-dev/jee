package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


@WebServlet("/Books")

@MultipartConfig
public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/webapp/Add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String titre=request.getParameter("titre");
		String auteur=request.getParameter("auteur");
		String disponible=request.getParameter("disponible");
		String description=request.getParameter("description");

		Part filePart =request.getPart("img");
        String imagefilename=filePart.getSubmittedFileName();
		String uploadpath="C:/Users/Yassine/eclipse-workspace/Bibliothèque/src/main/webapp/image/"+imagefilename;
		try {
			FileOutputStream fos=new FileOutputStream(uploadpath);
			InputStream is = filePart.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	String url="jdbc:mysql://localhost:3306/bibliothèque";
	String user="root";
	String password="";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,password);
		PreparedStatement pst=con.prepareStatement("INSERT INTO livres(titre,auteur,disponible,description,image) VALUES(?,?,?,?,?)");
		pst.setString(1,titre);
		pst.setString(2, auteur);
		pst.setString(3, disponible);
		pst.setString(4, description);
        pst.setString(5, imagefilename); 
        int rows=pst.executeUpdate();
              
        response.sendRedirect("index.jsp");
		pst.close();
		con.close();
	}catch(Exception e) {System.out.println("there is an error for insering books -->"+e);

	}
	
	
		
		
		
		
		
		
		
		
		
	
	
	}

	}
