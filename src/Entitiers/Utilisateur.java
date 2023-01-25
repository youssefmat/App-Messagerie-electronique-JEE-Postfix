package Entitiers;

public class Utilisateur {
    private int idUser;
    private String nom;
    private String prenom;
    private String CompteEmail;
    private String password;
	public Utilisateur( String prenom,String nom, String compteEmail, String password) {
		
		this.prenom = prenom;
		this.nom = nom;
		CompteEmail = compteEmail;
		this.password = password;
	}
	public Utilisateur( int idUser,String prenom, String nom, String compteEmail,String password) {
		this.idUser=idUser;
		this.prenom = prenom;
		this.nom = nom;
		this.CompteEmail = compteEmail;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCompteEmail() {
		return CompteEmail;
	}
	public void setCompteEmail(String compteEmail) {
		CompteEmail = compteEmail;
	}
	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", CompteEmail=" + CompteEmail
				+ "]";
	}
}
