package Servico;

import Entidades.Funcionario;
import Interface.IFuncionarioRepositorio;
import Repositorio.FuncionarioRepositorioJDBC;

import java.util.List;

public class FuncionarioServico {
    private IFuncionarioRepositorio repositorio;

    public FuncionarioServico(FuncionarioRepositorioJDBC funcionarioRepositorio) {
        this.repositorio = funcionarioRepositorio;
    }

    // Inserir no fim da lista
    public void adicionarFuncionario(Funcionario funcionario) {
        repositorio.inserirNoFim(funcionario);
    }

    // Remover funcionário por ID
    public boolean removerFuncionario(int id) {
       return repositorio.remover(id);
    }

    // Exibir todos os funcionários
    public List<Funcionario> exibirFuncionarios() {
        return repositorio.exibir();
    }

    // Alterar dados de um funcionário
    public boolean alterarFuncionario(Funcionario funcionario) {
        return repositorio.alterarFuncionario(funcionario);
    }

    // Remover por ID com retorno booleano
    public boolean BuscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }
}
