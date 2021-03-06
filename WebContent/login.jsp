<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <link rel="stylesheet" href="CSS/menu.css" type="text/css">
    <link rel="stylesheet" href="CSS/inputPages.css" type="text/css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <s:menu/>
    <s:isAnon/>
    <c:if test="${not empty errorMessage}">
    	<p><c:out value="Username ou senha errados!"/></p>
    </c:if>
    <form action="Login" method="POST">
        <pre>
            <div class="inputs">
                <input type="text" name="username" placeholder="Username" class="texto" required>
                <input type="password" name="password" class="texto" placeholder="Senha" required>
                        <input type="submit" value="Login" class="btn">
            </div>
        </pre>
    </form>
    <img src="Images/formas.png" class="formas">
</body>
</html>