/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.interfacesDAO;

import br.com.merciof.java2.aula2.model.Conta;

/**
 *
 * @author JAVA
 */
public interface ContaDAO {
    
    public void inserir(Conta conta);
    public void remover(int idConta);
    public void selecionar(int idConta);
    public void atualizar(Conta conta);
    
}
