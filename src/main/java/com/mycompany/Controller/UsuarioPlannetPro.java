
package com.mycompany.Controller;

import com.mycompany.Controller.ConsultaEvento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UsuarioPlannetPro extends HttpServlet {
   ConsultaEvento consultaEvento = new ConsultaEvento();
     ConexionBD conn = new ConexionBD();
     UsuarioDAO dao = new UsuarioDAO();
     Usuario u = new Usuario();
     int r = 0 ;
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        u.setCorreo(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
       String accion=request.getParameter ("accion");
    if (accion.equals ("ingresar")) {
        
        String Correo=request.getParameter ("email");
        String Password=request.getParameter ("password");
        
        u.setCorreo(Correo);
        u.setPassword(Password);
        
        r = dao.validarUsuario(u);
     
        if (r == 1){
            int idUsuario = u.getId();
            String idString = String.valueOf(idUsuario);
            dao.r = 0;
            HttpSession session = request.getSession();
            List<Evento> eventos = consultaEvento.obtenerEventosUsuario(idUsuario);
            request.setAttribute("eventos", eventos);
            
            
            request.getSession().setAttribute ("ID", idString);
            request.getSession().setAttribute ("Correo", Correo);
            request.getRequestDispatcher("index.jsp").forward(request, response);
           
        }else{
          
         
         request.getRequestDispatcher("inicionSesion.jsp").forward(request, response);
            
           
            
        }
    }
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
        u.setCorreo(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
