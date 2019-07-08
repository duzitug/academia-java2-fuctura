/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author merciof
 */
@Entity
public class Conta {
    
    @Id
    private int numero;
    private double saldo;
    private double limite;

    public Conta() {
    }

    public Conta(int numeto, double saldo, double limite) {
        this.numero = numeto;
        this.saldo = saldo;
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  
}
