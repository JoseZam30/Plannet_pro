/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class ServletPlannetPro extends HttpServlet {
    
    private int generateUniqueID() {
    int newID = 0;
  PreparedStatement pstmt = null;
  ConexionBD conn = new ConexionBD();
 ResultSet rs = null;
    try {
       Connection con = conn.getConnection();
        String sql = "SELECT MAX(ID) FROM USUARIO";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            long lastID = rs.getLong(1);
            newID = (int) (lastID + 1);
        } else {
            // Si la tabla está vacía, asigna el ID inicial como 1
            newID = 1;
        }
    } catch (SQLException e) {
        System.err.println("Error en la consulta SQL: " + e.getMessage());
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.con.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar los recursos: " + e.getMessage());
        }
    }

    return newID;
}

private boolean usuarioRegistrado(String Correo) throws SQLException {
        ConexionBD conn = new ConexionBD();
    Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean registrado = false;
   
        try (Connection con = conn.getConnection()){
            // Establecer conexión con la base de datos (asegúrate de tener las credenciales y la URL de la base de datos correctas)
            
            // Consulta SQL para verificar si el usuario ya está registrado
            String sql = "SELECT COUNT(*) AS total FROM USUARIO WHERE CORREO = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, Correo);
            resultSet = statement.executeQuery();
            
            // Verificar si se encontraron resultados
            if (resultSet.next()) {
                int total = resultSet.getInt("total");
                if (total > 0) {
                    registrado = true; // El usuario ya está registrado
                }
            }
        } finally {
            // Cerrar la conexión y liberar recursos
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        
        return registrado;
    }
    
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
     processRequest(request, response);
         ConexionBD conn = new ConexionBD();
         EnvioCorreos Evn = new EnvioCorreos();

    String emailFrom = "plannetproproyect@gmail.com";
    String passwordFrom = "gdcahswtszvtqrsc";
    String emailTo;
    String subject;
    String content;
    Properties mProperties;
    Session mSession;
   
    MimeMessage mCorreo = null;
  
       String NombreUsuario = request.getParameter("NombreUsuario");
       String ApellidoUsuario = request.getParameter("ApellidoUsuario");    
       String Correo = request.getParameter("CorreoUsuario");
       String Numero = request.getParameter("TelUsuario");
       String Password = request.getParameter("PassUsuario");
  
        long telefono = Long.parseLong(Numero);

        Connection conexion = null;
        PreparedStatement pstmt = null;
        int idUsuario = generateUniqueID();
try (Connection con = conn.getConnection()){
    String sql = "INSERT INTO USUARIO (`ID`, `APELLIDOUSUARIO`, `CORREO`, `NOMBREUSUARIO`, `NUMERO`, `PASSWORD`) VALUES (?, ?, ?, ?, ?, ?);";
       pstmt = con.prepareStatement(sql);  
                pstmt.setInt(1, idUsuario);
                pstmt.setString(4, NombreUsuario);
                pstmt.setString(2, ApellidoUsuario);
                pstmt.setString(3, Correo);
                pstmt.setString(5, Numero);
                pstmt.setString(6, Password);
                pstmt.executeUpdate();
            con.close();
    out.println("Datos agregados correctamente.");

        } catch (SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        } finally {
           
        }
       emailTo = Correo.trim();
       subject = "Bienvenido a PlannetPro";
       content = "<!DOCTYPE html>\n" +
                      "<html lang=\"es\">\n" +
                      "<head>\n" +
                      "    <meta charset=\"UTF-8\">\n" +
                      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                      "    <title>Bienvenido a PlannetPro</title>\n" +
                      "    <style>\n" +
                      "        body {\n" +
                      "            font-family: Arial, sans-serif;\n" +
                      "            background-color: #f5f5f5;\n" +
                      "            padding: 20px;\n" +
                      "        }\n" +
                      "        .container {\n" +
                      "            max-width: 600px;\n" +
                      "            margin: 0 auto;\n" +
                      "            background-color: #fff;\n" +
                      "            padding: 20px;\n" +
                      "            border-radius: 10px;\n" +
                      "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n" +
                      "        }\n" +
                      "        h1 {\n" +
                      "            color: #333;\n" +
                      "            text-align: center;\n" +
                      "        }\n" +
                      "        p {\n" +
                      "            color: #666;\n" +
                      "            font-size: 16px;\n" +
                      "            line-height: 1.6;\n" +
                      "            margin-bottom: 20px;\n" +
                      "        }\n" +
                      "        .button {\n" +
                      "            display: inline-block;\n" +
                      "            background-color: #4CAF50;\n" +
                      "            color: #fff;\n" +
                      "            padding: 10px 20px;\n" +
                      "            text-decoration: none;\n" +
                      "            border-radius: 5px;\n" +
                      "            transition: background-color 0.3s;\n" +
                      "        }\n" +
                      "        .button:hover {\n" +
                      "            background-color: #45a049;\n" +
                      "        }\n" +
                      "    </style>\n" +
                      "</head>\n" +
                      "<body>\n" +
                      "    <div class=\"container\">\n" +
                      "        <h1>Bienvenido a PlannetPro</h1>\n" +
                      "        <p>¡Hola "+NombreUsuario+" !</p>\n" +
                      "        <p>Has iniciado sesión exitosamente en PlannetPro. Estamos encantados de tenerte con nosotros.</p>\n" +
                      "        <p>PlannetPro es tu destino definitivo para organizar tus tareas, planificar eventos y colaborar con tu equipo. ¡Esperamos que disfrutes de la experiencia!</p>\n" +
                      "        <p>¡Gracias por unirte a nuestra comunidad!</p>\n" +
                      "        <p>Atentamente,<br>El equipo de PlannetPro</p>\n" +
                      "        <p><a href=\"http://localhost:8080/PlannetproProyect/index.html \" class=\"button\">Ir a PlannetPro</a></p>\n" +
                      "    </div>\n" +
                      "</body>\n" +
                      "</html>";
       mProperties = new mProperties(); 
       mProperties.put("mail.smtp.host","smtp.gmail.com");
       mProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
       mProperties.setProperty("mail.smtp.starttls.enable","true");
       mProperties.setProperty("mail.smtp.port", "587");
       mProperties.setProperty("mail.smtp.user", emailFrom);
       mProperties.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
       mProperties.setProperty("mail.smtp.auth","true");
       
       mSession = Session.getDefaultInstance(mProperties);
    
       
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content,"ISO-8859-1","html");
            
        } catch (AddressException ex) {
            Logger.getLogger(ServletPlannetPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ServletPlannetPro.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport .connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            
            //JOptionPane.showMessageDialog(null, "correo enviado");
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ServletPlannetPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ServletPlannetPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("inicionSesion.jsp");
        
       
        
        
        
        
        
      
        
//        
//        String NombreUsuario = request.getParameter("NombreUsuario");
//        String ApellidoUsuario = request.getParameter("ApellidoUsuario");
//        String Correo = request.getParameter("CorreoUsuario");
//        String Numero = request.getParameter("TelUsuario");
//        String Password = request.getParameter("PassUsuario");
//        
//       
//       System.out.println(NombreUsuario);
//       System.out.println(ApellidoUsuario);
//        Usuario usuario = new Usuario(0,NombreUsuario,ApellidoUsuario,Numero,Correo,Password);
//       
//        usuJpa.create(usuario);
//        
//        response.sendRedirect("index.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
private void CrearCorreo() {
    
}

    private void createEmail() {
        
   
    
    }

    private void sendEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class mProperties extends Properties {

        public mProperties() {
        }
    }

   
}
