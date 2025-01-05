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
<title>Accept</title>
</head>
<body>

<%-- <div align="right">
Welcome, <%= email %> <br>
<a href="logout">Logout</a>
</div>
<hr> --%>
<h2 align="center" style="margin-top:60px">Confirme Reservation </h2>
<a href="demand_Reservation.jsp">Return</a>


<%
String book=request.getParameter("book");
String name=request.getParameter("name");
String mail=request.getParameter("emailac");
String phone=request.getParameter("phone");
%>
<center>
<fieldset>
<div style="border:1px solid ; width:460px; height:500px; padding:10px;border-radius:15px;" class="border border-1 shadow p-4 mb-4 bg-white">
<form action="History" method="post">
Book Name <input type="text" name="book" value="<%= book %>" required class="form-control">
Borrow Name <input type="text" name="name" value="<%= name %>" required class="form-control">
Email Academic <input type="email" name="emailac" value="<%= mail %>" required class="form-control">
Phone Number<input type="number" name="phone" value="<%= phone %>" required class="form-control">
Borrow Date <input type="date" name="b_date" id="b_date" required class="form-control">
Return Date <input type="date" name="r_date" id="r_date" required class="form-control">
<button class="btn btn-success mt-3">Confirme</button>
	   </form>
	   
	  </div> 
	   </fieldset>
</center>
<div>
</div>
</body>
</html>