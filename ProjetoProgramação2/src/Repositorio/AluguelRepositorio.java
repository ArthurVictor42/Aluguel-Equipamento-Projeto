package Repositorio;
import java.util.ArrayList;
import Entidades.Aluguel;
import Interface.IAluguelRepositorio;

public class AluguelRepositorio implements IAluguelRepositorio {
    private ArrayList<Aluguel> listaAluguel;
    
    public AluguelRepositorio(ArrayList<Aluguel> alugueis){
        this.listaAluguel = alugueis;
    }

    // Metodo pra salvar a informação do ArrayList
    public void salvar(Aluguel aluguel){
        this.listaAluguel.add(aluguel);
    }

    // Metodo pra "Remove" a informação do ArrayList
    public boolean remover(Aluguel aluguel){
        return listaAluguel.remove(aluguel);
    }

    // Metodo pra listar todas as informações do ArrayList
    public ArrayList<Aluguel> listarAluguel(){
        return listaAluguel;
    }

    // Metodo pra Altera a informação do objeto do ArrayList
    public void alteraAluguel(Aluguel aluguel){
        for(Aluguel aluguels: listaAluguel){
            if(aluguels.equals(aluguel)){
                aluguels.setCustoAluguel(aluguel.getCustoAluguel());
                break;
            }
        }
    }
}
