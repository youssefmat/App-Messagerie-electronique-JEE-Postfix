package Presentation;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MailDao;
import Entitiers.Mail;
import Metier.IMail;

@WebServlet("/RecupererMessageServlet")
public class RecupererMessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
		String user=(String)session.getAttribute("email");
		String pass=(String)session.getAttribute("password");
		
		IMail serviceEmail =new MailDao();
		Collection<Mail> emails =  serviceEmail.recupererEmail(user, "123");
		request.setAttribute("RecMessage",emails);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
