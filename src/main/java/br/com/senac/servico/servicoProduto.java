/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.servico;

import br.com.senac.Exceptions.DataSourceException;
import br.com.senac.Exceptions.ProductExceptions;
import br.com.senac.Gerenciamento.GerenciadorProduto;
import br.com.senac.objects.Product;
import br.com.senac.validation.ProductValidation;

/**
 *
 * @author victor.rslucca
 */
public class servicoProduto {
    public static void inserirProduto(Product produto)throws ProductExceptions, DataSourceException {
        ProductValidation.productValidation(produto);
        
        try {
            
            GerenciadorProduto.incluir(produto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro ao cadastrar o produto, tente novamente");
        }
    }
 
}
