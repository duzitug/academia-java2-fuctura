/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.jdbc;

import br.com.merciof.java2.aula2.interfacesDAO.CRUD;
import br.com.merciof.java2.aula2.model.Conta;
import br.com.merciof.java2.aula2.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class ContaDAOImpl implements CRUD<Conta> {
    
    private Connection conn;
    private Conexao conexao;

    public ContaDAOImpl() {
        conn = conexao.getConnection();
    }

    @Override
    public void create(Conta e) throws Exception {
        
        String sql = "INSERT INTO CONTA VALUES(?, ?, ?, ?)";
        
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setInt(0, 0);
        
        ps.execute();
    }

    @Override
    public List<Conta> listarTodos() throws Exception {
        
        //List<ContaPoupanca> listaConta = new ArrayList<>();
        
        List<Conta> listaConta = new ArrayList<>();
        
        String sql = "SELECT * FROM CONTA";
        
//          Statement st = conn.createStatement();
//        ResultSet result = st.executeQuery(sql);

        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {            
            
            Conta conta = new Conta();
            
            listaConta.add(conta);
            
        }
    
        return listaConta;
    }

    @Override
    public Conta listarPorId(int id) throws Exception {
        
        Conta conta = new Conta();
        
        String sql = "SELECT * FROM CONTA WHERE ID_CONTA = ?";
        
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();    
        
        conta.setAgencia(rs.getInt("AGENCIA"));
        conta.setNumero(rs.getInt("NUMERO"));
        conta.setSaldo(rs.getFloat("SALDO"));
        
        return conta;
          
    }

    @Override
    public void atualizar(Conta e) throws Exception {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) throws Exception {
        
        String sql = "DELETE FROM CONTA WHERE ID_CONTA = ?";
        
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        
        ps.execute();
        
    }
   
}
