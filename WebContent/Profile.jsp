<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sun Gram</title>
</head>
<body>

<center>
        <h1>Sun Gram</h1>
        <h2>Welcome <%= session.getAttribute("currentUserFname") %> <%= session.getAttribute("currentUserLname") %></h2>
        <h3>Your Information:</h3>
        <h4>Email: ${user.email}</h4>
	    	
		    <h3>Your Posts</h3>

		    
    </center>
    
</body>
</html>