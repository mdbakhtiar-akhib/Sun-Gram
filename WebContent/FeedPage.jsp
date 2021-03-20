<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
           <button onclick="window.location.href='PostImage.jsp';">
	      		Post Image
	    	</button>
	    	
	    
		    <h3>Recent Sunset Posts</h3>
		    
		    <c:forEach  var="map" items="${listImages}">
		    	<img src="${map.url}"  alt="Sunset Image" width="300" height="200">
		    	<h5>${map.description}</h5>
		    	<h5>Posted by: <c:out "${map.postuser }" /></h5>
		    </c:forEach>
    </center>
    
</body>
</html>