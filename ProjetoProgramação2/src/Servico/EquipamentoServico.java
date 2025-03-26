package Servico;

import Entidades.Equipamento;
import Repositorio.EquipamentoRepositorio;
import Interface.IEquipamentoRepositorio;

public class EquipamentoServico {
    private IEquipamentoRepositorio equipamentoRepositorio;

    public EquipamentoServico(EquipamentoRepositorio equipamentoRepositorio){
        this.equipamentoRepositorio = equipamentoRepositorio;
    }

    public void adicionar(Equipamento equipamento){
        equipamentoRepositorio.salvar(equipamento);
    }

    public void excluir(Equipamento equipamento){
        equipamentoRepositorio.remover(equipamento);
    }

    public void listar(){
        equipamentoRepositorio.listarEquipamento().forEach(System.out::println);
    }

    public void alteraNome(Equipamento equipamento){
        equipamentoRepositorio.alteraNome(equipamento);
    }
}
