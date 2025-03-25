package Repositorio;
import java.util.ArrayList;
import Entidades.Aluguel;
import Interface.IAluguelRepositorio;

public class AluguelRepositorio implements IAluguelRepositorio {
    private ArrayList<Aluguel> listaAluguel;
    
    public AluguelRepositorio(ArrayList<Aluguel> alugueis){
        this.listaAluguel = alugueis;
    }

    public void salvar(Aluguel aluguel){
        this.listaAluguel.add(aluguel);
    }

    public boolean remover(Aluguel aluguel){
        return listaAluguel.remove(aluguel);
    }

    public ArrayList<Aluguel> listarAluguel(){
        return listaAluguel;
    }

    public void alteraAluguel(Aluguel aluguel){
        for(Aluguel aluguels: listaAluguel){
            if(aluguels.equals(aluguel)){
                aluguels.setCustoAluguel(aluguel.getCustoAluguel());
                break;
            }
        }
    }
}
