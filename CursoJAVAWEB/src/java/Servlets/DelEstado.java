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
@WebServlet(name = "DeleteEstado", urlPatterns = {"/DeleteEstado"})
public class DelEstado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ConectaBanco conexao=new ConectaBanco();
    Connection resp;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
        String id=request.getParameter("txtCod");
       
        if(!id.equals("")){    
            
            
         try {
            resp=conexao.conectaPostgre("sistemavideoaula");
            
            if(resp!=null){
               
               
                    PreparedStatement pst=resp.prepareStatement("delete from estados where id_estado=?");
                    pst.setInt(1,Integer.parseInt(id));
                    
                    pst.execute();  
                    response.sendRedirect("ExcluirEstado.jsp");
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalvaEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
         }else{
                  response.sendRedirect("FalhaCadastro.jsp");
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
        
        
        
        
        
    }
    }




