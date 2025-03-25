package Servico;

import Entidades.Aluguel;
import Repositorio.AluguelRepositorio;
import Interface.IAluguelRepositorio;

public class AluguelServico{
    private IAluguelRepositorio aluguelRepositorio;
    
    public AluguelServico(AluguelRepositorio aluguelRepositorio){
        this.aluguelRepositorio = aluguelRepositorio;
    }
    
    public void cadastra(Aluguel aluguel){
        aluguelRepositorio.salvar(aluguel);
    }
    
    public void excluir(Aluguel aluguel){
        aluguelRepositorio.remover(aluguel);
    }
    
    public void listar(){
        aluguelRepositorio.listarAluguel().forEach(System.out::println);
    }

    public void alteraAluguel(Aluguel aluguel){
        aluguelRepositorio.alteraAluguel(aluguel);
    }

    public void calcularManutencao(Aluguel Aluguel){
        double calculo = 0;
        calculo = (Aluguel.getCustoAluguel() * 50) / 100;
        Aluguel.setCustoManutençao(calculo);
    } 


}
