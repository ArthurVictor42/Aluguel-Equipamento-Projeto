package view;

import java.util.ArrayList;

import Entidades.Cliente;
import Repositorio.ClienteRepositorio;
import Servico.ClienteServico;

import Entidades.Aluguel;
import Repositorio.AluguelRepositorio;
import Servico.AluguelServico;

import Entidades.Equipamento;
import Repositorio.EquipamentoRepositorio;
import Servico.EquipamentoServico;

import Entidades.Funcionario;
import Repositorio.FuncionarioRepositorio;
import Servico.FuncionarioServico;

public class Main {
    public static void main(String[] args) {
        ArrayList<Equipamento> equipamentos= new ArrayList<>();
        EquipamentoRepositorio equipamentoRepositorio = new EquipamentoRepositorio(equipamentos);
        EquipamentoServico equipamentoServico = new EquipamentoServico(equipamentoRepositorio);
        Equipamento equipamento = new Equipamento("Machado", "Manual");
        equipamentoServico.cadastra(equipamento);
        equipamentoServico.listar();

        System.out.println(" ");
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio(clientes);
        ClienteServico clienteServico = new ClienteServico(clienteRepositorio);
        Cliente cliente = new Cliente("Rua Centro ","Carlos Santos", 19, "123.422.154-12", "81 99857-3245", "EmailTeste@gmail.com");
        clienteServico.cadastra(cliente);
        clienteServico.listar();

        System.out.println(" ");

        ArrayList<Aluguel> algueis = new ArrayList<>();
        AluguelRepositorio aluguelRepositorio = new AluguelRepositorio(algueis);
        AluguelServico aluguelServico = new AluguelServico(aluguelRepositorio);
        Aluguel aluguel = new Aluguel(200);

        aluguelServico.calcularManutencao(aluguel);
        aluguelServico.cadastra(aluguel);
        aluguelServico.listar();
        
        System.out.println(" ");

        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        FuncionarioServico funcServico = new FuncionarioServico(funcionarioRepositorio);

        funcServico.enqueue(new Funcionario("Thiago Calvacante", 19, "154.342.212-12", "81 99845 2363", "ThiaginhoCalva@gmail.com", "Atendende", 1567.8));
        System.out.println(funcServico.front());

        funcServico.enqueue(new Funcionario("Luana Santos", 21, null, null, null, null, 0));
        funcServico.dequeue();
        
        System.out.println(funcServico.front());
    }
}

