<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ include file="laout2.jsp" %>
   <%--  <%
    String name="";
    if(request.getSession()!=null){
    	name=request.getSession().toString();
    }else response.sendRedirect("Singin.jsp");
    
    %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update a book</title>
</head>
<body>

<h2 class="text-center" style="margin-top:70px">Update Books </h2>

<%

int id=Integer.parseInt(request.getParameter("id"));

String url="jdbc:mysql://localhost:3306/bibliothèque";
String user="root";
String password="";

try {

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,user,password);
	PreparedStatement pst=con.prepareStatement("SELECT titre,auteur,disponible,description,image FROM livres WHERE id=? ");
    pst.setInt(1, id);
	ResultSet res=pst.executeQuery();
	res.next();
%>
<div>
<a href="index.jsp"> Return</a>
</div>
<center>
<fieldset>
<div style="border:1px solid ; width:460px; height:480px; padding:10px;border-radius:15px;" class="border border-1 shadow p-4 mb-4 bg-white">
<form action="Update?id=<% out.println(id); %>"  method="post">

Title <input type="text" name="titre" id="titre" required class="form-control" value="<%=res.getString(1) %>">
Writer <input type="text" name="auteur" id="auteur" required class="form-control" value="<%=res.getString(2) %>">
Availble <input type="text" name="disponible" id="disponible" required class="form-control" value="<%=res.getString(3) %>">
Description <input type="text" name="description" rows="4" id="description"  required class="form-control" value="<%=res.getString(4) %>">
<p class="mt-2"><span style="color:red">*</span> <%=res.getString(5) %></p>
 Upload file <input type="file" name="img" id="img" class="form control  mb-3" >
<button class="btn btn-success " >Update</button>

</form>

<!-- <div style="margin:10%; margin-top:-33px">
<a href="home.jsp" ><button class="btn btn-primary">Return</button> </a>
</div> -->
<%

}catch(Exception e) {
	System.out.println("ther is an error at=>"+e);
	}

%>

</fieldset>

</center>





</body>
</html>