<%-- 
    Document   : index
    Created on : 05/07/2015, 22:15:32
    Author     : Eduardo
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Controle.ConectaBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de login</title>
        <link rel="stylesheet" href="index.css">
    </head>
    
    
    <body style="background-color: blue">
        
        
        <%
        
        ConectaBanco conn = new ConectaBanco();
        
        Connection conexecao=conn.conectaPostgre("sistemavideoaula");
        
        if(conexecao!=null)
            out.println("conectado");
        else
            out.println("não conectado");
        
        %>
           <form id="Principal" action ="FormLogin.jsp">
        
             <center><h3>Insira Login e senha</h3></center>
              <div id="Campos"> 
             <h3>Login:<input type="text" name="txtLog" value=""id="txtLog" /></h3>
             <h3>Senha:<input type="password" name="txtSenha" value="" id="txtSenha"/></h3>
             
        <%
        
          if(conexecao!=null){
              
              if((request.getParameter("txtLog")!=null)&& (request.getParameter("txtSenha")!=null)){
                 
               Statement st;
               ResultSet rs;
               
               st=conexecao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.TYPE_FORWARD_ONLY);
               rs=st.executeQuery("select * from login  where login ='"+request.getParameter("txtLog")+"' and senha='"+request.getParameter("txtSenha")+"'");
               if(rs.next()){
                   response.sendRedirect("PaginaPrincipal.jsp");
               }
             }      
          }else{
               out.println("Não foi possivel logar");
          }
        
        %>
             
             
          <input type="submit" value="logar" name="btnLog" id="btnLog" />
          
        </div>
             
             
        </form>
    </body>
</html>
 