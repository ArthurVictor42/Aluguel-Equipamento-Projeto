package Servico;

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
    public void excluir(Aluguel aluguel){
        aluguelRepositorio.remover(aluguel);
    }
    
    // Metodo pra chama o listar do repositorio
    public void listar(){
        aluguelRepositorio.listarAluguel().forEach(System.out::println);
    }

    // Metodo pra chama o altera do repositorio
    public void alteraAluguel(Aluguel aluguel){
        aluguelRepositorio.alteraAluguel(aluguel);
    }

    // Metodo pra calcular o custo de manutenção do equipamento
    public void calcularManutencao(Aluguel Aluguel){
        double calculo = 0;
        calculo = (Aluguel.getCustoAluguel() * 50) / 100;
        Aluguel.setCustoManutençao(calculo);
    } 


}
