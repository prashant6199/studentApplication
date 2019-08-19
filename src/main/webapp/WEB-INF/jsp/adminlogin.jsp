<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login page</title>


<style>  
.error{color:red}  
</style>

</head>
<body>
<form:form action="Adminloginvalid" modelAttribute="admindata" method="post">

<table border="4">
<tr>
     <td> UserName<form:input path="name"/></td>
      <td><form:errors path="name" cssClass="error"/></td>
 </tr>
 
 <tr>
    <td>  Password<form:password path="password"/></td>
    <td>  <form:errors path="password" cssClass="error"/></td>
  </tr>    
   </table>
      <input type="submit" value="Login"/>

</form:form>

</body>
</html>