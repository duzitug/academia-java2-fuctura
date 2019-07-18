/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.locadoraveiculos.dao.jdbc;

import br.com.merciof.locadoraveiculos.dao.interfaces.VeiculoDAO;
import br.com.merciof.locadoraveiculos.entidades.Veiculo;
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
public class VeiculoDAOImpl implements VeiculoDAO {
    
    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    @Override
    public void inserir(Veiculo veiculo) {
        
        String sql = "INSERT INTO VEICULO (PLACA, MARCA) VALUES(?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.execute();
            System.out.println("Veiculo inserido com sucesso");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  finally {
            conexao.closeConnection(connection);
        } 
    }

    @Override
    public Veiculo selecionar() {
         String sql = "SELECT * FROM VEICULO WHERE PLACA = ?";
        
         Veiculo veiculo = new Veiculo();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ResultSet rs = ps.executeQuery();
            rs.next();
            veiculo.setPlaca(rs.getString("PLACA"));
            veiculo.setMarca(rs.getString("MARCA"));
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar selecionar veiculo: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
        
        return veiculo;
    }

    @Override
    public void remover(Veiculo veiculo) {
        
        String sql = "DELETE FROM VEICULO WHERE PLACA = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, veiculo.getPlaca());
            ps.execute();
            System.out.println("Veiculo deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar deletar Veiculo: " + e.getMessage());
            
        } finally {
            conexao.closeConnection(connection);
        }
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        
        String sql = "UPDATE VEICULO SET  MARCA = ? WHERE PLACA = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getPlaca());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar atualizar veiculo: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }  
    }

    @Override
    public List<Veiculo> listarVeiculo() {
        
        String sql = "SELECT * FROM VEICULO";
        
        List<Veiculo> retorno = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setMarca(rs.getString("MARCA"));
                veiculo.setPlaca(rs.getString("PLACA"));
                retorno.add(veiculo);    
            } 
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar pesquisar veiculo: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
        
        return retorno;
    }
      
}
