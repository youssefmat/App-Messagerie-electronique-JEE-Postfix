package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MailDao;
import Dao.UtilisateurDao;
import Entitiers.Mail;
import Entitiers.Utilisateur;
import Metier.IMail;
import Metier.IUtilisateur;


@WebServlet("/CreerUtilisateur")
public class CreerUtilisateurServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirme = request.getParameter("passwordConfirme");
		if( password.equals( passwordConfirme)){
			Utilisateur user = new Utilisateur(prenom, nom, email, password);
			IUtilisateur service = new UtilisateurDao();
			service.addUser(user);
			//request.setAttribute("email",user.getCompteEmail()+"@testmai.com");
			request.getRequestDispatcher("Login.jsp").forward(request,response);
			
		
		}else{
			request.setAttribute("message", "Ces mots de passe ne correspondent pas. Veuillez réessayer !");
			request.getRequestDispatcher("LogUp.jsp").forward(request,response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
