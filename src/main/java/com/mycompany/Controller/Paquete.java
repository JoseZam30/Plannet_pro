
package com.mycompany.Controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Paquete implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String TipoPaquete;
    private int Precio;

    public Paquete() {
    }

    public Paquete(int id, String TipoPaquete, int Precio) {
        this.id = id;
        this.TipoPaquete = TipoPaquete;
        this.Precio = Precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPaquete() {
        return TipoPaquete;
    }

    public void setTipoPaquete(String TipoPaquete) {
        this.TipoPaquete = TipoPaquete;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
    
}
