package Interface;
import Entidades.Cliente;
import java.util.ArrayList;

public interface IClienteRepositorio {
    // Interface do repositorio do Cliente
    void salvar(Cliente cliente);

    boolean remover(Cliente cliente);

    ArrayList<Cliente> listarCliente();

    void alteraNome(Cliente cliente);
    
}
