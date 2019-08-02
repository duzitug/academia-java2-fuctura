/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.jdbc;

import br.com.merciof.java2.aula2.interfacesDAO.CRUD;
import br.com.merciof.java2.aula2.model.ContaPoupanca;
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
public class PoupancaDAOImpl implements CRUD<ContaPoupanca> {

    private Connection conn;
    private Conexao conexao;
    
    public PoupancaDAOImpl() {
        conn = conexao.getConnection();
    }
    
    @Override
    public void create(ContaPoupanca e) throws Exception {
        
        String sql = "INSERT INTO CONTA(AGENCIA, NUMERO, FK_ID_CLIENTE, SALDO) VALUES(?, ?, ?, ?)";
        PreparedStatement pt = this.conn.prepareStatement(sql);
        pt.setInt(1, e.getAgencia());
        pt.setInt(2, e.getNumero());
        pt.setInt(3, e.getFK_ID_CLIENTE());
        pt.setDouble(4, e.getSaldo());
        pt.execute();
  
    }

    @Override
    public List<ContaPoupanca> listarTodos() throws Exception {
        
        List<ContaPoupanca> listaConta = new ArrayList<>();
        
        String sql = "SELECT * FROM CONTA";
        
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(sql);
        
        while (result.next()) {            
            ContaPoupanca conta = new ContaPoupanca(result.getInt("NUMERO"), result.getInt("AGENCIA"), result.getFloat("SALDO"), result.getInt("FK_ID_CLIENTE"));
        
            conta.setIdConta(result.getInt("ID_CONTA"));
            
            listaConta.add(conta);
        }
        
        return listaConta;
       
    }

    @Override
    public ContaPoupanca listarPorId(int id) throws Exception {
        
        ContaPoupanca  poupanca = null;
        
        String sql = "SELECT * FROM CONTA WHERE ID_CONTA =" + id;
        
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(sql);
        
        result.next();
        
        ContaPoupanca conta = new ContaPoupanca(result.getInt("NUMERO"), result.getInt("AGENCIA"), result.getFloat("SALDO"), result.getInt("FK_ID_CLIENTE"));
        
        conta.setIdConta(result.getInt("ID_CONTA"));
        
        return poupanca;
    }

    @Override
    public void atualizar(ContaPoupanca e) throws Exception {
        
//        UPDATE Customers
//        SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//        WHERE CustomerID = 1;
        
        String sql = "UPDATE POUPANCA SET NUMERO = ?, AGENCIA = ?, SALDO = ? WHERE ID_CONTA = ?";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        
        pst.setInt(1, e.getNumero());
        pst.setInt(2, e.getAgencia());
        pst.setFloat(3, e.getSaldo());
        
        pst.execute();
        
    }

    @Override
    public void remover(int id) throws Exception {
        
        String sql = "DELETE FROM CONTA WHERE ID_CONTA =" + id;
        
        Statement st = conn.createStatement();
        
        st.executeQuery(sql);
        
        
        
    }
    
}
