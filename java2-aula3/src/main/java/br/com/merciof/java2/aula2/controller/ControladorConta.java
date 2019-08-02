/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.controller;

import br.com.merciof.java2.aula2.jdbc.PoupancaDAOImpl;
import br.com.merciof.java2.aula2.model.ContaPoupanca;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String solicitarConta() {
        String result = "";
        List<ContaPoupanca> listaConta = null;
        
        try {
            listaConta = pdao.listarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ControladorConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(ContaPoupanca contaPoupanca : listaConta) {
            result += "ID_CONTA: " + contaPoupanca.getIdConta()
                     + "\n AGENCIA: " + contaPoupanca.getAgencia()
                     + "\n NUMERO: " + contaPoupanca.getNumero()
                     + "\n SALDO: " + contaPoupanca.getSaldo();
        }
        
        return result;
    }
}
