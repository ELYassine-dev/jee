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
<title>history</title>
</head>
<body>
<%-- <div align="right"><%= email%> <br>
<a href="Logout">Logout</a>
</div>
 --%>
<div style="margin-top:80px">
<a href="demand_Reservation.jsp"><button class="btn btn-outline-primary">Reservation</button></a>
<a href="history.jsp" class="btn btn-primary">History</a>
</div>
 <h2 class="text-center">History</h2>



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

<table class="table">

<tr>
<th>Id</th>
<th>Book</th>
<th>Name</th>
<th>Email Academic</th>
<th>Phone</th>
<th>Borrow Date</th>
<th>Return Date</th>

</tr>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,user,password);
	PreparedStatement pst = con.prepareStatement("SELECT *from history");
	ResultSet res=pst.executeQuery();
	while(res.next()){
		%>
		<tr>
	    <td><%= res.getInt(1) %></td>
	    <td><%= res.getString(2) %></td>
	    <td><%= res.getString(3)%></td>
	    <td><%= res.getString(4) %></td>
	    <td><%= res.getInt(5) %></td>
	    <td><%= res.getDate(6) %></td>
	    <td><%= res.getDate(7) %></td>
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