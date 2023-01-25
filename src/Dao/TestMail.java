package Dao;

import java.util.Collection;
import java.util.List;

import javax.mail.Message;

import Entitiers.Mail;
import Metier.IMail;


public class TestMail {

	public static void main(String[] args) {
		/*RecupererMail service =new RecupererMail();
		List<Mail> emails = service.recupererEmail("chaimae@smpt.local", "123");
		
		//System.out.println(emails.setid());
		for(Mail email : emails){
		System.out.println("-----------------------Debut--------------------");
		System.out.println("Num: "+email.getId());
		System.out.println("From: "+email.getDestinataire());
		System.out.println("sujet: "+email.getObjet());
		System.out.println("Message: "+email.getMessage());
		System.out.println("Date: "+email.getEdate());
	
		
		}
	}*/
	
	/*IMail service =new MailDao();
	Collection<Mail> emails =  service.recupererEmail("chaimae@smpt.local", "123");
	
	for(Mail email : emails){
		System.out.println("-----------------------Debut--------------------");
		System.out.println("Num: "+email.getId());
		System.out.println("From: "+email.getDestinataire());
		System.out.println("sujet: "+email.getObjet());
		System.out.println("Message: "+email.getMessage());
		System.out.println("Date: "+email.getEdate());
	
		
		}*/
		
		CryptageMot pass =new CryptageMot();
		
		System.out.println(pass.getSHA6("123")); 

}
}
