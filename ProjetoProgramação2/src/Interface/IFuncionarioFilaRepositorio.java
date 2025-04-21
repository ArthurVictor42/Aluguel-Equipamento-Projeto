package Interface;

import java.util.ArrayList;
import Entidades.Funcionario;

public interface IFuncionarioFilaRepositorio {
    // Interface do repositorio do Funcionario
    void enqueue(Funcionario funcionario);

    Funcionario dequeue();

    boolean empty();

    int size();

    Funcionario front();

    ArrayList<Funcionario> lista();

    boolean alterarFuncionario(Funcionario funcionario);

    boolean removePorId(int id);
}
