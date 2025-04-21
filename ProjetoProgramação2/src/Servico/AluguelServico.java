package Servico;

import java.util.ArrayList;
import java.util.List;
import Entidades.Aluguel;
import Repositorio.AluguelRepositorio;
import Interface.IAluguelRepositorio;

public class AluguelServico{
    private IAluguelRepositorio aluguelRepositorio;
    
    public AluguelServico(AluguelRepositorio aluguelRepositorio){
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

    // Metodo pra calcular o custo de manutenção do equipamento
    public void calcularManutencao(Aluguel Aluguel){
        double calculo = 0;
        calculo = (Aluguel.getCustoAluguel() * 50) / 100;
        Aluguel.setCustoManutençao(calculo);
    } 


}
