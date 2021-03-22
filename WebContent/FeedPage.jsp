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
           <button onclick="window.location.href='PostImage.jsp';">
	      		Post Image
	    	</button>
	    	
	    	<form action="Profile" method="post">
	    	
	    		<input type="hidden" name="email" size="45" value=<%= session.getAttribute("currentUser")%>/>
      
                <input type="submit" value="Go to Profile" />

        	</form>
	    	
		    <h3>Recent Sunset Posts</h3>

		    <c:forEach  var="map" items="${listImages}">
		    	<div>
		    		<img src="${map.url}"  alt="Sunset Image" width="400" height="300">
		    		<h5>Description: ${map.description}</h5>
		    		<h5>Image Tags: ${map.tags }</h5>
		    		<h5>Posteb By: ${map.postuser }</h5>
		    	</div> 	
		    </c:forEach>
    </center>
    
</body>
</html>