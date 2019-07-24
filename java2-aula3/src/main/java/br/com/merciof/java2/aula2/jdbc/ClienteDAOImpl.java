/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.merciof.java2.aula2.jdbc;

import br.com.merciof.java2.aula2.model.Cliente;
import br.com.merciof.java2.aula2.interfacesDAO.ClienteDAO;
import br.com.merciof.java2.aula2.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAVA
 */
public class ClienteDAOImpl implements ClienteDAO {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, ENDERECO) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEndereco());

            ps.execute();
            System.out.println("Cliente inserido com sucesso");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
    }

    @Override
    public void remover(int idCliente) {
        String sql = "DELETE FROM CLIENTE WHERE NUMERO = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.execute();
            System.out.println("Cliente deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar deletar Cliente: " + e.getMessage());

        } finally {
            conexao.closeConnection(connection);
        }
    }

    @Override
    public Cliente selecionar(int idCliente) {
        String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = ?";
        Cliente cliente = new Cliente();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar selecionar cliente: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }

        return cliente;
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET CPF = ?, NOME = ?, ENDERECO = ? WHERE ID_CLIENTE = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar atualizar cliente: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> retorno = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setCpf(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setNome(rs.getString("NOME"));
                retorno.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar pesquisar enderecos: " + e.getMessage());
        } finally {
            conexao.closeConnection(connection);
        }

        return retorno;
    }

}
