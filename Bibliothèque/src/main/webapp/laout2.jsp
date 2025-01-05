<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mysql.cj.xdevapi.Table"%>

    <%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>library</title>
<link rel="stylesheet" href="css/bootstrap.css">
 <% 
    String email="";
    if(session.getAttribute("email")!=null){
    	
    	email=session.getAttribute("email").toString();
    	
    }else response.sendRedirect("Singin.jsp");
    
    
    %>
</head>
<body>
<nav class="navbar bg-body-tertiary fixed-top  ">
  <div class="container-fluid">
    <form action="search.jsp" class="d-flex" role="search" enctype="multipart/form-data">
      <input class="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-success" type="submit">Search</button>
   
     </form>
     
    <div align="right">
<i>Welcome</i>, <%= email %>
<a href="Logout" style="margin-left:60px"><button type="button" class="btn btn-success">Logout</button></a>
</div>
    </div>
    
  </div>
  
</nav>

</body>
</html>