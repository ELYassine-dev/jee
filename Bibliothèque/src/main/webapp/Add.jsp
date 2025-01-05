<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.sql.*"%>
    <%@ include file="laout2.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title >Add a new book</title>
</head>
<body>




<div style="margin-top:60px">
<h3 class="text-center"> Add a new book</h3>
 <a href="index.jsp" >Return</a>

<center >
<fieldset>
<div style="border:1px solid ; width:460px; height:515px; padding:10px;border-radius:15px;" class="border border-1 shadow p-4 mb-4 bg-white">
<form action="Books" method="post" enctype="multipart/form-data">
Title <input type="text" name="titre" id="titre" required class="form-control" placeholder="Enter book name.... ">
Auther <input type="text" name="auteur" id="auteur" required class="form-control" placeholder="Enter book Writer.... ">
Status <input type="text" name="disponible" id="disponible" required class="form-control" placeholder="Enter book status.... ">
Description <textarea type="text" name="description" rows="4" id="description"  required class="form-control" placeholder="Enter book Description.... ">
</textarea>



 Upload file <input type="file" name="img" id="img" required class="form control mt-4 mb-4" > <br>

<button class="btn btn-success " >Add a Book</button>
<input type="reset" value="Reset" class="btn btn-danger text-white mb-2">
</form>
<!-- <a href="index.jsp" ><button class="btn btn-primary">Return</button></a>-->



 </div></div>
</fieldset>

</center>


</body>
</html>