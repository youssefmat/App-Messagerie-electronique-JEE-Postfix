package Metier;

import Entitiers.Utilisateur;

public interface IUtilisateur {
	public Utilisateur findOne(int id);
   public void addUser(Utilisateur user);
   public void updateUser(Utilisateur user);
   public void deleteUser(int idUser);
   public Utilisateur getUtilisateur(String email,String password);
}
