<%@page import="java.util.Collection"%>
<%@page import="Entitiers.Mail"%>
<%@page import="java.util.List"%>
<%@page import="Entitiers.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String nom = (String) session.getAttribute("nom");
    String prenom = (String) session.getAttribute("prenom");
    //String email =(String) session.getAttribute("email");
   // String password =(String) session.getAttribute("pass");
    int id= (int)session.getAttribute("id");
    
    Collection<Mail> messages = (Collection<Mail>)request.getAttribute("RecMessage");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Envoyer Message </title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/styleprofile.css" rel="stylesheet">
</head>
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
     <div class="con"><button type="button" class="btn btn-outline-dark">Déconnexion</button></div>
     <div class="login-box">
  <form>
    <table class="table text-light">
  <thead>
    <tr>
      <th scope="col" >N°</th>
      <th scope="col">De</th>
      <th scope="col">Sujet</th>
      <th scope="col">Date</th>
      
    </tr>
  </thead>
  <tbody>
   <% for(Mail message : messages){ %>
    <tr>
      <th scope="row"><%=message.getId() %></th>
      <td><%=message.getDestinataire() %></td>
      <td><%=message.getObjet() %></td>
      <td><%=message.getEdate()%></td>
      
    </tr>
   <%
       }
    %>
  </tbody>
</table>
    <a href="SendMessage.jsp">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Nouveau Message
    </a>
  </form>
</div>
</div>
</body>
</html>