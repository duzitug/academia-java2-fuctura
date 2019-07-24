/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.model;

/**
 *
 * @author JAVA
 */
public class ContaPoupanca extends Conta{
   
    private static double RENDIMENTO = 1.005;

    public ContaPoupanca(int numero, int agencia, float saldo, int FK_ID_CLIENTE) {
        super(numero, agencia, saldo, FK_ID_CLIENTE);
    }

    public static double getRENDIMENTO() {
        return RENDIMENTO;
    }
    
    
    
}
