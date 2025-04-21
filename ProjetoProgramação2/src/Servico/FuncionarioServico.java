package Servico;

import Entidades.Funcionario;
import Interface.IFuncionarioFilaRepositorio;
import Repositorio.FuncionarioRepositorio;
import java.util.ArrayList;

public class FuncionarioServico {
    private IFuncionarioFilaRepositorio filaRepositorio;

    public FuncionarioServico(FuncionarioRepositorio funcionarioRepositorio){
        this.filaRepositorio = funcionarioRepositorio;
    }

    // Chama o metodo de adicionar o elemento da fila
    public void enqueue(Funcionario funcionario){
        filaRepositorio.enqueue(funcionario);
    }

    // Chama o metodo de remove o elemento da fila
    public Funcionario dequeue(){
        return filaRepositorio.dequeue();
    }

    // Chama o metodo pra verifica se a fila está vazia
    public boolean empty(){
        return filaRepositorio.empty();
    }

    // Chama o metodo de verifica o tamanho da fila
    public int size(){
        return filaRepositorio.size();
    }

    // Chama o metodo de ver o primeiro elemento da fila
    public Funcionario front(){
        return filaRepositorio.front();
    }

    // Chama o metodo de listar os elementos da fila
    public ArrayList<Funcionario> lista(){
        return filaRepositorio.lista();
    }

    // Metodo pra altera a informação do objeto salvo na fila
    public boolean alterarFuncionario(Funcionario funcionario){
        return filaRepositorio.alterarFuncionario(funcionario);
    }

    public boolean buscarID(int id){
        return filaRepositorio.removePorId(id);
    }
}
