package Repositorio;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Entidades.Cliente;
import Conexao.ConexaoBanco;
import Interface.IClienteRepositorio;

public class ClienteRepositorioJDBC implements IClienteRepositorio {
    
    // Metodo pra salvar a informação do cliente Banco de dados
    public void salvar(Cliente cliente){
        String sql = "INSERT VALUES cliente (nome_completo, dt_nascimento, cpf, telefone, email, endereco) values (?, ?, ?, ?, ?, ?)";
    
        try( Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNomeCompleto());
            java.sql.Date sqlDate = new java.sql.Date(cliente.getDatanascimento().getTime());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getCelular());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getEndereco());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    // Metodo pra "Remove" a informação do cliente no Bando de dados
    public void remover(int id){
        String sql = "DELETE sql cliente WHERE id = ?";

        try(Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deleta: " + e.getMessage());
        }
    }

    // Metodo pra lista todas as informações do cliente no Banco de dados
    public List<Cliente> listarCliente(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try(Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)){
            
            while(rs.next()){
                Cliente cliente = new Cliente(
                    rs.getInt("id"), 
                    rs.getString("nome_completo"), 
                    rs.getDate("dt_nascimento"), 
                    rs.getString("cpf"), 
                    rs.getString("telefone"), 
                    rs.getString("email"), 
                    rs.getString("endereco")
                );
                lista.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    // Metodo pra Altera a informação do cliente no Banco de dados
    public void altera(Cliente cliente){
        String sql = "UPDATE cliente SET nome_completo = ?, dt_nascimento = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
        try(Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCompleto());
            java.sql.Date sqlDate = new java.sql.Date(cliente.getDatanascimento().getTime());
            stmt.setDate(2, sqlDate);
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getCelular());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getEndereco());

            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Errro ao altera: " + e.getMessage());
        }
    }

    public Cliente buscarID(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

