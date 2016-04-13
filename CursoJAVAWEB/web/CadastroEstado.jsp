<%-- 
    Document   : CadastroEstado
    Created on : 05/07/2015, 23:34:54
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de cadastro de estado</title>
        <link rel="stylesheet" href="LayoutGeral.css">
    </head>
    
    
   <body>
    <form id="Estado"action ="./SalvaEstado">      
      <div id="geral">
        <div id="Titulo">
        <h1>Estado</h1>
        </div>
        
        <div id="Campos">
            <h3>Nome do Estado:<input type="text" name="txtEstado" value="" /></h3>
        <h3>Sigla do Estado:<input type="text" name="txtSigla" value="" /></h3>
        </div>
        
        
         <div id="Botoes">
             <input type="submit" value="Gravar" name="btnGravar" />
             
             <%--
             <input type="submit" value="Editar" name="btnEditar" />
             <input type="submit" value="Excluir" name="btnExcluir" />
             
             --%>
        </div>
          
          
       </div> 
        
    </form>   
    </body>
</html>
