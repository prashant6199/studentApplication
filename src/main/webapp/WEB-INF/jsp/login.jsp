<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>  
.error{color:red}  
</style>

</head>
<body>
<form:form action="loginvalid" modelAttribute="login" method="post">

<table border="4">
<tr>
     <td> User Name<form:input path="name"/></td>
      <td><form:errors path="name" cssClass="error"/></td>
 </tr>
 
 <tr>
    <td> Password<form:password path="password"/></td>
    <td>  <form:errors path="password" cssClass="error"/></td>
  </tr>    
   </table>
      <input type="submit" value="Login"/>
       <a href="/forgotpassword">forgot Password</a>
</form:form>

</body>
</html>