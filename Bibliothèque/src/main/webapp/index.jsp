<%@page import="com.mysql.cj.xdevapi.Table"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
    <%@ include file="laout2.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>

<%
String url="jdbc:mysql://localhost:3306/Bibliothèque";
String user="root";
String password="";
%>
<div style="margin-top:100px" class="mb-2">
<a href="Add.jsp" ><button class="btn btn-primary " style="margin-right:15px"> Add a book</button> </a>
<a href="demand_Reservation.jsp" ><button class="btn btn-primary">list of Requests</button> </a>

</div>
<h2 class="text-center"> The All Books of Library</h2>
<table class="table">

<tr>
<th>Id</th>
<th>Titre</th>
<th>Auteur</th>
<th>Status</th>
<th>Description</th>
<th>Images</th>
<th>Actions</th>
<th>Change Status</th>

</tr>
<%

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,user,password);
	String query="SELECT * FROM livres";
	Statement stm;
	stm=con.createStatement(); 
	ResultSet res=stm.executeQuery(query);
	while(res.next()){
		%>
		<tr>
		<td><%= res.getString(1) %></td>
	    <td><%= res.getString(2) %></td>
	    <td><%= res.getString(3) %></td>
	    <td><span class="bg-secondary text-white" style="padding:5px; border-radius:5.4px;"><%= res.getString(4) %></span> </td>
	    <td><%= res.getString(5) %></td>
	    
	      <td>	<img alt="upload image" class="rounded-circle"   src="image/<%= res.getString(6) %>" width="80px" height="80px">

	    
	    <td><a href="./Delete?id=<%= res.getInt(1)%>"><button  class="btn btn-danger btn-sm">Delete</button></a>
		<a href="update.jsp?id=<%= res.getInt(1)%>"  ><button class="btn btn-info btn-sm text-white">Update</button></a></td>
	   <%
	    String book=java.net.URLEncoder.encode(res.getString(2),"UTF-8");

	   %>
	   
	    <td> <a href="Change_status?book=<%= book%>&disponible=availble"> <button  class="btn btn-success btn-sm">Availble</button> </a>
	     <a href="Change_status?book=<%= book%>&disponible=non_availble""> <button  class="btn btn-warning btn-sm text-white">Non-Availble</button> </a></td>
	
		</tr>
		
	<%
	
	}

	    res.close();
		stm.close();
		con.close();
}catch(Exception e){
	System.out.println("there is an error here =>"+e);
}
%>



</table>

</div> 
</body>
</html>