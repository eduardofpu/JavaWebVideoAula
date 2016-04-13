<%-- 
    Document   : EditarEstado
    Created on : 06/07/2015, 19:33:34
    Author     : Eduardo
--%>

<%@page import="java.sql.Connection"%>
<%@page import="Controle.ConectaBanco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Estado</title>
    </head>
    <body>
        
        <form action="./EditaEstado">
    <center>
        <h1>Formulário para edição de estados </h1>
        
        <h3>Código: </h3>
        <input type="text" name="txtCodEstado" value="" size="5"/>
        
        <h3>Nome: </h3>
        <input type="text" name="txtNomeEstado" value=""size="50" />
        <h3>Sigla: </h3>
        <input type="text" name="txtSiglaEstado" value="" size="2"/>
        
        <input type="submit" value="Salvar Edição" name="btnEdit" />
        
        <h2>Lista de Estados Cadastrados</h2>
        
        
       
       
        
  
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
          
    
    </center>
               
        </form>
    </body>
</html>
