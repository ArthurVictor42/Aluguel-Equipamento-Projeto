package Repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entidades.Equipamento;
import Conexao.ConexaoBanco;
import Interface.IEquipamentoRepositorio;

public class EquipamentoRepositorioJDBC implements IEquipamentoRepositorio {

    public void salvar(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (id_equipamento, nome_equipamento, tipo_equipamento) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, equipamento.getId());
            stmt.setString(2, equipamento.getNomeEquipamento());
            stmt.setString(3, equipamento.getTipoEquipamento());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao inserir equipamento: " + e.getMessage());
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM equipamento WHERE id_equipamento = ?";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao remover equipamento: " + e.getMessage());

            return false;
        }
    }

    public List<Equipamento> listar() {
        List<Equipamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipamento";

        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Equipamento equipamento = new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("nome_equipamento"),
                        rs.getString("tipo_equipamento"));
                lista.add(equipamento);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar equipamentos: " + e.getMessage());
        }

        return lista;
    }

    public boolean alterar(Equipamento equipamento) {
        String sql = "UPDATE equipamento SET nome_equipamento = ?, tipo_equipamento = ? WHERE id_equipamento = ?";

        try (Connection conn = ConexaoBanco.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipoEquipamento());
            stmt.setInt(3, equipamento.getId());

            stmt.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar equipamento: " + e.getMessage());
        }

        return false;
    }

    public boolean buscarID(int id) {
        String sql = "SELECT * FROM equipamento WHERE id_equipamento = ?";
        try (Connection conn = ConexaoBanco.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // true se encontrar, false se não
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
