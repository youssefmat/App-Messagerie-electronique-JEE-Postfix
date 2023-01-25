package Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.pop3.POP3Folder;

import Entitiers.Mail;
import Metier.IMail;

public class MailDao implements IMail{

	@Override
	public void sendEmail(Mail email) {
		Properties props;
		Session session;
		MimeMessage message;

		props = new Properties();
		props.put("mail.smtp.host", "192.168.199.148");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		 //Authentification de email 
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getEmail(), email.getPassword());
			}    
		};
		session = Session.getInstance(props, auth);
		
		try {

			InternetAddress[] recipients = new InternetAddress[1];
			recipients[0] = new InternetAddress(email.getDestinataire());
			
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getEmail()));
			message.addRecipients(Message.RecipientType.TO, recipients);
			message.setSubject(email.getObjet());
			message.setText(email.getMessage());
			message.setSentDate(new Date());
	        Transport.send(message);
			
			//System.out.println("Email sent");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public  Collection<Mail> recupererEmail(final String email, final String pass) {
		Collection<Mail> emails = new ArrayList<>();
		
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
	               // mail.setid(pf.getUID(message));
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
