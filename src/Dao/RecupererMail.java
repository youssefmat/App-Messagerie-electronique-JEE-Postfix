package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.pop3.POP3Folder;

import Entitiers.Mail;

public class RecupererMail {
	public  static List<Mail> recupererEmail(final String email, final  String pass) {
		List<Mail> emails = new ArrayList<>();
		
		try {
	 		   
	 		   Properties prop = new Properties();
	 		   prop.put("mail.pop3.host","192.168.199.148");
	 		   prop.put("mail.pop3.port","110");
	 		   prop.put("mail.smtp.auth", "true");
	 		  // prop.put("mail.pop3.starttls.enable","true");
	 		   Session emailSession = Session.getDefaultInstance(prop);
	 		   //POP3 stocker l'objet et la connexion avec le serveur pop
	 		   Store store = emailSession.getStore("pop3");
	 		   store.connect("192.168.199.148", email, pass); 
	 		   //objet dossier pour boîte de réception ouverte
	 		   Folder emailFolder = store.getFolder("INBOX");
	 		   emailFolder.open(Folder.READ_ONLY);
	 		   //obtenir des massages
	 		   Message messages[] = emailFolder.getMessages();
	 		  int i =((messages.length)-1);
	 		   for(Message message : messages) {
	 			  POP3Folder pf = (POP3Folder)emailFolder;
	 			    Mail mail = new Mail(); 
	 			    mail.setMessage((String) message.getContent());
	                mail.setDestinataire(message.getFrom()[0].toString());
	                mail.setObjet(message.getSubject());
	                mail.setEdate(message.getSentDate());
	                mail.setid(i);
	                //mail.setid(pf.getUID(message)));
	                
	                emails.add(mail);
	                i++;
	                
	 		   }
	 		   //fermer les objets Store et dossier
	 		   emailFolder.close(true);
	 	   } catch(NoSuchProviderException e) {
	 		   System.out.println("erreur1 :"+e.getMessage());
	 	   }catch(MessagingException e) {
	 		   System.out.println("erreur2:"+e.getMessage());
	 	   }catch(Exception e) {
	 		   System.out.println("erreur3"+e.getMessage());
	 	   }
		return emails;
	}
}
