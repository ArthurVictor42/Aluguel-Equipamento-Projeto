package Repositorio;

import Entidades.Funcionario;
import Entidades.FuncionarioFilaArrayList;
import Interface.IFuncionarioFilaRepositorio;
import java.util.ArrayList;


public class FuncionarioRepositorio implements IFuncionarioFilaRepositorio {
    private FuncionarioFilaArrayList filafuncionario;

    public FuncionarioRepositorio(){
        this.filafuncionario = new FuncionarioFilaArrayList();
    }
    
    // Adiciona a informação na Fila
    public void enqueue(Funcionario funcionario){
        filafuncionario.enqueue(funcionario);
    }

    // "Remove" a informação da Fila
    public Funcionario dequeue(){
        return filafuncionario.dequeue();
    }

    // Verificar se a fila está vazia
    public boolean empty(){
        return filafuncionario.empty();
    }

    // Ver o tamanho da fila
    public int size(){
        return filafuncionario.size();
    }

    // Ver o primeiro elemento da fila
    public Funcionario front(){
        return filafuncionario.front();
    }

    // Lista os elementos da fila
    public ArrayList<Funcionario> lista(){
        return filafuncionario.lista();
    }

    // Altera informação do objeto da fila
    public void alteraCargo(Funcionario funcionario){
        for(Funcionario fun: filafuncionario.lista()){
            if(fun.getCargo().equals(funcionario.getCargo())){
                fun.setCargo(funcionario.getCargo());
                break;
            }
        }
    }
}
