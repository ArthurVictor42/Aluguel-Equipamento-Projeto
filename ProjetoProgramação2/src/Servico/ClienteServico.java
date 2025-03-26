package Servico;

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
    public void excluir(Cliente cliente){
        clienteRepositorio.remover(cliente);
    }

    // Metodo pra chama o listar do repositorio
    public void listar(){
        clienteRepositorio.listarCliente().forEach(System.out::println);
    }

    // Metodo pra chama o altera do repositorio
    public void alteraCliente(Cliente cliente){
        clienteRepositorio.alteraNome(cliente);
    }

    // Metodo pra aumenta a idade do cliente
    public void fazerAniversario(Cliente cliente){
        cliente.setIdade(cliente.getIdade() + 1);
            System.out.println("O(A)" + cliente.getNomeCompleto() + "esta fazendo aniversário! Agora tem " + cliente.getIdade() + " anos!");
    }
}
