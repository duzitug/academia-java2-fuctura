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
public interface VeiculoDAO {
    
    public void inserir(VeiculoDAO veiculo);
    public ContaDAO selecionar();
    public void remover(VeiculoDAO veiculo);
    public void atualizar(VeiculoDAO veiculo);
    public List<VeiculoDAO> listarVeiculo();   
    
}
