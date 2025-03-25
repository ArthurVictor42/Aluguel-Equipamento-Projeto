package Interface;

import Entidades.Aluguel;
import java.util.ArrayList;

public interface IAluguelRepositorio {
    void salvar(Aluguel aluguel);

    boolean remover(Aluguel aluguel);

    ArrayList<Aluguel> listarAluguel();

    void alteraAluguel(Aluguel aluguel);
}
