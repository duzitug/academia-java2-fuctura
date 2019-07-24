/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.interfacesDAO;

import br.com.merciof.java2.aula2.model.Cliente;
import java.util.List;

/**
 *
 * @author JAVA
 */
public interface ClienteDAO {
    
    public void inserir(Cliente cliente);
    public void remover(int idCliente);
    public Cliente selecionar(int idCliente);
    public void atualizar(Cliente cliente);
    public List<Cliente> listar();
    
}
