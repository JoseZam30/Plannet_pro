/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.asynchttpclient.Dsl.request;



public class createEventoServ extends HttpServlet {

 Usuario u = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ConexionBD conn = new ConexionBD();
        
        Connection conexion = null;
        PreparedStatement pstmt = null;
       int paqueteEveInt ;
       String NombreEve = request.getParameter("nomEvento");
       String LugarEve = request.getParameter("lugEvento");    
       String FechaEve = request.getParameter("fechEvento");
       String PaqueteEve = request.getParameter("seleccion");
       String Metodo = request.getParameter("metodoPago");
       String Producto = request.getParameter("productosSeleccionados");
       
      if (PaqueteEve.equals("1") || PaqueteEve.equals("2") || PaqueteEve.equals("3")) {
            paqueteEveInt = Integer.parseInt(PaqueteEve);
            } else {
                 paqueteEveInt = 4;
            }

       
       System.out.println(u.getId());
       
    HttpSession session = request.getSession();
    String idString = (String) session.getAttribute("ID");
    int id = Integer.parseInt(idString);
    
    ConsultaEvento consulta = new ConsultaEvento();

    consulta.metodoQueRecibeId(id);
    consulta.setId(id);

try (Connection con = conn.getConnection()){
    String sql = "INSERT INTO EVENTO (`ESTADOEVENTO`, `FECHAEVENTO`, `LUGAREVENTO`, `NOMBREEVENTO`, `ID_PAQUETE`, `METODODEPAGO`, `ID_USUARIO`, `DESCRIPCION`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
       pstmt = con.prepareStatement(sql);  
      
                pstmt.setString(1, "En Curso");
                pstmt.setString(2, FechaEve);
                pstmt.setString(3, LugarEve);
                pstmt.setString(4, NombreEve);
                pstmt.setInt(5, paqueteEveInt);
                pstmt.setString(6, Metodo);
                pstmt.setInt(7, id);
                pstmt.setString(8, Producto);
                pstmt.executeUpdate();
                con.close();
                out.println(pstmt);
                  out.println("EVENTO CREADO correctamente.");
       } catch (SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
            
        } finally {
           
        }
       
       response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
}
