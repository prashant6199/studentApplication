<%@page import="javax.swing.event.ListDataEvent"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page import="com.example.demo.controller.RegistrationController" %>
<%@page import="com.example.demo.model.Registration" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="get" modelAttribute="listdata" action="search">


<table border="1">
     
     <tr><th colspan="4">The Details of the Registered Student</th>
          <th colspan="3"><input type="text" name="name"/>
                          <input type="submit"name="Search"/>
          </th>
     </tr>
    
     <tr>    
     	<th>Student ID</th>
    	 <th>Student Name</th>
    	 <th>Student Age</th>
    	 <th>Total Marks</th>
    	 <th>Percentage</th>
    	 <th>Update</th>
    	 <th>Delete</th>
     
     </tr>
    
 <c:forEach var="emp" items="${listdata}">
		<tr> 
		  	<td> ${emp.getSid()}</td>
		  	<td>  ${emp.getName()}</td>
		  	<td>  ${emp.getAge()}</td>
		  	<td>  ${emp.getTotal_marks()}</td>
		  	<td>  ${emp.getPercentage()}</td>
		  	<td><a href="/update?sid=${emp.getSid()}">Update</a>
		  	<td><a href="/delete?sid=${emp.getSid()}">Delete</a>
		</tr>
		
</c:forEach>

<tr>
		   <td colspan="4"><a href="/jsonlistdata">List Of Student Details with higher percentage to lower</a></td>
		   <td colspan="3"><a href="/">Logout</a></td>
		   
	</tr>

</table>


</form:form>

</body>
</html>