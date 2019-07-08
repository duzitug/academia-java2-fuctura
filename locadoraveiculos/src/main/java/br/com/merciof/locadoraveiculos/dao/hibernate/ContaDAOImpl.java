/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.com.merciof.locadoraveiculos.dao.interfaces.ContaDAO;
import br.com.merciof.locadoraveiculos.entidades.Conta;
import javax.persistence.Query;

/**
 *
 * @author merciof
 */
public class ContaDAOImpl implements ContaDAO {

        private EntityManager em;
        private EntityTransaction et;
    
    @Override
    public void inserir(Conta conta) {
         try {
            et = em.getTransaction();
            et.begin();
            em.persist(conta);
            et.commit();
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir conta: " + e.getMessage());
        }
    }

    @Override
    public Conta selecionar(int idConta) {
           
        Conta conta = new Conta();
        try {
            conta = em.find(Conta.class, idConta);
        } catch (Exception e) {
            
        } 
        return conta;
    }

    @Override
    public void remover(Conta conta) {
        try {
            et.begin();
            em.remove(conta);
            et.commit();
        } catch (Exception e) {
            System.out.println("Erro transação: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Conta conta) {
         et = em.getTransaction();
         et.begin();
         em.merge(conta);
         et.commit();
    }

    @Override
    public List<Conta> listarConta() {
        Query query = em.createQuery("from Conta c");
        List<Conta> listar = query.getResultList();
        em.close();
        return listar;    
    }
}
  

