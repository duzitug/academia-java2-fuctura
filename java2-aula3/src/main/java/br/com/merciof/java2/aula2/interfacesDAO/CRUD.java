/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.interfacesDAO;

import java.util.List;

/**
 *
 * @author JAVA
 * @param <Entidade>
 */
public interface CRUD<Entidade> {
    
    public void create(Entidade e) throws Exception;
    
    public List<Entidade> listarTodos() throws Exception;
    
    public Entidade listarPorId(int id) throws Exception;
    
    public void atualizar(Entidade e) throws Exception;
    
    public void remover(int id) throws Exception;
    
}
