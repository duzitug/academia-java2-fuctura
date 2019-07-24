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
public class Conta {
    
    private int idConta;
    private int numero;
    private int agencia;
    private float saldo;
    private int FK_ID_CLIENTE;

    public Conta(int numero, int agencia, float saldo, int FK_ID_CLIENTE) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.FK_ID_CLIENTE = FK_ID_CLIENTE;
    }

    public Conta() {
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getFK_ID_CLIENTE() {
        return FK_ID_CLIENTE;
    }

    public void setFK_ID_CLIENTE(int FK_ID_CLIENTE) {
        this.FK_ID_CLIENTE = FK_ID_CLIENTE;
    }
    
    
}
