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
</head>
	<body>
	<br>Hello ${lmessage} you have succesfully logged in</br>
	
	<table border="1">
	      
	  <tr>    
     	 <th>Student ID</th>
    	 <th>Student Name</th>
    	 <th>Student Age</th>
    	 <th>Total Marks</th>
    	 <th>Percentage</th>
     
     </tr>
     <tr>
            <td> ${logindata.getSid()}</td>
		  	<td>  ${logindata.getName()}</td>
		  	<td>  ${logindata.getAge()}</td>
		  	<td>  ${logindata.getTotal_marks()}</td>
		  	<td>  ${logindata.getPercentage()}</td>
	</tr>
	</table>

		<a href="/">Logout</a>

	</body>
</html>