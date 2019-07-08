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
public interface UsuarioDAO {
    
    public void inserir(UsuarioDAO usuario);
    public ContaDAO selecionar();
    public void remover(UsuarioDAO usuario);
    public void atualizar(UsuarioDAO usuario);
    public List<UsuarioDAO> listarUsuario(); 
    
}
