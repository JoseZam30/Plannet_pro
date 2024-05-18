/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String NombreEvento;
    private String LugarEvento;
    private String EstadoEvento;

    @Temporal(TemporalType.DATE)
    private Date FechaEvento;

    private String TipoPaquete;
    private String MetodoPago;

    public Evento() {
    }

    public Evento(String nombreEvento, String lugarEvento, String fechaEvento, String tipoPaquete, String estadoEvento, String metodoPago) {
    }

    public Evento(int id, String NombreEvento, String LugarEvento, String EstadoEvento, Date FechaEvento, String TipoPaquete, String MetodoPago) {
        this.id = id;
        this.NombreEvento = NombreEvento;
        this.LugarEvento = LugarEvento;
        this.EstadoEvento = EstadoEvento;
        this.FechaEvento = FechaEvento;
        this.TipoPaquete = TipoPaquete;
        this.MetodoPago = MetodoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return NombreEvento;
    }

    public void setNombreEvento(String NombreEvento) {
        this.NombreEvento = NombreEvento;
    }

    public String getLugarEvento() {
        return LugarEvento;
    }

    public void setLugarEvento(String LugarEvento) {
        this.LugarEvento = LugarEvento;
    }

    public String getEstadoEvento() {
        return EstadoEvento;
    }

    public void setEstadoEvento(String EstadoEvento) {
        this.EstadoEvento = EstadoEvento;
    }

    public Date getFechaEvento() {
        return FechaEvento;
    }

    public void setFechaEvento(Date FechaEvento) {
        this.FechaEvento = FechaEvento;
    }

    public String getTipoPaquete() {
        return TipoPaquete;
    }

    public void setTipoPaquete(String TipoPaquete) {
        this.TipoPaquete = TipoPaquete;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    @Override
    public String toString() {
        return "Evento{"
                + "id=" + id
                + ", NombreEvento='" + NombreEvento + '\''
                + ", LugarEvento='" + LugarEvento + '\''
                + ", EstadoEvento='" + EstadoEvento + '\''
                + ", FechaEvento=" + FechaEvento
                + ", TipoPaquete='" + TipoPaquete + '\''
                + ", MetodoPago='" + MetodoPago + '\''
                + '}';
    }

}
