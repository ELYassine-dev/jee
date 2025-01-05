<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>    
        <%@ include file="layout.html" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrow a book</title>

</head>
<body>


<h2 style="margin-top:90px;" class="mb-8 text-center">Fill the form with your personnel informations</h2>

<%
String book=request.getParameter("titre");
String other=request.getParameter("auteur");
String image=request.getParameter("image");

%>
<a href="home.jsp" style="margin-left:20px">Return</a>

 <center>
<fieldset><table>  

<form action="Borrow" method="post">
            
   <tr style="margin-right:5px">           
    <th style="width:450px;margin-top:55px">  
               <div class="form-floating mb-3 w-25" style="width:450px; margin-top:4px" >
                <input type="text" class="form-control" name="book_name" id="book_name" value="<%= book %>" required style="width:450px">
                <label for="floatingInput"> Book's Name</label>
               </div>
               <div class="form-floating mb-3 w-25">
                <input type="text" class="form-control" name="book_writer" id="book_writer" value="<%= other %>" required style="width:450px">
                <label for="floatingInput"> Book's Writer</label>
               </div>

                <div class="form-floating mb-3 w-25">
                <input type="text" class="form-control" name="name" id="name" placeholder="enter your name.." required style="width:450px">
                <label for="floatingInput"> Name</label>
               </div>

               <div class="form-floating mb-3 w-25">
                <input type="email" class="form-control" name="email_academic" id="email_academic" placeholder="enter your email.." required    pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" style="width:450px">
                <label for="floatingInput"> Email academic</label>
               </div>

               <div class="form-floating mb-3 w-25">
                <input type="number" class="form-control" name="phone_number" id="phone_number" placeholder="enter your Phone number.." required pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" style="width:450px">
                <label for="floatingInput">  Phone Number</label>
               </div>

                <div class="form-floating mb-3 w-25">
                <input type="text" class="form-control" name="adress" id="adress" placeholder="enter your Adress.." required style="width:450px">
                <label for="floatingInput"> Adress</label>
               </div>


<button class="btn btn-success">Submit</button>
<input type="reset" value="Clear" class="btn btn-danger"><br>

</th>
<th>
<img alt="upload image" src="image/<%= image%>" style="width:350px;height:400px;margin-left:45%"   class="img-thumbnail"  ><br>
</th>
 </table>
</form>

</body>
</html>