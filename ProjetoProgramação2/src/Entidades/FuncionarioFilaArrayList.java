package Entidades;

import java.util.ArrayList;

public class FuncionarioFilaArrayList {
    private ArrayList<Funcionario> fila;

    public FuncionarioFilaArrayList(){
        this.fila = new ArrayList<>();
    }

    public void enqueue(Funcionario funcionario){
        fila.add(funcionario);
    }

    public Funcionario dequeue(){
        if(empty()){
            System.out.println("A fila está vazia");
            return null;
        }

        return fila.remove(0);
    }

    public boolean empty(){
        return fila.isEmpty();
    }

    public int size(){
        return fila.size();
    }

    public Funcionario front(){
        if(empty()){
            System.out.println("A fila está vazia");
            return null;
        }

        return fila.get(0);
    }

    public ArrayList<Funcionario> lista(){
        return fila;
    }

}