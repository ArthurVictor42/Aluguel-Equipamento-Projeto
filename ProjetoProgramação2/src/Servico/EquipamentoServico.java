package Servico;

import java.util.ArrayList;
import java.util.List;
import Entidades.Equipamento;
import Repositorio.EquipamentoRepositorioJDBC;
import Interface.IEquipamentoRepositorio;

public class EquipamentoServico {
    private IEquipamentoRepositorio equipamentoRepositorio;

    public EquipamentoServico(EquipamentoRepositorioJDBC equipamentoRepositorio){
        this.equipamentoRepositorio = equipamentoRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void adicionar(Equipamento equipamento){
        if (equipamento.getTipoEquipamento() == null || equipamento.getTipoEquipamento().isEmpty()) {
            System.out.println("Tipo de equipamento não pode ser nulo ou vazio");
        } else {
            equipamentoRepositorio.salvar(equipamento);
        }
    }

    // Metodo pra chama o remover do repositorio
    public void excluir(int id){
        equipamentoRepositorio.remover(id);
    }

    // Metodo pra chama o listar do repositorio
    public List<Equipamento> listar(){
        return equipamentoRepositorio.listar();
    }

    // Metodo pra chama o altera do repositorio
    public void alteraEquipamento(Equipamento equipamento){
        if (equipamento.getTipoEquipamento() == null || equipamento.getTipoEquipamento().isEmpty()) {
            System.out.println("Tipo de equipamento não pode ser nulo ou vazio");
        } else {
            equipamentoRepositorio.alterar(equipamento);
        }
    }

    public Equipamento buscarID(int id){
        return equipamentoRepositorio.buscarID(id);
    }
}
