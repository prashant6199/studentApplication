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

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="get" modelAttribute="listdata">

<table border="4">
     
     <tr>
     
     <th>Student ID</th>
     <th>Student Name</th>
     <th>Student Age</th>
     <th>Total MArks</th>
     <th>Percentage</th>
     
     </tr>
    
 <tr>${listdata}</tr>

</table>

</form:form>

</body>
</html>