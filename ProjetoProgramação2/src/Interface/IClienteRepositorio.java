package Interface;

import Entidades.Cliente;
import java.util.List;
import java.util.ArrayList;

public interface IClienteRepositorio {
    // Interface do repositorio do Cliente
    void salvar(Cliente cliente);

    boolean remover(int id);

    List<Cliente> listarCliente();

    boolean altera(Cliente cliente);

    boolean buscarID(int id);

}
