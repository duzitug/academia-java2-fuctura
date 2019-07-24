/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.controller;

import br.com.merciof.java2.aula2.jdbc.PoupancaDAOImpl;
import br.com.merciof.java2.aula2.model.ContaPoupanca;

/**
 *
 * @author JAVA
 */
public class ControladorConta {
    
    private PoupancaDAOImpl pdao;
    
    public ControladorConta() {
        this.pdao = new PoupancaDAOImpl();
    }
    
    public void solicitarSalvar(int numero, int agencia, float saldo, int FK_ID_CLIENTE) throws Exception {
        ContaPoupanca poup = new ContaPoupanca(numero, agencia, saldo, FK_ID_CLIENTE);
        pdao.create(poup);
    }
}
