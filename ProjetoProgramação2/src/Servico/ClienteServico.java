package Servico;

import Entidades.Cliente;
import Repositorio.ClienteRepositorio;
import Interface.IClienteRepositorio;

public class ClienteServico {
    private IClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    public void cadastra(Cliente cliente){
        clienteRepositorio.salvar(cliente);
    }

    public void excluir(Cliente cliente){
        clienteRepositorio.remover(cliente);
    }

    public void listar(){
        clienteRepositorio.listarCliente().forEach(System.out::println);
    }

    public void alteraCliente(Cliente cliente){
        clienteRepositorio.alteraNome(cliente);
    }

    public void fazerAniversario(Cliente cliente){
        cliente.setIdade(cliente.getIdade() + 1);
            System.out.println("O(A)" + cliente.getNomeCompleto() + "esta fazendo aniversário! Agora tem " + cliente.getIdade() + " anos!");
    }
}
