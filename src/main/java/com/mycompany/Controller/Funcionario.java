package com.mycompany.Controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String NombreF; 
    private String TipoOcupacion;
    private int Telefono;
    private int Precio;
    private int Disponible;

    public Funcionario() {
    }

    public Funcionario(int id, String NombreF, String TipoOcupacion, int Telefono, int Precio, int Disponible) {
        this.id = id;
        this.NombreF = NombreF;
        this.TipoOcupacion = TipoOcupacion;
        this.Telefono = Telefono;
        this.Precio = Precio;
        this.Disponible = Disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreF() {
        return NombreF;
    }

    public void setNombreF(String NombreF) {
        this.NombreF = NombreF;
    }

    public String getTipoOcupacion() {
        return TipoOcupacion;
    }

    public void setTipoOcupacion(String TipoOcupacion) {
        this.TipoOcupacion = TipoOcupacion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getDisponible() {
        return Disponible;
    }

    public void setDisponible(int Disponible) {
        this.Disponible = Disponible;
    }
    
   
}
