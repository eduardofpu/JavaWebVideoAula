/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Controle.ConectaBanco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
@WebServlet(name = "EditaEstado", urlPatterns = {"/EditaEstado"})
public class EditaEstado extends HttpServlet {

        
    
    ConectaBanco conexao=new ConectaBanco();
    Connection resp;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cod=Integer.parseInt(request.getParameter("txtCodEstado"));    
        
        String nome=request.getParameter("txtNomeEstado");
        String sigla=request.getParameter("txtSiglaEstado");
          
        
        
      if(!nome.equals("")&&(!sigla.equals(""))){ 
      try {
            resp=conexao.conectaPostgre("sistemavideoaula");
            
            if(resp!=null){
                //conexao.ExecutaSql("select * from estados where sigla_estado = '"+sigla+"'");
               
               
                
              //  if(!conexao.resultset.first()){
                    PreparedStatement pst=resp.prepareStatement("update  estados set nome_estado=?,sigla_estado=? where id_estado=?");
                    pst.setString(1,nome);
                    pst.setString(2,sigla);
                    pst.setInt(3, cod);
                    pst.execute();  
                    response.sendRedirect("SucessoCadastro.jsp");
               // }else{
                //  response.sendRedirect("FalhaCadastro.jsp");
               // }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      } 
        
       //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.println("<!DOCTYPE html>");
            //out.println("<html>");
           // out.println("<head>");
           // out.println("<title>Servlet SalvaEstado</title>");            
           // out.println("</head>");
           // out.println("<body>");
           // out.println("<h1>Servlet SalvaEstado at " + nome +" e sigla "+sigla+"</h1>");
            // out.println("<h1>Servlet SalvaEstado at " + AchaEstado+"</h1>");
            
           // out.println("</body>");
           // out.println("</html>");
       // }
      
      
      
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
