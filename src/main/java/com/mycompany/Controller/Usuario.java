package com.mycompany.Controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String NombreUsuario; 
    private String ApellidoUsuario;
    private String Numero;
    private String Correo;
    private String Password;

    public Usuario() {
    }
    

    public Usuario(int id, String NombreUsuario, String ApellidoUsuario, String Numero, String Correo, String Password) {
        this.id = id;
        this.NombreUsuario = NombreUsuario;
        this.ApellidoUsuario = ApellidoUsuario;
        this.Numero = Numero;
        this.Correo = Correo;
        this.Password = Password;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Usuario() {
        return NombreUsuario;
    }

    public void setNombre_Usuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellido_Usuario() {
        return ApellidoUsuario;
    }

    public void setApellido_Usuario(String ApellidoUsuario) {
        this.ApellidoUsuario = ApellidoUsuario;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
   
    
}

