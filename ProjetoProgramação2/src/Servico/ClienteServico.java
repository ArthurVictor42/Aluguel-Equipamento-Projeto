package Servico;

import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;
import Repositorio.ClienteRepositorio;
import Interface.IClienteRepositorio;

public class ClienteServico {
    private IClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void cadastra(Cliente cliente){
        clienteRepositorio.salvar(cliente);
    }

    // Metodo pra chama o remover do repositorio
    public void excluir(int id){
        clienteRepositorio.remover(id);
    }

    // Metodo pra chama o listar do repositorio
    public List<Cliente> listar(){
        return clienteRepositorio.listarCliente();
    }

    // Metodo pra chama o altera do repositorio
    public void alteraCliente(Cliente cliente){
        clienteRepositorio.altera(cliente);
    }
}
