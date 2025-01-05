<%@page import="com.mysql.cj.xdevapi.Table"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
        
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library</title>
<link rel="stylesheet" href="css/bootstrap.css">

</head>



<body>
<nav class="navbar bg-body-tertiary fixed-top  " style="height: 80px; ">
  <div class="container-fluid">
    <form action="search.jsp" class="d-flex" role="search" >
      <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
     </form>
    <div align="right" >
    <a href="Singin.jsp" ><button class="btn btn-outline-success">Connexion</button> </a>
    </div>
  </div>
  
</nav>
<%
String url="jdbc:mysql://localhost:3306/Bibliothèque";
String user="root";
String password="";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,user,password);
	PreparedStatement pst = con.prepareStatement("SELECT * FROM livres ");
	ResultSet res=pst.executeQuery();
	 %>
       <div class="container" style="margin-top: 100px;">
        <div class="row">
        <% 
            int count = 0; // To track the number of cards
            while (res.next()) {
                if (count % 4 == 0 && count != 0) {
                    out.print("</div><div class='row'>"); // Close the current row and start a new one
                }
        %>
            <!-- Card Layout -->
            <div class="col-md-3"> <!-- 4 cards per row -->
                <div class="card" style="width: 100%;">
                    <img class="card-img-top" src="image/<%= res.getString(6) %>" alt="Card image" style="width: 100%; height: 170px;">
                    <div class="card-body">
                        <h2 class="card-title"><%= res.getString(2) %></h2>
                        <h6 class="card-title"><%= res.getString(3) %></h6>
                        <p class="card-text" ><%= res.getString(5) %></p>
                        <span class="badge bg-success" style="padding: 12px;"><%= res.getString(4) %></span>
                        <% 
                            String book = java.net.URLEncoder.encode(res.getString(2), "UTF-8");
                            String other = java.net.URLEncoder.encode(res.getString(3), "UTF-8");
                            String image = java.net.URLEncoder.encode(res.getString(6), "UTF-8");
                        %>
                        <a href="borrowbook.jsp?titre=<%= book %>&auteur=<%= other %>&image=<%= image %>">
                            <button type="button" class="btn btn-primary">Borrow</button>
                        </a>
                    </div>
                </div>
            </div>
        <% 
            count++; // Increment the card count
            }
        %>
    </div> <!-- End of the last row -->
</div>
<%  	
        res.close();
		pst.close();
		con.close();
		
}catch(Exception e){
	System.out.println("there is an error here =>"+e);
}



%>

</body>
</html>