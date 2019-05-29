<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${sessionScope.post.getTitle()}" /></title>
</head>
<body>
    <a href="homeLoggedIn.jsp">Home</a>
    <a href="UserPosts">Posts</a>
    <a href="logout.jsp">Logout</a>
    <!-- <h1 class="titulo"><c:out value="${post.getTitle()}" /></h1>
    <p class="text"><c:out value="${post.getText()}" /></p> -->
    <c:if test="${post.getAccountId().getUsername() == username}">
		<form action="DeletePost" method="post">
			<button type="submit" class="btn">Deletar post</button>
		</form>
    </c:if>
	<h3>${sessionScope.post.getTitle()}</h3>
	<p><b>Tema:</b> <c:out value="${sessionScope.post.getTags()}" /></p>
	<p><b>Autor:</b> <c:out value="${sessionScope.post.getAccountId().getUsername()}" /></p>
    <p><b>Conteúdo:</b> <c:out value="${sessionScope.post.getText()}" /></p>
		
	<h2>Comentários</h2>
	<c:forEach var="comentario" items="${sessionScope.comentarios}">
  		<p><b>Autor:</b> <c:out value = "${comentario.getAccountId().getUsername()}" /></p>
  		<p><c:out value= "${comentario.getText()}" /> </p>
  		<form action="<c:url value='AnswerComment'/>" method="post">
  			<input type="hidden" name="postId" value="${sessionScope.post.getPostId()}" />
  			<br>Comentar: <br><textarea name="conteudo" rows="1" cols="20" required></textarea><br><br>
  			<input type="hidden" name="commentId" value="${comentario.getCommentaryId()}" />
  			<button type="submit" class="btn">Responder</button>
		</form>
	</c:forEach>
	<br>
    <form action="<c:url value='CommentPost'/>" method="post">
    	<input type="hidden" name="id" value="${sessionScope.post.getPostId()}" />
		<br>Comentar: <br><textarea name="conteudo" rows="4" cols="50" required></textarea><br><br>
		<button type="submit" class="btn">Comentar</button>
	</form>	
</body>
</html>