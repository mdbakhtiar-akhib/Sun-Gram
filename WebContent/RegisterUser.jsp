<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script> 
       
    function checkPassword(form) { 
        password1 = form.password.value; 
        password2 = form.passwordconfrm.value; 

        if (password1 == '') 
            alert ("Please enter Password"); 
              
      
        else if (password2 == '') 
            alert ("Please enter confirm password"); 
              
            
        else if (password1 != password2) { 
            alert ("\nPassword did not match: Please try again...") 
            return false; 
        } 

        
        else{ 
            
        } 
    } 
</script>
<head>
    <title>Sun Gram</title>
</head>
<body>
    <center>
        <h1>Sun Gram</h1>     
    </center>
    <div align="center">
            <form action="register" method="post" onSubmit = "return checkPassword(this)">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                        User Registration Form
                </h2>
            </caption>
                <!-- <c:if test="${people != null}">
                    <input type="hidden" name="id" value="<c:out value='${people.id}' />" />
                </c:if> -->          
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${people.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="45"
                            value="<c:out value='${people.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Confirm Password: </th>
                <td>
                    <input type="password" name="passwordconfrm" size="45"
                            value="<c:out value='${people.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="fname" size="45"
                            value="<c:out value='${people.status}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lname" size="45"
                            value="<c:out value='${people.status}' />"
                    />
                </td>
            </tr>
            <tr>
            <tr>
                <th>Age: </th>
                <td>
                    <input type="number" name="age" size="5"
                            value="<c:out value='${people.status}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender: </th>
                <td>
						<select name="gender" id="gender">
						  <option value="M">M</option>
						  <option value="F">F</option>
						</select>
                </td>
            </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Register" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
