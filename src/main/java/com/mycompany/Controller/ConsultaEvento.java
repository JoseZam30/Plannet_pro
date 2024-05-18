
package com.mycompany.Controller;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


public class ConsultaEvento {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
        public void metodoQueRecibeId(int id) {
       
    }
        
    ConexionBD con = new ConexionBD();

     Connection conn;
     PreparedStatement stmt;
     ResultSet rs;
    Evento ev = new Evento();
    public List<Evento> obtenerEventosUsuario(int idUsuario) {
    ArrayList<Evento> eventos = new ArrayList<Evento>();   
       
    conn = con.getConnection();
    String sql = "SELECT E.NOMBREEVENTO, E.LUGAREVENTO, E.FECHAEVENTO, P.TIPOPAQUETE, E.ESTADOEVENTO, E.METODODEPAGO FROM USUARIO U, EVENTO E, PAQUETE P WHERE E.ID_USUARIO = U.ID AND P.ID = E.ID_PAQUETE AND U.ID = ? ";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            Evento ev = new Evento(); // Crear una nueva instancia en cada iteración
            ev.setNombreEvento(rs.getString("NOMBREEVENTO"));
            ev.setLugarEvento(rs.getString("LUGAREVENTO"));
            ev.setFechaEvento(rs.getDate("FECHAEVENTO"));
            ev.setTipoPaquete(rs.getString("TIPOPAQUETE"));
            ev.setEstadoEvento(rs.getString("ESTADOEVENTO"));
            ev.setMetodoPago(rs.getString("METODODEPAGO"));
            eventos.add(ev);
            
        }
        
        rs.close();
        stmt.close();
        con.con.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return eventos;
}

       
         public Evento eventos() {
        String sql = "SELECT E.NOMBREEVENTO, E.LUGAREVENTO, E.FECHAEVENTO, P.TIPOPAQUETE, E.ESTADOEVENTO, E.METODODEPAGO FROM USUARIO U, EVENTO E, PAQUETE P WHERE E.ID_USUARIO = U.ID AND P.ID = E.ID_PAQUETE AND U.ID = ? ";
        try {
            conn = con.getConnection();
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){                
               ev.setNombreEvento(rs.getString("NOMBREEVENTO"));
               ev.setLugarEvento(rs.getString("LUGAREVENTO"));
               ev.setFechaEvento(rs.getDate("FECHAEVENTO"));
               ev.setTipoPaquete(rs.getString("TIPOPAQUETE"));
               ev.setEstadoEvento(rs.getString("ESTADOEVENTO"));
               ev.setMetodoPago(rs.getString("METODODEPAGO"));
                
            }
        } catch (Exception e) {
        }
       return ev; 
    }

   
    }



