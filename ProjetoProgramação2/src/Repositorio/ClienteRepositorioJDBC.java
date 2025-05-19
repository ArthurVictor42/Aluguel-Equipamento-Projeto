package Repositorio;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Entidades.Cliente;
import Conexao.ConexaoBanco;
import Interface.IClienteRepositorio;

public class ClienteRepositorioJDBC implements IClienteRepositorio {

    // Metodo pra salvar a informação do cliente Banco de dados
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (id_cliente, nome_completo, dt_nascimento, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNomeCompleto());
            java.sql.Date sqlDate = new java.sql.Date(cliente.getDatanascimento().getTime());
            stmt.setDate(3, sqlDate);
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getEndereco());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    // Metodo pra "Remove" a informação do cliente no Bando de dados
    public boolean remover(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deleta: " + e.getMessage());
            return false;
        }
    }

    // Metodo pra lista todas as informações do cliente no Banco de dados
    public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_completo"),
                        rs.getDate("dt_nascimento"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"));
                lista.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    // Metodo pra Altera a informação do cliente no Banco de dados
    public boolean altera(Cliente cliente) {
        String sql = "UPDATE cliente SET nome_completo = ?, dt_nascimento = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id_cliente = ?";
        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCompleto());
            java.sql.Date sqlDate = new java.sql.Date(cliente.getDatanascimento().getTime());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getCelular());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getEndereco());
            stmt.setInt(7, cliente.getId());

            stmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Errro ao altera: " + e.getMessage());
        }

        return false;
    }

    public boolean buscarID(int numero) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
