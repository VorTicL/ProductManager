/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.Product;

import br.com.senac.objects.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João
 */
public class Produto {
    
     private Connection Conexao() throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/produtobd", "root", "");
     }
    public List<Produto> consultar() throws ClassNotFoundException, SQLException {
        
         String query = "SELECT id, nome,descricao, preco_compra, preco_venda, quantidade, dt_cadastro from produto ";
         
         List<Produto> lista = new ArrayList<Produto>();
         try (Connection conn = Conexao(); 
                PreparedStatement stmt = conn.prepareStatement(query)) {
             
         try (ResultSet resultados = stmt.executeQuery()) {
                
                while(resultados.next()) {
                    Product p = new Product();
                    
                }
            }
            
        } catch (Exception e) {
            
        }
         
         return lista;
    
}
