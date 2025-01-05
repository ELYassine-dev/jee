<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.*" %>
    <%@ include file="laout2.jsp" %>
   <%--  <%
    String email="";
    if(session.getAttribute("email")!=null){
    	email=session.getAttribute("email").toString();
    }else response.sendRedirect("Singin.jsp");
    
    
    %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>

<%-- <div align="right">
Welcome, <%= email %><br>
<a href="Logout">Logout</a>
</div> --%>
<div style="margin-top:80px">
<a href="demand_Reservation.jsp"><button class="btn btn-primary">Reservation</button></a>
<a href="history.jsp" class="btn btn-outline-primary">History</a>

</div>
<h2 class="text-center mb-4">Requests of Reservations</h2>
<%
String url="jdbc:mysql://localhost:3306/Bibliothèque";
String user="root";
String password="";
%>

<!-- <form action="search.jsp" enctype="multipart/form-data">
<input type="search" name="search" id="search" >
<button>Search</button>
</form> -->
<div>
<a href="index.jsp"> Return</a>
</div>
<table class="table" >

<tr>
<th>Id</th>
<th>Book Name</th>
<th>Writer Name</th>
<th>Borrow Student</th>
<th>Email Academic</th>
<th>Phone Number</th>
<th>Adress</th>
<th>accept</th>
<th>Actions</th>

</tr>

<%

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,user,password);
	PreparedStatement pst = con.prepareStatement("SELECT * FROM reservation ");
	ResultSet res=pst.executeQuery();
	while(res.next()){
		%>
<tr>
		<td><%= res.getString(1) %></td>
	    <td><%= res.getString(2) %></td>
	    <td><%= res.getString(3) %></td>
	    <td><%= res.getString(4) %></td>
	    <td><%= res.getString(5) %></td>
	    <td><%= res.getString(6) %></td>
	    <td><%= res.getString(7) %></td>
	     <%
	    String book=java.net.URLEncoder.encode(res.getString(2),"UTF-8");
	    String nom=java.net.URLEncoder.encode(res.getString(4),"UTF-8");
	    String mail=java.net.URLEncoder.encode(res.getString(5),"UTF-8");
	    String phone=java.net.URLEncoder.encode(res.getString(6),"UTF-8");   
	     %>
   	    <td><a href="accept.jsp?book=<%= book%>&name=<%= nom%>&emailac=<%= mail %>&phone=<%= phone%>"><button class="btn btn-success">Accept</button></a></td>
	    <td><a href="Demand_Reservation?id=<%= res.getString(1) %>"><button class="btn btn-danger">Delete</button></a></td>
		</tr>
		
	
			<%
	} 
	    res.close();
		pst.close();
		con.close();
}catch(Exception e){
	System.out.println("there is an error here =>"+e);
}
%>
	</table>	
			

</body>
</html>