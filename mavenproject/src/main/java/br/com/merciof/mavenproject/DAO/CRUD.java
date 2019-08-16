/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.mavenproject.DAO;

import java.util.List;

/**
 *
 * @author JAVA
 */
public interface CRUD <Tipo> {
    
    public void salvar(Tipo entidade);
    public void deletar(Tipo entidade);
    public Tipo getById(int id);
    public List<Tipo> listAll();
    
}
