<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application des Messageries </title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/stylel.css" rel="stylesheet">
</head>
<body>
  <div class="login-box">
  <h2>Créer votre compte </h2>
  <form action="CreerUtilisateur" method="get">
    <div class="input-group mb-3">
      <input type="text" class="form-control" name="prenom" placeholder="Prénom">
    </div>
    <div class="input-group mb-3">
      <input type="text" class="form-control" name="nom" placeholder="Nom">
    </div>
    <div class="input-group mb-3">
	  <input type="text"   class="form-control" name="email"  placeholder="Nom d'utilisateur ">
	  <span class="input-group-text" id="basic-addon2">@smpt.localhost</span>
   </div>
    <div class="input-group mb-3">
      <input type="password"  class="form-control" name="password" required="" placeholder="Mod de passe">
    </div>
    <%   String message = (String)request.getAttribute("message");if(message==null){message="";} %>
    <div class="input-group mb-3">
      <input type="password" class="form-control" name="passwordConfirme" required="" placeholder="Confirmer" value="">
    </div>
    <span style="color:white"><%=message %></span>
    <div>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <button type="submit" class="btn btn-light mb-2">Créer</button>
      <a href="Login.jsp" class="connexion">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Connexion
    </a>
    </div>
  </form>
</div>
</body>
</html>