<%@page import="Entitiers.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	 Utilisateur user =(Utilisateur)request.getAttribute("us");

   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Messageries</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/stylel.css" rel="stylesheet">
</head>
<body>
	<div class="login-box">
		<h2>Connexion</h2>
		<form action="Connexion" methode="get">
			<div class="user-box">
		     	<%  // String email = (String)request.getAttribute("email");if(email==null){email="";} %>
				<input type="text" name="email" required="" value=""> <label>Adresse
					e-mail</label>
			</div>
			<div class="user-box">
				<input type="password" name="password" required=""> <label>Saissez
					votre mot de passe </label>
			</div>
			<% String MessageErreur=(String)request.getAttribute("messageErreur");if(MessageErreur==null){MessageErreur="";} %>
			<span style=color:white><%=MessageErreur %></span>
			 <span></span> <span></span> <span></span> <span></span>
				<button type="submit" class="btn btn-light mb-2">Connecter</button>
				<span></span>
			 <a href="LogUp.jsp" class="connexion"> <span></span> <span></span>
				<span></span> <span></span> Créer
			</a>
		</form>
	</div>

</body>
</html>