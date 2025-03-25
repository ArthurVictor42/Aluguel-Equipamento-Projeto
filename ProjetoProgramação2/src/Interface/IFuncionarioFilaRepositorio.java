package Interface;
import Entidades.Funcionario;

public interface IFuncionarioFilaRepositorio {
    void enqueue(Funcionario funcionario);

    Funcionario dequeue();

    boolean empty();

    int size();

    Funcionario front();
}
