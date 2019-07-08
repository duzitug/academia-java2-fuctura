/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.interfaces;

import java.util.List;

/**
 *
 * @author merciof
 */
public interface LojaDAO {
    
    public void inserir(LojaDAO loja);
    public ContaDAO selecionar();
    public void remover(LojaDAO loja);
    public void atualizar(LojaDAO loja);
    public List<LojaDAO> listarLoja(); 
    
}
