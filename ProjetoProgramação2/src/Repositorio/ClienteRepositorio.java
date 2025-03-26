package Repositorio;

import java.util.ArrayList;
import Entidades.Cliente;
import Interface.IClienteRepositorio;

public class ClienteRepositorio implements IClienteRepositorio {
    private ArrayList<Cliente> listaCliente;
    
    public ClienteRepositorio(ArrayList<Cliente> clientes){
        this.listaCliente = clientes;
    }
    
    // Metodo pra salvar a informação do ArrayList
    public void salvar(Cliente cliente){
        this.listaCliente.add(cliente);
    }

    // Metodo pra "Remove" a informação do ArrayList
    public boolean remover(Cliente cliente){
        return listaCliente.remove(cliente);
    }

    // Metodo pra lista todas as informações do ArrayList
    public ArrayList<Cliente> listarCliente(){
        return listaCliente;
    }

    // Metodo pra Altera a informação do objeto do ArrayList
    public void alteraNome(Cliente cliente){
        for(Cliente clientes: listaCliente){
            if(clientes.getNomeCompleto().equals(cliente.getNomeCompleto())){
                clientes.setNomeCompleto(cliente.getNomeCompleto());
                break;
            }
        }
    }
}

