package Entidades;

import java.util.ArrayList;

public class FuncionarioFilaArrayList {
    private ArrayList<Funcionario> fila;

    public FuncionarioFilaArrayList(){
        this.fila = new ArrayList<>();
    }

    // Adiciona na fila
    public void enqueue(Funcionario funcionario){
        fila.add(funcionario);
    }

    // Remove da fila
    public Funcionario dequeue(){
        if(empty()){
            System.out.println("A fila está vazia");
            return null;
        }

        return fila.remove(0);
    }

    // Verifica se está vazio
    public boolean empty(){
        return fila.isEmpty();
    }

    // Verifica o tamanho
    public int size(){
        return fila.size();
    }

    // Verifica o primeiro elemento da fila
    public Funcionario front(){
        if(empty()){
            System.out.println("A fila está vazia");
            return null;
        }

        return fila.get(0);
    }

    // Lista os elementos salvo na fila
    public ArrayList<Funcionario> lista(){
        return fila;
    }

}