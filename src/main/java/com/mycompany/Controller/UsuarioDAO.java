/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO implements validarUsuario {
    Usuario usu = new Usuario();
    Connection conn;
    ConexionBD con = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    int i = 0;

   int idUsuario;
    
    @Override
    public int validarUsuario(Usuario usu) {
        String sql="SELECT id, CORREO, PASSWORD FROM USUARIO WHERE CORREO = ? AND PASSWORD = ?";
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,usu.getCorreo());
            ps.setString(2,usu.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r+1;
                idUsuario = rs.getInt("id");
                usu.setId(rs.getInt("id"));
                usu.setCorreo(rs.getString("CORREO"));
                usu.setPassword(rs.getString("PASSWORD"));
            }
            if (r >= 1) {
                return 1;
            }else {
                return 0;
            }
        } catch (SQLException e){
            return 0;
        }
    }
     public UsuarioDAO() {
        int r1 = r;
    }
    public int validarCorreo(Usuario corr) {
        String sql="SELECT COUNT(*) AS total FROM USUARIO WHERE CORREO = ?";
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,usu.getCorreo());
       
            rs = ps.executeQuery();
            while (rs.next()) {
                i = i + 1;
                
                corr.setCorreo(rs.getString("CORREO"));
            }
            if (i >= 1) {
                return 1;
            }else {
                return 0;
            }
        } catch (SQLException e){
            return 0;
        }
    }

    int idUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


