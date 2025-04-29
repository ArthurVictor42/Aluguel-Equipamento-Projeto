package Servico;

import java.util.ArrayList;
import java.util.List;
import Entidades.Cliente;
import Repositorio.ClienteRepositorioJDBC;
import Interface.IClienteRepositorio;

public class ClienteServico {
    private IClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorioJDBC clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    // Metodo pra chama o salvar do repositorio
    public void cadastra(Cliente cliente){
        if (cliente.getCpf().length() != 11) {
            System.out.println("CPF Inválido");
        } else {
            clienteRepositorio.salvar(cliente);
        }
    }

    // Metodo pra chama o remover do repositorio
    public void excluir(int id){
        clienteRepositorio.remover(id);
    }

    // Metodo pra chama o listar do repositorio
    public List<Cliente> listar(){
        if(clienteRepositorio.listarCliente().isEmpty()){
            System.out.println("Está vazio");
        }
        
        return clienteRepositorio.listarCliente();
    }

    // Metodo pra chama o altera do repositorio
    public void alteraCliente(Cliente cliente){
        if(cliente.getCpf().length() != 11){
            System.out.println("Impossivel altera o cliente");
        }
        
        clienteRepositorio.altera(cliente);
    }

    public Cliente buscarID(int id){
        return clienteRepositorio.buscarID(id);
    }
}
