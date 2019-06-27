<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>  
.error{color:red}  
</style>

</head>
<body>

<form:form action="addRegister" method="post" modelAttribute="reg">

<table border="4">
<tr>
<td>Student Name<form:input  path="name"/></td>
<td><form:errors path="name" cssClass="error"/></td>
</tr>

<tr>
<td>Student Age<form:input path="age"/></td>
<td><form:errors path="age" cssClass="error"/></td>
</tr>

<tr>
<td>Student Marks<form:input path="total_marks"/></td>
<td><form:errors path="total_marks" cssClass="error"/></td>
</tr>

<tr>
<td>Student Percentage<form:input path="percentage"/></td>
<td><form:errors path="percentage" cssClass="error"/></td>
</tr>
<tr>
        <td colspan="2">   <input type="submit" value="Register"></td>
   </tr>            
               </table>
               

</form:form>
 
</body>
</html>