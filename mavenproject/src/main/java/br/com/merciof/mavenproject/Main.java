/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.mavenproject;

import br.com.merciof.mavenproject.controller.AlunoController;

/**
 *
 * @author JAVA
 */
public class Main {
    public static void main(String[] args) {
        
        AlunoController alunoController = null;
        
        try {
            alunoController = new AlunoController();
        } catch (Exception e) {
            System.out.println("Erro ao tentar realizar conxao: " + e);
        }
        
    }
}

