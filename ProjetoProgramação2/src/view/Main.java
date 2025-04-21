package view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

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
    public static Scanner teclado = new Scanner(System.in);

    // Iniciação dos repositórios com JDBC
    public static EquipamentoRepositorio equipamentoRepo = new EquipamentoRepositorio();
    public static EquipamentoServico equipamentoServico = new EquipamentoServico(equipamentoRepo);

    public static ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    public static ClienteServico clienteServico = new ClienteServico(clienteRepositorio);

    public static AluguelRepositorio aluguelRepositorio = new AluguelRepositorio();
    public static AluguelServico aluguelServico = new AluguelServico(aluguelRepositorio);

    // Funcionário permanece sem JDBC
    public static FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
    public static FuncionarioServico funcServico = new FuncionarioServico(funcionarioRepositorio);

    public static void main(String[] args) {
        int opcao = 0;

        while(opcao != 5){
            System.out.println("\n === Menu de escolha ===");
            System.out.println("1 - Gerenciar Equipamentos");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Gerenciar Aluguéis");
            System.out.println("4 - Gerenciar Funcionários");
            System.out.println("5 - Encerrar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 1: 
                    menuEquipamento(); 
                    break;
                case 2: 
                    menuCliente(); 
                    break;
                case 3:     
                    menuAluguel(); 
                    break;
                case 4:  
                    menuFuncionario(); 
                    break;
                case 5: 
                    System.out.println("Sistema Encerrado com sucesso!"); 
                    break;
                default: 
                    System.out.println("Opção Inválida."); 
                    break;
            }
        }

        teclado.close();
    }

    // === Equipamento ===
    public static void menuEquipamento(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Equipamento ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Voltar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1: 
                    CadastraEquipamento(); 
                    break;
                case 2: 
                    listarEquipamento(); 
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal!"); 
                    break;
                default: 
                    System.out.println("Opção inválida."); 
                    break;  
            }
        }
    }

    public static void CadastraEquipamento(){
        System.out.println("Digite o id: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o nome do equipamento: ");
        String nome = teclado.next();

        System.out.print("Digite o tipo do equipamento: ");
        String tipo = teclado.next();

        Equipamento equipamento = new Equipamento(id, nome, tipo);
        equipamentoServico.adicionar(equipamento);
    }

    public static void listarEquipamento() {
        List<Equipamento> equipamentos = equipamentoServico.listar();
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento encontrado.");
        } else {
            for (Equipamento eq : equipamentos) {
                System.out.println(eq);
            }
        }
    }

    // === Cliente ===
    public static void menuCliente(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Voltar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1: 
                    CadastraCliente(); 
                    break;
                case 2: 
                    listarCliente(); 
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal!"); 
                    break;
                default: 
                    System.out.println("Opção inválida."); 
                    break;
            }
        }
    }

    public static void CadastraCliente(){
        System.out.print("Digite o ID do cliente: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
        String data = teclado.nextLine();
        Date dataNascimento = null;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            return;
        }

        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("CPF: ");
        String cpf = teclado.nextLine();
        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();

        Cliente cliente = new Cliente(id, nome, dataNascimento, cpf, telefone, email, endereco);
        clienteServico.cadastra(cliente);
    }

    public static void listarCliente(){
        List<Cliente> clientes = clienteServico.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            for (Cliente cli : clientes) {
                System.out.println(cli);
            }
        } 
    }

    // === Aluguel ===
    public static void menuAluguel(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Aluguel ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Voltar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1: 
                    CadastraAluguel(); 
                    break;
                case 2: 
                    listarAluguel(); 
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal!"); 
                    break;
                default: 
                    System.out.println("Opção inválida."); 
                    break; 
            }
        }
    }

    public static void CadastraAluguel(){
        System.out.println("Digite o numero do aluguel: ");
        int numero = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o valor do aluguel: ");
        double valor = teclado.nextDouble();
        teclado.nextLine();

        System.out.println("Digite o valor de manutenção: ");
        double manutencao = teclado.nextDouble();

        Aluguel aluguel = new Aluguel(numero, valor, manutencao); 
        aluguelServico.salvar(aluguel);
    }

    public static void listarAluguel(){
        List<Aluguel> alugueis = aluguelServico.listar();
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado.");
        } else {
            for (Aluguel aluguel : alugueis) {
                System.out.println(aluguel);
            }
        }
    }

    // === Funcionário (sem JDBC) ===
    public static void menuFuncionario(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Voltar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1: 
                    CadastraFuncionario(); 
                    break;
                case 2: 
                    listarFuncionario(); 
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal!"); 
                    break;
                default: 
                    System.out.println("Opção inválida."); 
                    break; 
            }
        }
    }

    public static void CadastraFuncionario(){
        System.out.print("ID: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String data = teclado.nextLine();
        Date dataNascimento = null;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            return;
        }

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("CPF: ");
        String cpf = teclado.nextLine();

        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();

        System.out.print("Email: ");
        String email = teclado.nextLine();

        System.out.print("Cargo: ");
        String cargo = teclado.nextLine();

        System.out.print("Salário: ");
        double salario = teclado.nextDouble();

        Funcionario funcionario = new Funcionario(id, nome, dataNascimento, cpf, telefone, email, cargo, salario);
        funcServico.enqueue(funcionario);
    }

    public static void listarFuncionario(){
        List<Funcionario> funcionarios = funcServico.lista(); 
        if(funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            for(Funcionario f : funcionarios){
                System.out.println(f);
            }
        }
    }
}
