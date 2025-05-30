package Interface;

import Entidades.Aluguel;
import java.util.List;

public interface IAluguelRepositorio {
    // Interface do repositorio do Aluguel
    void salvar(Aluguel aluguel);

    boolean remover(int id);

    List<Aluguel> listar();

    boolean alterar(Aluguel aluguel);

    boolean buscarNumero(int id);
}
