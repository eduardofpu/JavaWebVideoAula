/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class ConectaBanco {
        public Statement statement;
        public ResultSet resultset;
        public Connection con=null;
        String caminho= "jdbc:postgresql://localhost:5432/";
        String usuario="postgres";
        String senha="5432";
        
  public Connection conectaPostgre(String banco) throws SQLException{
      
        try{
         
            Class.forName("org.postgresql.Driver");
        try{
                con=DriverManager.getConnection(caminho+banco, usuario, senha);
                
            }catch(SQLException ex){
                System.out.println("Caminho,senha ou usuários incorretos");
            }
            }catch( ClassNotFoundException ex){
                   System.out.println("Driver não encontrado");
            
        }
           return con;    
  }
  
  
 
  
  public void ExecutaSql(String sql) {
      
        
        try{
               statement=con.createStatement(resultset.TYPE_SCROLL_INSENSITIVE,resultset.CONCUR_READ_ONLY);
               resultset=statement.executeQuery(sql);
            }catch(SQLException e){
               e.printStackTrace();
               JOptionPane.showMessageDialog(null,"ERRO:"+e);
            
        }
             
  }
  
  
  
}
