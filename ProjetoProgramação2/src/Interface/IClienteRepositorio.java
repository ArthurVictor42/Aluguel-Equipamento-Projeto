package Interface;
import Entidades.Cliente;
import java.util.ArrayList;

public interface IClienteRepositorio {
    void salvar(Cliente cliente);

    boolean remover(Cliente cliente);

    ArrayList<Cliente> listarCliente();

    void alteraNome(Cliente cliente);
    
}
