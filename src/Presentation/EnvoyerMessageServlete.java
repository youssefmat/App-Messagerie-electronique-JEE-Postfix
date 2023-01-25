package Presentation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MailDao;
import Entitiers.Mail;
import Metier.IMail;

@WebServlet("/EnvoyerMessage")
public class EnvoyerMessageServlete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinataire = request.getParameter("destinataire");
		String objet = request.getParameter("objet");
		String message = request.getParameter("message");
		//recuper les a traver session
		HttpSession session = request.getSession();
		String user=(String)session.getAttribute("email");
		String pass=(String)session.getAttribute("password");
		//String emailAdmin = "chaimae@smpt.local";
		//String password = "123";
		Mail email = new Mail(destinataire, objet, message, user, pass,new Date());
		IMail service = new MailDao();
		service.sendEmail(email);
		request.getRequestDispatcher("SendMessage.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
