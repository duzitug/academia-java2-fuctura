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
public class Veiculo {
    
    private String marca;
    
    @Id
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String marca, String placa) {
        this.marca = marca;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
      
}
