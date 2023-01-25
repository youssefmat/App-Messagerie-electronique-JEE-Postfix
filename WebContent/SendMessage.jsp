<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Envoyer Message </title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/styleprofile.css" rel="stylesheet">
</head>

<% HttpSession session2 = request.getSession();
String nom=(String)session2.getAttribute("nom");
String prenom=(String)session2.getAttribute("prenom"); %>
<body>
<div class="container mt-5 d-flex ">
    <div class="card p-3">
        <div class="d-flex align-items-center">
            <div class="image"> <img src="img/profile.png" class="rounded" width="100"> </div>
            <div class="ml-3 w-100">
                
                <div class="button mt-2 d-flex flex-row align-items-center"> </div>
            </div>
        </div>
        <label><%=prenom.charAt(0)+"."+nom %></label>
    </div>

<div class="login-box">
  <h2>Envoyer Message</h2>
  

  <form action="EnvoyerMessage" method="get">
    <div class="user-box">
      <input type="text" name="destinataire" required="">
      <label>Destinataires</label>
    </div>
    <div class="user-box">
      <input type="text" name="objet" required="">
      <label>Objet</label>
    </div>
    <div class="user-box">
      <textarea class="form-control" name="message" placeholder="Saissez votre Message" rows="8"></textarea>
      
    </div>
    
      <span></span>
      <span></span>
      <span></span>
      <span></span>
       <button type="submit" class="btn btn-light mb-2">Envoyer</button>
    
    <a href="index.jsp" class="anuler">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Annuler
    </a>
  </form>
</div>
</div>
</body>
</html>