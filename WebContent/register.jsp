<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
</head>
<body>
    <a href="homeNotLoggedIn.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <form action="Register" method="POST">
        <pre>
            Username : <input type="text" name="username">
            Email : <input type="text" name="email">
            Password : <input type="text" name="password1">
            Type Again : <input type="text" name="password2">
            <!-- verificar aqui a senha ou no servlet? -->
            <!-- 
      		
      			// nao funcionando, código comentado para que seja possivel fazer testes
      			String password1 = request.getParameter("password1");
      			String password2 = request.getParameter("password2");
      			
      			if (password1.equals(password2)){
      				
      				-->
      					<input type="submit" value="register">
      				<!-- 	
      				
      			}
      			else{
      				out.println("senhas nao sao iguais.");
      			}
      		%>
      		-->
        </pre>
    </form>
</body>
</html>