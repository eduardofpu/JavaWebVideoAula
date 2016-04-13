<%-- 
    Document   : ExcluirEstado
    Created on : 06/07/2015, 19:33:47
    Author     : Eduardo
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Controle.ConectaBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir</title>
        <link rel="stylesheet" href="ExcluirEstado.css">
    </head>
    <body>
        
        <form id="Estado"action ="./DeleteEstado" id="Delete">      
        
      <center>  
        <h1>Excluir um Estado</h1>
         <h3>Informe o codigo do estado que deseja excluir  <input type="text" name="txtCod" value="" id="txtCod"></h3>
          
      </center>
    
    <div id="Tabela">
       
        
  
      <table  border="1" >
          <tr>
           <td> código do estado </td>
            
            <td> Nome do Estado  </td>
            
            <td> Sigla </td>
           
            
            
            </tr>
            
            <%
            
            
            ConectaBanco conexao=new ConectaBanco();
            
            Connection resp;
            resp=   conexao.conectaPostgre("sistemavideoaula");
            conexao.ExecutaSql("select * from estados order by id_estado");
            conexao.resultset.first();                
            
            
               do{
               out.println("<tr>  ");
               
               out.println("<td>"+conexao.resultset.getInt("id_estado")+"</td>");
               out.println("<td>"+conexao.resultset.getString("nome_estado")+"</td>");
               out.println("<td>"+conexao.resultset.getString("sigla_estado")+"</td>"); 
               
                              
               out.println("</tr>");
                 
               }while(conexao.resultset.next());
               
               %>
                
            </tr>
            
           
       </table>
               <br>
         <input type="submit"  value="Confirmar" name="btnConfirma">
     </div> 
               
        </form>              
    </body>
</html>
