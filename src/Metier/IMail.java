package Metier;

import java.util.Collection;
import java.util.List;

import Entitiers.Mail;

public interface IMail {
  public  void sendEmail(Mail email);
  public   Collection<Mail> recupererEmail(String email, String pass);
	

}
