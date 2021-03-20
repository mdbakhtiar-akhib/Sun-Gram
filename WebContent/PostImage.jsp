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
    </center>
    <div align="center">
            <form action="PostImage" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Post Your Sunset Image</h2>
            </caption>
            
            <input type="hidden" name="Userid" value= "<%= session.getAttribute("currentUser") %>" />
            
            <tr>
                <th>Image URL: </th>
                <td>
                    <input type="text" name="url" size="45"/>
                </td>
            </tr>
            
            <tr>
                <th>Tags: </th>
                <td>
                    <input type="text" name="tags" size="45"/>
                </td>
            </tr>
            
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="description" size="45"/>
                </td>
            </tr>
            
            <tr>
	            <td colspan="2" align="center">
	                <input type="submit" value="Post" />
	                
	            </td>
            </tr>
        </table>
        </form>
    </div>   

</body>
</html>