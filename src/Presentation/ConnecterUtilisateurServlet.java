package Presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MailDao;
import Dao.UtilisateurDao;
import Entitiers.Mail;
import Entitiers.Utilisateur;
import Metier.IMail;
import Metier.IUtilisateur;




@WebServlet("/Connexion")
public class ConnecterUtilisateurServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		IUtilisateur service =new UtilisateurDao();
		Utilisateur user=service.getUtilisateur(email, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("password", user.getPassword());
			session.setAttribute("email", user.getCompteEmail());
			session.setAttribute("nom", user.getNom());
			session.setAttribute("prenom", user.getPrenom());
			session.setAttribute("id", user.getIdUser());
			//request.setAttribute("UAM",user);
		
			request.getRequestDispatcher("RecupererMessageServlet").forward(request,response);
		}else {
			request.setAttribute("messageErreur", "mod de passe et email se sont incorrect !");
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /*String email= request.getParameter("email");
		String password = request.getParameter("password");
		IUtilisateur service =new UtilisateurDao();
		Utilisateur userBox=service.getUtilisateur(email, password);
		
			request.setAttribute("userbox",userBox);
			request.getRequestDispatcher("/RecupererMessageServlet").forward(request,response);
		*/
	}

}
