/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.controller;

import br.com.merciof.locadoraveiculos.dao.interfaces.ContaDAO;
import br.com.merciof.locadoraveiculos.dao.jdbc.ContaDAOImpl;

/**
 *
 * @author merciof
 */
public class Main {
    public static void main(String[] args) {
        
        ContaDAO contaDAO = new ContaDAOImpl();  
       
        
        //contaDAO.inserir(conta);
        
        System.out.println("conta: " + contaDAO.selecionar(1).getSaldo());
    }
}
