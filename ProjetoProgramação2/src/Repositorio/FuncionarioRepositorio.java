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
    public boolean alterarFuncionario(Funcionario funcionarioAtualizado) {
        ArrayList<Funcionario> lista = filafuncionario.lista();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == funcionarioAtualizado.getId()) {
                lista.set(i, funcionarioAtualizado); // Substitui o antigo pelo novo
                return true;
            }
        }
        return false;
    }

    // Remove um funcionário pelo ID
    public boolean removePorId(int id) {
        ArrayList<Funcionario> lista = filafuncionario.lista();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                return true; // Removido com sucesso
            }
        }
        return false; // Não encontrado
    }
}
