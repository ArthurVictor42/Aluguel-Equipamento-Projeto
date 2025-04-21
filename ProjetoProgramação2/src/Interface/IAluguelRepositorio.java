package Interface;

import Entidades.Aluguel;
import java.util.List;
import java.util.ArrayList;

public interface IAluguelRepositorio {
    // Interface do repositorio do Aluguel
    void salvar(Aluguel aluguel);

    void remover(int id);

    List<Aluguel> listar();

    void alterar(Aluguel aluguel);

    Aluguel buscarNumero(int id);
}
