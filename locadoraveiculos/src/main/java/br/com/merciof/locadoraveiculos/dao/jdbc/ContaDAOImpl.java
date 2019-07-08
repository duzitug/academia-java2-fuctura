/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.jdbc;

import br.com.merciof.locadoraveiculos.dao.interfaces.ContaDAO;
import br.com.merciof.locadoraveiculos.entidades.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author merciof
 */
public class ContaDAOImpl implements ContaDAO{
    
    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();
    
    @Override
    public void inserir(Conta conta) {
        String sql = "INSERT INTO CONTA (NUMERO,SALDO,LIMITE) VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, conta.getNumero());
            ps.setDouble(2, conta.getSaldo());
            ps.setDouble(3, conta.getLimite()); 
            ps.execute();
            System.out.println("conta inserida com sucesso");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  finally {
            conexao.closeConnection(connection);
        } 
    }
    
    @Override
    public void remover(Conta conta) {
        
        String sql = "DELETE FROM CONTA WHERE NUMERO = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, conta.getNumero());
            ps.execute();
            System.out.println("Conta deletada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar deletar conta: " + e.getMessage());
            
        } finally {
            conexao.closeConnection(connection);
        }
    }
    
    @Override
    public void atualizar(Conta conta) {
        
//        UPDATE table_name
//        SET column1 = value1, column2 = value2, ...
//        WHERE condition;

        String sql = "UPDATE CONTA SET NUMERO = ?, SALDO = ?, LIMITE = ? WHERE NUMERO = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, conta.getNumero());
            ps.setDouble(2, conta.getSaldo());
            ps.setDouble(3, conta.getLimite());
            ps.setInt(4, conta.getNumero());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar atualizar conta: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }  
    }
    
    @Override
    public Conta selecionar(int numeroConta) {
        String sql = "SELECT * FROM CONTA WHERE NUMERO = ?";
        Conta conta = new Conta();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numeroConta);
            ResultSet rs = ps.executeQuery();
            rs.next();
            conta.setNumero(rs.getInt("NUMERO"));
            conta.setSaldo(rs.getDouble("SALDO"));
            conta.setLimite(rs.getDouble("LIMITE"));
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar selecionar conta: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
        
        return conta;
    }
    
    @Override
    public List<Conta> listarConta() {  
        String sql = "SELECT * FROM CONTA";
        List<Conta> retorno = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Conta conta = new Conta();
                conta.setNumero(rs.getInt("NUMERO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setLimite(rs.getDouble("LIMITE"));
                retorno.add(conta);    
            } 
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar pesquisar enderecos: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
        
        return retorno;
    }

}
