package Servico;

import Entidades.Funcionario;
import Interface.IFuncionarioFilaRepositorio;
import Repositorio.FuncionarioRepositorio;

public class FuncionarioServico {
    private IFuncionarioFilaRepositorio filaRepositorio;

    public FuncionarioServico(FuncionarioRepositorio funcionarioRepositorio){
        this.filaRepositorio = funcionarioRepositorio;
    }

    public void enqueue(Funcionario funcionario){
        filaRepositorio.enqueue(funcionario);
    }

    public Funcionario dequeue(){
        return filaRepositorio.dequeue();
    }

    public boolean empty(){
        return filaRepositorio.empty();
    }

    public int size(){
        return filaRepositorio.size();
    }

    public Funcionario front(){
        return filaRepositorio.front();
    }

    public void lista(){
        filaRepositorio.lista().forEach(System.out::println);;
    }

    public void alteraCargo(Funcionario funcionario){
        filaRepositorio.alteraCargo(funcionario);
    }

    public void fazerAniversario(Funcionario funcionario){
        funcionario.setIdade(funcionario.getIdade() + 1);
            System.out.println("O(A) " + funcionario.getNomeCompleto() + "esta fazendo aniversário! Agora tem " + funcionario.getIdade() + " anos!");
    }
}
