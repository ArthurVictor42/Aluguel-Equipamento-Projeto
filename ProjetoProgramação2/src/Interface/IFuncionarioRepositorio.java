package Interface;

import java.util.List;
import Entidades.Funcionario;

public interface IFuncionarioRepositorio {
    // Interface do repositorio do Funcionario
    void inserirNoFim(Funcionario funcionario);

    boolean remover(int id);

    List<Funcionario> exibir();

    boolean alterarFuncionario(Funcionario funcionarioAtualizado);

    boolean buscarPorId(int id);
}
