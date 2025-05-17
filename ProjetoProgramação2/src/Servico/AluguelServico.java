package Servico;

import java.util.List;
import Entidades.Aluguel;
import Repositorio.AluguelRepositorioJDBC;
import Interface.IAluguelRepositorio;

public class AluguelServico {
    private IAluguelRepositorio aluguelRepositorio;

    public AluguelServico(AluguelRepositorioJDBC aluguelRepositorio) {
        this.aluguelRepositorio = aluguelRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void salvar(Aluguel aluguel) {
        if (aluguel.getCustoAluguel() <= 0) {
            System.out.println("Custo do aluguel deve ser maior que zero");
        } else {
            aluguelRepositorio.salvar(aluguel);
        }
    }

    // Metodo pra chama o remover do repositorio
    public boolean excluir(int id) {
        return aluguelRepositorio.remover(id);
    }

    // Metodo pra chama o listar do repositorio
    public List<Aluguel> listar() {
        return aluguelRepositorio.listar();
    }

    // Metodo pra chama o altera do repositorio
    public boolean alteraAluguel(Aluguel aluguel) {
        if (aluguel.getCustoAluguel() <= 0) {
            System.out.println("Custo do aluguel deve ser maior que zero");
            return false;
        } else {
            return aluguelRepositorio.alterar(aluguel);
        }
    }

    public boolean buscarNumero(int id) {
        return aluguelRepositorio.buscarNumero(id);
    }
}
