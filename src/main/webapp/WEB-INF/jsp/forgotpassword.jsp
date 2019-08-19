<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>

<style>  
.error{color:red}  
</style>

</head>
<body>
<form:form action="resetpassword" modelAttribute="newpass" method="Post">

<table border="4">
<tr>
     <td> User Name<form:input path="name"/></td>
    
      
 </tr>

   <tr>
    <td> ID<form:input path="sid"/></td>
   
  </tr>
  
  <tr>
    <td> New Password<form:password path="password"/></td>
   
  </tr>
     
   </table>
      <input type="submit" value="Submit"/>
     
</form:form>

</body>
</html>