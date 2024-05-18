package com.mycompany.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
  
   Connection con;  
   public ConexionBD(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProyectoPlannetPro", "root", "");
           System.out.println("Se conecto");
       } catch (Exception e) {
            System.err.println("Error"+e);
           System.out.println("No se conecto");
       }
   }
   public Connection getConnection(){
        return con;
    }
}
