package Servico;

import java.util.List;
import Entidades.Cliente;
import Repositorio.ClienteRepositorioJDBC;
import Interface.IClienteRepositorio;

public class ClienteServico {
    private IClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorioJDBC clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void cadastra(Cliente cliente) {
        if (cliente.getCpf().length() != 11) {
            System.out.println("CPF Inválido");
        } else {
            clienteRepositorio.salvar(cliente);
        }
    }

    // Metodo pra chama o remover do repositorio
    public boolean excluir(int id) {
        return clienteRepositorio.remover(id);
    }

    // Metodo pra chama o listar do repositorio
    public List<Cliente> listar() {
        if (clienteRepositorio.listarCliente().isEmpty()) {
            System.out.println("Está vazio");
        }

        return clienteRepositorio.listarCliente();
    }

    // Metodo pra chama o altera do repositorio
    public boolean alteraCliente(Cliente cliente) {
        if (cliente.getCpf().length() != 11) {
            System.out.println("Impossivel altera o cliente");
            return false;
        }

        return clienteRepositorio.altera(cliente);
    }

    public boolean buscarID(int id) {
        return clienteRepositorio.buscarID(id);
    }
}
