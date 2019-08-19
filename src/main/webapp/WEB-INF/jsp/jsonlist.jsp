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

<form:form method="get">

<table border="1">

     <tr>    
     	<th>Student ID</th>
    	 <th>Student Name</th>
    	 <th>Total Marks</th>
    	 <th>Percentage</th>

     </tr>
     <c:set var="i" value="0" scope="page"/>
        <c:forEach var="name" items="${jsonresultname}">
		  <tr> 
		      <td>${jsonresultsid[i]}</td>
	          <td>${jsonresultname[i]}</td>		  	 
		      <td>${jsonresulttotal_marks[i]}</td>		  
		      <td>${jsonresultpercentage[i]}</td>

	          <c:set var="i" value="${i+1}" scope="page"/>
		
		 </tr>
       </c:forEach>
       
       <tr>
		   <td colspan="2" style="color: purple"><a href="/getalllist">Back</a></td>
		   <td colspan="2"><a href="/">Logout</a></td>
		   
	</tr>

</table>
</form:form>

</body>
</html>