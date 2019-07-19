/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.interfaces;

import br.com.merciof.locadoraveiculos.entidades.Veiculo;
import java.util.List;

/**
 *
 * @author merciof
 */
public interface VeiculoDAO {
    
    public void inserir(Veiculo veiculo);
    public Veiculo selecionar(String placa);
    public void remover(Veiculo veiculo);
    public void atualizar(Veiculo veiculo);
    public List<Veiculo> listarVeiculo();   
    
}
