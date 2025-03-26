package view;

import java.util.ArrayList;
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
    public static void main(String[] args) {
        int opcao = 0;

        while(opcao != 5){

            // Menu de escolha do usuario
            System.out.println("\n === Menu de escolha ===");
            System.out.println("Se você deseja cadastra um equipamento digite 1");
            System.out.println("Se você deseja cadastra um Cliente, digite 2");
            System.out.println("Se você deseja cadastra um Aluguel, digite 3");
            System.out.println("Se você deseja cadastra um Funcionario, digite 4");
            System.out.println("Caso queira encerra o programa, digite 5");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();
            
            // Chama os metodos resprequitivo de cada escolha
            switch(opcao){
                case 1:
                    CadastraEquipamento();
                    break;
                case 2:
                    CadastraCliente();
                    break;
                case 3: 
                    CadastraAluguel();
                    break;
                case 4:
                    CadastraFuncionario();
                    break;
                case 5:
                    System.out.println("Encerrando o cadastro");
                    break;  
                default:
                    System.out.println("Opção Invalida");
                    break;              
            }
    
        }

        System.out.println("O Programa foi encerrado com sucesso!");
        teclado.close();
    }

    public static void CadastraEquipamento(){
        // Criação do Objeto Equipamento
        ArrayList<Equipamento> equipamentos = new ArrayList<>();
        EquipamentoRepositorio equipamentoRepositorio = new EquipamentoRepositorio(equipamentos);
        EquipamentoServico equipamentoServico = new EquipamentoServico(equipamentoRepositorio);
        
        // Solicita dados ao usuário
        System.out.print("Digite o nome do equipamento: ");
        String nome = teclado.next();
        System.out.print("Digite o tipo do equipamento: ");
        String tipo = teclado.next();
        
        Equipamento equipamento = new Equipamento(nome, tipo);
        equipamentoServico.adicionar(equipamento);
        equipamentoServico.listar();
    }

    public static void CadastraCliente(){
        // Criação do objeto Cliente
        ArrayList<Cliente> clientes = new ArrayList<>();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio(clientes);
        ClienteServico clienteServico = new ClienteServico(clienteRepositorio);

        // Solicita dados ao usuário
        System.out.print("Digite a idade do cliente: ");
        int idade = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nome = teclado.nextLine();
    
        System.out.print("Digite o CPF do cliente: ");
        String cpf = teclado.nextLine();
    
        System.out.print("Digite o telefone do cliente: ");
        String telefone = teclado.nextLine();
    
        System.out.print("Digite o email do cliente: ");
        String email = teclado.nextLine();
    
        System.out.print("Digite o endereço do cliente: ");
        String endereco = teclado.nextLine();
                
        Cliente cliente = new Cliente(nome, idade, cpf, telefone, email, endereco);
        clienteServico.cadastra(cliente);
        clienteServico.listar();
    }

    public static void CadastraAluguel(){
        // Criação do objeto Aluguel
        ArrayList<Aluguel> algueis = new ArrayList<>();
        AluguelRepositorio aluguelRepositorio = new AluguelRepositorio(algueis);
        AluguelServico aluguelServico = new AluguelServico(aluguelRepositorio);
        
        // Solicita dados ao usuário
        System.out.print("Digite o valor do aluguel: ");
        double valor = teclado.nextDouble();
                
        Aluguel aluguel = new Aluguel(valor);
        aluguelServico.calcularManutencao(aluguel);
        aluguelServico.salvar(aluguel);
        aluguelServico.listar();
    }

    public static void CadastraFuncionario(){
        // Criando o Objeto Funcionarios usando Fila com ArrayList
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        FuncionarioServico funcServico = new FuncionarioServico(funcionarioRepositorio);

        // Solicita dados ao usuário
        System.out.print("Digite a idade do funcionário: ");
        int idadeFun = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o nome do funcionário: ");
        String nomeFun = teclado.nextLine();
    
        System.out.print("Digite o CPF do funcionário: ");
        String cpfFun = teclado.nextLine();
    
        System.out.print("Digite o telefone do funcionário: ");
        String telefoneFun = teclado.nextLine();
    
        System.out.print("Digite o email do funcionário: ");
        String emailFun = teclado.nextLine();
    
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = teclado.nextLine();
    
        System.out.print("Digite o salário do funcionário: ");
        double salario = teclado.nextDouble();

        Funcionario funcionario = new Funcionario(nomeFun, idadeFun, cpfFun, telefoneFun, emailFun, cargo, salario);
        
        funcServico.enqueue(funcionario);

        funcServico.lista();
    
        System.out.println(funcServico.front());
    }
}

