package Servico;

import java.util.ArrayList;
import java.util.List;
import Entidades.Aluguel;
import Repositorio.AluguelRepositorioJDBC;
import Interface.IAluguelRepositorio;

public class AluguelServico{
    private IAluguelRepositorio aluguelRepositorio;
    
    public AluguelServico(AluguelRepositorioJDBC aluguelRepositorio){
        this.aluguelRepositorio = aluguelRepositorio;
    }
    
    // Metodo pra chama o salvar do repositorio
    public void salvar(Aluguel aluguel){
        aluguelRepositorio.salvar(aluguel);
    }
    
    // Metodo pra chama o remover do repositorio
    public void excluir(int id){
        aluguelRepositorio.remover(id);
    }
    
    // Metodo pra chama o listar do repositorio
    public List<Aluguel> listar(){
        return aluguelRepositorio.listar();
    }

    // Metodo pra chama o altera do repositorio
    public void alteraAluguel(Aluguel aluguel){
        aluguelRepositorio.alterar(aluguel);
    }

    public Aluguel buscarNumero(int id){
        return aluguelRepositorio.buscarNumero(id);
    }
}
