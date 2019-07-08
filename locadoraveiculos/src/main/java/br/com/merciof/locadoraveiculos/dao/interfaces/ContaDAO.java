/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.interfaces;

import br.com.merciof.locadoraveiculos.entidades.Conta;
import java.util.List;

/**
 *
 * @author merciof
 */
public interface ContaDAO {
    public void inserir(Conta conta);
    public Conta selecionar(int numero);
    public void remover(Conta conta);
    public void atualizar(Conta conta);
    public List<Conta> listarConta(); 
}
