package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.ConexaoBanco;
import Entidades.Funcionario;
import Entidades.ListaEncadeada;
import Entidades.No;
import Interface.IFuncionarioRepositorio;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorioJDBC implements IFuncionarioRepositorio {
    private ListaEncadeada<Funcionario> lista = new ListaEncadeada<>();

    // Inserir no fim
    @Override
    public void inserirNoFim(Funcionario funcionario) {
        lista.inserirFim(funcionario);

        String sql = "INSERT INTO funcionario (id_funcionario, nome_completo, dt_nascimento, cpf, telefone, email, cargo, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNomeCompleto());
            stmt.setDate(3, new java.sql.Date(funcionario.getDatanascimento().getTime()));
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getCelular());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getCargo());
            stmt.setDouble(8, funcionario.getSalario());
            stmt.executeUpdate();

            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remover pelo ID
    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";

        No<Funcionario> atual = lista.getInicio();
        while (atual != null) {
            if (atual.dado.getId() == id) {
                lista.remover(atual.dado);
                return true;
            }
            atual = atual.proximo;
        }
        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }

    // Exibir todos
    @Override
    public List<Funcionario> exibir() {
        List<Funcionario> resultado = new ArrayList<>();

        // Adiciona da lista encadeada
        for (Funcionario f : lista.exibir()) {
            resultado.add(f);
        }

        // Adiciona do banco de dados
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome_completo"),
                        rs.getDate("dt_nascimento"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"));
                resultado.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar banco: " + e.getMessage());
        }

        return resultado;
    }

    // Alterar dados do funcionário
    public boolean alterarFuncionario(Funcionario funcionarioAtualizado) {
        No<Funcionario> atual = lista.getInicio();
        String sql = "UPDATE funcionario SET nome_completo=?, dt_nascimento=?, cpf=?, telefone=?, email=?, cargo=?, salario=? WHERE id_funcionario=?";
        while (atual != null) {
            if (atual.dado.getId() == funcionarioAtualizado.getId()) {
                // Altere os dados diretamente
                atual.dado.setNomeCompleto(funcionarioAtualizado.getNomeCompleto());
                atual.dado.setEmail(funcionarioAtualizado.getEmail());
                atual.dado.setCargo(funcionarioAtualizado.getCargo());
                atual.dado.setSalario(funcionarioAtualizado.getSalario());
                atual.dado.setCelular(funcionarioAtualizado.getCelular());
                atual.dado.setDataNascimento(funcionarioAtualizado.getDatanascimento());
                atual.dado.setCpf(funcionarioAtualizado.getCpf());

                try (Connection conn = ConexaoBanco.conexao();
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, funcionarioAtualizado.getNomeCompleto());
                    stmt.setDate(2, new java.sql.Date(funcionarioAtualizado.getDatanascimento().getTime()));
                    stmt.setString(3, funcionarioAtualizado.getCpf());
                    stmt.setString(4, funcionarioAtualizado.getCelular());
                    stmt.setString(5, funcionarioAtualizado.getEmail());
                    stmt.setString(6, funcionarioAtualizado.getCargo());
                    stmt.setDouble(7, funcionarioAtualizado.getSalario());
                    stmt.setInt(8, funcionarioAtualizado.getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erro ao altera Funcionarios");
                }

                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    // Buscar por ID
    @Override
    public boolean buscarPorId(int id) {
        // Verifica na lista encadeada
        No<Funcionario> atual = lista.getInicio();
        while (atual != null) {
            if (atual.getDado().getId() == id) {
                return true;
            }
            atual = atual.getProximo();
        }

        // Verifica no banco
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se achou
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário no banco: " + e.getMessage());
        }

        return false;
    }
}