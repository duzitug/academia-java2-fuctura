/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.mavenproject.DAO;

import br.com.merciof.mavenproject.Aluno;
import br.com.merciof.mavenproject.util.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JAVA
 */
public class AlunoDAO implements CRUD<Aluno> {
 
    private EntityManager entityManager = null;
    
    public AlunoDAO() throws Exception {
        entityManager = Connection.getEntityManager();
    }

    @Override
    public void salvar(Aluno entidade) {
        entityManager.getTransaction().begin();
        entityManager.merge(entidade);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletar(Aluno aluno) {
        entityManager.getTransaction().begin();
        entityManager.remove(aluno);
        entityManager.getTransaction().commit();
    }

    @Override
    public Aluno getById(int id) {
        Aluno aluno = null;
        entityManager.getTransaction().begin();
        aluno = entityManager.find(Aluno.class, id);
        entityManager.getTransaction().commit();
        
        return aluno;
    }

    @Override
    public List<Aluno> listAll() {
        
        List<Aluno> alunos = null;
        
        Query query = entityManager.createQuery("SELECT aluno FROM Aluno aluno");
        //Query query = entityManager.createNativeQuery("SELECY * FROM aluno");
        alunos = query.getResultList();
        entityManager.getTransaction().commit();
        
        return alunos;
    }
    
    
    
    
}
