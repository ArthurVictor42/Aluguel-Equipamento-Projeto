package Servico;

import Entidades.Equipamento;
import Repositorio.EquipamentoRepositorio;
import Interface.IEquipamentoRepositorio;

public class EquipamentoServico {
    private IEquipamentoRepositorio equipamentoRepositorio;

    public EquipamentoServico(EquipamentoRepositorio equipamentoRepositorio){
        this.equipamentoRepositorio = equipamentoRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void adicionar(Equipamento equipamento){
        equipamentoRepositorio.salvar(equipamento);
    }

    // Metodo pra chama o remover do repositorio
    public void excluir(Equipamento equipamento){
        equipamentoRepositorio.remover(equipamento);
    }

    // Metodo pra chama o listar do repositorio
    public void listar(){
        equipamentoRepositorio.listarEquipamento().forEach(System.out::println);
    }

    // Metodo pra chama o altera do repositorio
    public void alteraNome(Equipamento equipamento){
        equipamentoRepositorio.alteraNome(equipamento);
    }
}
