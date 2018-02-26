/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.validation;

import br.com.senac.Exceptions.ProductExceptions;
import br.com.senac.objects.Product;

/**
 *
 * @author vorticl
 */
public class ProductValidation {
    public static void productValidation(Product product) throws ProductExceptions{
        if (product.getName().isEmpty() || product.getName().length()>25) {
            throw new ProductExceptions("É necessario informar o nome do produto!");
        }
        if (product.getDescription().isEmpty() || product.getDescription().length()>25) {
            throw new ProductExceptions("É necessario informar a descrição do produto!");
        }
        if (product.getPriceIn()<=0) {
            throw new ProductExceptions("É necessario informar o preço de compra do produto!");
        }
        if (product.getPriceOut()<=0) {
            throw new ProductExceptions("É necessario informar o preço de venda do produto!");
        }
        if (product.getAmount()<=0) {
            throw new ProductExceptions("É necessario informar o quantidade de produtos!");
        }
    }
}
