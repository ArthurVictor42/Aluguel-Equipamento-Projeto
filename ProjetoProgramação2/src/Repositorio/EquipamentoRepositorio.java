package Repositorio;

import java.util.ArrayList;
import Entidades.Equipamento;
import Interface.IEquipamentoRepositorio;

public class EquipamentoRepositorio implements IEquipamentoRepositorio {
    private ArrayList<Equipamento> listaEquipamento;
    
    public EquipamentoRepositorio(ArrayList<Equipamento> equipamentos){
        this.listaEquipamento = equipamentos;
    }

    // Metodo pra salvar a informação do ArrayList
    public void salvar(Equipamento equipamento){
        this.listaEquipamento.add(equipamento);
    }

    // Metodo pra "Remove" a informação do ArrayList
    public boolean remover(Equipamento equipamento){
        return listaEquipamento.remove(equipamento);
    }

    // Metodo pra listar todas as informações do ArrayList
    public ArrayList<Equipamento> listarEquipamento(){
        return listaEquipamento;
    }

    // Metodo pra Altera a informação do objeto do ArrayList
    public void alteraNome(Equipamento equipamento){
        for(Equipamento equipamentos: listaEquipamento){
            if(equipamentos.getNomeEquipamento().equals(equipamento.getNomeEquipamento())){
                equipamentos.setNomeEquipamento(equipamento.getNomeEquipamento());
                break;
            }
        }
    }
}