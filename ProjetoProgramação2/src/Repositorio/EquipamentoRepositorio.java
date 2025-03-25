package Repositorio;

import java.util.ArrayList;
import Entidades.Equipamento;
import Interface.IEquipamentoRepositorio;

public class EquipamentoRepositorio implements IEquipamentoRepositorio {
    private ArrayList<Equipamento> listaEquipamento;
    
    public EquipamentoRepositorio(ArrayList<Equipamento> equipamentos){
        this.listaEquipamento = equipamentos;
    }

    public void salvar(Equipamento equipamento){
        this.listaEquipamento.add(equipamento);
    }

    public boolean remover(Equipamento equipamento){
        return listaEquipamento.remove(equipamento);
    }

    public ArrayList<Equipamento> listarEquipamento(){
        return listaEquipamento;
    }

    public void alteraNome(Equipamento equipamento){
        for(Equipamento equipamentos: listaEquipamento){
            if(equipamentos.getNomeEquipamento().equals(equipamento.getNomeEquipamento())){
                equipamentos.setNomeEquipamento(equipamento.getNomeEquipamento());
                break;
            }
        }
    }
}