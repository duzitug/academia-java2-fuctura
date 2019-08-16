/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.mavenproject.controller;

import br.com.merciof.mavenproject.Aluno;
import br.com.merciof.mavenproject.DAO.AlunoDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class AlunoController {
    
    private AlunoDAO alunoDAO = null;
    
    public AlunoController() throws Exception {
        this.alunoDAO = new AlunoDAO();
    }
     
    public void salvarAluno(String nome, String cpf, Date dataNascimento) {
        Aluno aluno = new Aluno(nome, cpf, dataNascimento);
        alunoDAO.salvar(aluno);
    }
    
    public void deletarAluno(int id) {
        Aluno aluno = alunoDAO.getById(id);
        alunoDAO.deletar(aluno);
    }
    
    public String getById(int id) {
        String result = null;
        Aluno aluno = alunoDAO.getById(id);
        
        result = aluno.getNome() + " " + aluno.getCpf() + " " + aluno.getDataNascimento();
       
        return result;
        
    }
    
    public void update(int id, String nome, String cpf, Date date) {
        Aluno aluno = new Aluno(nome, cpf, date);
        aluno.setId_aluno(id);
        alunoDAO.salvar(aluno);
    }
    
    public String listAllAlunos() {
        String result = " ";
        
        List<Aluno> alunos = alunoDAO.listAll();
        
        for(Aluno aluno : alunos) {
            result = aluno.getNome() + " " + aluno.getCpf() + " " + aluno.getDataNascimento();
        }
            
        return result;
    }
}
