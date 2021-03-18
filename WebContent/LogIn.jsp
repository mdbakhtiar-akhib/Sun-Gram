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
            <form action="login" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Log In for Sun Gram</h2>
            </caption>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="45"/>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Log In" />
                    
                </td>
                
                
            </tr>
        </table>
        </form>
        <button onclick="window.location.href='RegisterUser.jsp';">
			      		Signup
			    	</button>
    </div>   

</body>
</html>