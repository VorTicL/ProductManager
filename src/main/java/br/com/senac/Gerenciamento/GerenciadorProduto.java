/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.Gerenciamento;

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
public class GerenciadorProduto {
    
     private static Connection Conexao() throws SQLException, Exception {
          Class.forName("com.mysql.jdbc.Driver");
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/produtobd", "root", "");
     }
    public List<Product> consultar() throws SQLException, Exception {
        
         String query = "SELECT id, nome,descricao, preco_compra, preco_venda, quantidade, dt_cadastro from produto ";
         
         List<Product> lista = new ArrayList<Product>();
         try (Connection conn = Conexao(); 
                PreparedStatement stmt = conn.prepareStatement(query)) {
             
         try (ResultSet resul = stmt.executeQuery()) {
                
                while(resul.next()) {
                    Product p = new Product();
                    p.setId(resul.getLong("id"));
                    p.setName(resul.getString("nome"));
                    p.setDescription(resul.getString("descricao"));
                    p.setPriceIn(resul.getDouble("preco_compra"));
                    p.setPriceOut(resul.getDouble("preco_venda"));
                    p.setAmount(resul.getInt("quantidade"));
                    p.setData(resul.getDate("dt_cadastro"));
                    lista.add(p);
                    
                }
            }
            
        } catch (Exception e) {
            
        }
         
         return lista;
    
    }
    // Metodo buscar na database pelo nome
    public List<Product> buscarProd(String produto) throws SQLException, Exception {
        
        String query = "SELECT * from produto WHERE nome = ? ";
         
        List<Product> lista = new ArrayList<Product>();
        try (Connection conn = Conexao(); 
                PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(0, produto);
             
            try (ResultSet resul = stmt.executeQuery()) {

                   while(resul.next()) {
                       Product p = new Product();
                       p.setId(resul.getLong("id"));
                       p.setName(resul.getString("nome"));
                       p.setDescription(resul.getString("descricao"));
                       p.setPriceIn(resul.getDouble("preco_compra"));
                       p.setPriceOut(resul.getDouble("preco_venda"));
                       p.setAmount(resul.getInt("quantidade"));
                       p.setData(resul.getDate("dt_cadastro"));
                       lista.add(p);

                   }
            }
            
        }catch (Exception e) {

            
            
        }
         
        return lista;
        
    } 
    
    public static void incluir(Product p) throws SQLException, Exception {
        String query = "INSERT INTO produto (nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro) VALUES (?, ?, ?, ?, ?,?)";
        
        try (Connection conn = Conexao();
                PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPriceIn());
            stmt.setDouble(4, p.getPriceOut());
            stmt.setInt(5, p.getAmount());
            stmt.setDate(6, new java.sql.Date(p.getData().getTime()));
            stmt.executeUpdate();
            
        }
        
    }
    public void atualizar(Product p) throws SQLException, Exception {
        String query = "UPDATE produto SET nome=?, descricao=?, preco_compra=?, preco_venda=?, quantidade=?, dt_cadastro=? "
                +"WHERE (produto_id=?)";
        try (Connection conn = Conexao();
                PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPriceIn());
            stmt.setDouble(4, p.getPriceOut());
            stmt.setInt(5, p.getAmount());
            stmt.setDate(6, new java.sql.Date(p.getData().getTime()));
            stmt.executeUpdate();
    }
}
}
