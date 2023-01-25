package Dao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Entitiers.Utilisateur;
import Metier.IUtilisateur;

public class UtilisateurDao implements IUtilisateur{

	@Override
	public Utilisateur findOne(int id) {
		Utilisateur utilisateur =null;
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm = conn.prepareStatement("select * from virtual_users where id=?");
			stm.setInt(1,id);
			ResultSet result = stm.executeQuery(); 
			if(result.next()) {
				int idUser=result.getInt("id");
				String prenom=result.getString("prenom");
				String  nom=result.getString("Nom");
				String compteEmail=result.getString("email");
				String pass=result.getString("password");
				utilisateur=new Utilisateur(idUser, prenom, nom, compteEmail,pass);
			}
			
			
		} catch (Exception ex) {
			System.out.println("Erreur SQL:"+ex.getMessage());
		}
	
		return utilisateur;
	}

	@Override
	public void addUser(Utilisateur user) {
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm =conn.prepareStatement("INSERT INTO `virtual_users` (`Nom`, `prenom`, `domain_id`, `email`, `password`) VALUES (?, ?, ?, ?, ?)");
			
			stm.setString(1,user.getNom());
			stm.setString(2,user.getPrenom());
			stm.setInt(3, 1);
			stm.setString(4, user.getCompteEmail()+"@smpt.local.com");
			stm.setString(5,user.getPassword());
			//DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//Date date = new Date();
			//stm.setString(5,format.format(date));
			stm.execute();
			
			
			
		} catch (Exception e) {
			System.out.println("Erreur d'ajouter en SQL:"+e.getMessage());
		
		}
		
		
	}

	@Override
	public void updateUser(Utilisateur user) {
		
		
	}

	@Override
	public void deleteUser(int idUser) {
		
		
	}

	@Override
	public Utilisateur getUtilisateur(String email, String password) {
		Utilisateur user=null;
		try {
			Connection conn=Singleton.getInstance().getConnection();
			PreparedStatement stm = conn.prepareStatement("select * from  virtual_users where  `email`=? and `password`=?");
			stm.setString(1,email);
			stm.setString(2,password);
			ResultSet result = stm.executeQuery();
			if(result.next()) {
				int idUser=result.getInt("id");
				String  nom=result.getString("Nom");
				String prenom=result.getString("prenom");
				String compteEmail=result.getString("email");
				String pass=result.getString("password");
				user=new Utilisateur(idUser, nom, prenom, compteEmail,pass);
			}
		} catch (Exception e) {
			System.out.println("Erreur de connexion :"+e.getMessage());
		}
		
		return user;
	}

}
