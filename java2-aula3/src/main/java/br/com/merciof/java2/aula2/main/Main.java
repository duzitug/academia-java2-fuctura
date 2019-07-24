/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.main;

import br.com.merciof.java2.aula2.controller.ControladorConta;
import br.com.merciof.java2.aula2.interfacesDAO.ClienteDAO;
import br.com.merciof.java2.aula2.jdbc.ClienteDAOImpl;

/**
 *
 * @author JAVA
 */
public class Main {
    
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        System.out.println(clienteDAO.listar());
        
         ControladorConta controladorConta = null;

        try {
            controladorConta = new ControladorConta();
            System.out.println("Conexao criada");
            
        } catch (Exception e) {
            System.out.println("erro na criação da conexao: " + e.getMessage());
        }
        
        try {
            controladorConta.solicitarSalvar(1, 1, 1000, 1);
            System.out.println("Conta inserida com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir Conta");
        }
        
        
        
    }
    
    
}
