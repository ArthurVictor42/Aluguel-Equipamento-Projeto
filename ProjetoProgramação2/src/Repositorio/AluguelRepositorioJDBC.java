package Repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entidades.Aluguel;
import Conexao.ConexaoBanco;
import Interface.IAluguelRepositorio;

public class AluguelRepositorioJDBC implements IAluguelRepositorio {

    public void salvar(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel (custo_aluguel, custo_manutencao) VALUES (?, ?)";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, aluguel.getCustoAluguel());
            stmt.setDouble(2, aluguel.getCustoManutencao());

            stmt.executeUpdate();
            System.out.println("Aluguel cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir aluguel: " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM aluguel WHERE numero_aluguel = ?";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Aluguel removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover aluguel: " + e.getMessage());
        }
    }

    public List<Aluguel> listar() {
        List<Aluguel> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluguel";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluguel aluguel = new Aluguel(
                    rs.getInt("numero_aluguel"),
                    rs.getDouble("custo_aluguel"),
                    rs.getDouble("custo_manutencao")
                );
                lista.add(aluguel);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar aluguéis: " + e.getMessage());
        }

        return lista;
    }

    public void alterar(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET custo_aluguel = ?, custo_manutencao = ? WHERE numero_aluguel = ?";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, aluguel.getCustoAluguel());
            stmt.setDouble(2, aluguel.getCustoManutencao());
            stmt.setInt(3, aluguel.getNumeroAluguel());

            stmt.executeUpdate();
            System.out.println("Aluguel atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluguel: " + e.getMessage());
        }
    }

    public Aluguel buscarNumero(int numero) {
        String sql = "SELECT * FROM aluguel WHERE numero = ?";
        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluguel(
                    rs.getInt("numero_aluguel"),
                    rs.getDouble("custo_aluguel"), 
                    rs.getDouble("custo_manutencao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
