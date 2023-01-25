package Entitiers;

import java.util.Date;

public class Mail {
  private int id;
  



private String destinataire ;
  private String objet;
  private String message;
  private String email;
  private String password; 
  private Date Edate;
public Mail( String destinataire, String objet, String message, String email, String password, Date Edate) {
	
	this.destinataire = destinataire;
	this.objet = objet;
	this.message = message;
	this.email = email;
	this.password = password;
	this.Edate = Edate;
}



public Date getEdate() {
	return Edate;
}



public void setEdate(Date edate) {
	Edate = edate;
}



public Mail() {
	// TODO Auto-generated constructor stub
}


public String getDestinataire() {
	return destinataire;
}

public void setDestinataire(String destinataire) {
	this.destinataire = destinataire;
}

public String getObjet() {
	return objet;
}

public void setObjet(String objet) {
	this.objet = objet;
}

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
  
public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "Mail [destinataire=" + destinataire + ", objet=" + objet + ", message=" + message + "]";
}

public int getId() {
	return id;
}

public void setid(int uid) {
	this.id =uid;
	
}

}
