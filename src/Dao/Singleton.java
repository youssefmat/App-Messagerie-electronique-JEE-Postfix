package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
	private static Singleton uniqueInstance;
    private Singleton() {
   	 
    }
    
    public static Singleton getInstance() {
   	 if(uniqueInstance==null) {
   		 uniqueInstance= new Singleton();
   	 }
   	 return uniqueInstance;
    }
    
    public Connection getConnection() {
   	 Connection conn=null;
   	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.199.148:3306/mailserver","root","MysqlPostfix22@");
		} catch (Exception ex) {
			System.out.println("Erreur connexion !:"+ex.getMessage());
		}
   	 return conn;
    }
}
