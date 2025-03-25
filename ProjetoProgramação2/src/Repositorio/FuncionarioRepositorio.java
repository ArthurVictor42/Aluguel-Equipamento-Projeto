package Repositorio;

import Entidades.Funcionario;
import Entidades.FuncionarioFilaArrayList;
import Interface.IFuncionarioFilaRepositorio;


public class FuncionarioRepositorio implements IFuncionarioFilaRepositorio {
    private FuncionarioFilaArrayList filafuncionario;

    public FuncionarioRepositorio(){
        this.filafuncionario = new FuncionarioFilaArrayList();
    }

    public void enqueue(Funcionario funcionario){
        filafuncionario.enqueue(funcionario);
    }

    public Funcionario dequeue(){
        return filafuncionario.dequeue();
    }

    public boolean empty(){
        return filafuncionario.empty();
    }

    public int size(){
        return filafuncionario.size();
    }

    public Funcionario front(){
        return filafuncionario.front();
    }


}
