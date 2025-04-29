package view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import Entidades.Cliente;
import Repositorio.ClienteRepositorioJDBC;
import Servico.ClienteServico;

import Entidades.Aluguel;
import Repositorio.AluguelRepositorioJDBC;
import Servico.AluguelServico;

import Entidades.Equipamento;
import Repositorio.EquipamentoRepositorioJDBC;
import Servico.EquipamentoServico;

import Entidades.Funcionario;
import Repositorio.FuncionarioRepositorio;
import Servico.FuncionarioServico;

public class Main {
    public static Scanner teclado = new Scanner(System.in);

    // Iniciação dos repositórios com JDBC
    public static EquipamentoRepositorioJDBC equipamentoRepo = new EquipamentoRepositorioJDBC();
    public static EquipamentoServico equipamentoServico = new EquipamentoServico(equipamentoRepo);

    public static ClienteRepositorioJDBC clienteRepositorio = new ClienteRepositorioJDBC();
    public static ClienteServico clienteServico = new ClienteServico(clienteRepositorio);

    public static AluguelRepositorioJDBC aluguelRepositorio = new AluguelRepositorioJDBC();
    public static AluguelServico aluguelServico = new AluguelServico(aluguelRepositorio);

    // Funcionário sem o JDBC
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

    // Menu de equipamento
    public static void menuEquipamento(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Equipamento ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Listar");
            System.out.println("4 - Alterar");
            System.out.println("5 - Voltar");
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
                    removerEquipamento();
                    break;
                case 4:
                    atualizarEquipamento();
                    break;
                case 5:
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
    public static void removerEquipamento(){
        try {
            System.out.print("Digite o ID do jogo a ser removido: ");
            int id = teclado.nextInt();
            
            Equipamento equipamento = equipamentoServico.buscarID(id);
            if (equipamento == null) {
                System.out.println("Jogo nao encontrado!");
                return;
            }
            
            System.out.println("Jogo a ser removido:");
            System.out.println(equipamento);
            
            System.out.print("Confirma a remocao? S/N: ");
            String confirmacao = teclado.next();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                equipamentoServico.excluir(id);
                System.out.println("Jogo removido com sucesso!");
            } else {
                System.out.println("Operacao cancelada.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao remover o jogo: " + e.getMessage());
        }
    }

    public static void atualizarEquipamento() {
        try {
            System.out.print("Digite o ID do equipamento a ser atualizado: ");
            int id = teclado.nextInt();
            teclado.nextLine();
    
            Equipamento eq = equipamentoServico.buscarID(id);
            if (eq == null) {
                System.out.println("Equipamento não encontrado!");
                return;
            }
    
            System.out.println("Dados atuais:");
            System.out.println(eq);
    
            System.out.println("\nInsira os novos dados (ENTER para manter o valor atual):");
    
            System.out.print("Nome " + eq.getNomeEquipamento() + ": ");
            String nome = teclado.nextLine();
            if (!nome.isEmpty()){
                eq.setNomeEquipamento(nome);
            } 

            System.out.print("Tipo " + eq.getTipoEquipamento() + ": ");
            String tipo = teclado.nextLine();
            if (!tipo.isEmpty()) {
                eq.setTipoEquipamento(tipo);
            }

            equipamentoServico.alteraEquipamento(eq);
            System.out.println("Equipamento atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar equipamento: " + e.getMessage());
        }
    }

    // Menu de cliente
    public static void menuCliente(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Listar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Voltar");
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
                    removerCliente();
                    break;
                case 4:
                    atualizarCliente();
                    break;    
                case 5:
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

   public static void removerCliente(){
        try {
            System.out.print("Digite o ID do jogo a ser removido: ");
            int id = teclado.nextInt();
            
            Cliente cliente = clienteServico.buscarID(id);
            if (cliente == null) {
                System.out.println("Jogo nao encontrado!");
                return;
            }
            
            System.out.println("Jogo a ser removido:");
            System.out.println(cliente);
            
            System.out.print("Confirma a remocao? S/N: ");
            String confirmacao = teclado.next();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                clienteServico.excluir(id);
                System.out.println("Jogo removido com sucesso!");
            } else {
                System.out.println("Operacao cancelada.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao remover o jogo: " + e.getMessage());
        }
    }

    public static void atualizarCliente(){
        try {
            System.out.print("Digite o ID do cliente a ser atualizado: ");
            int id = teclado.nextInt();
            teclado.nextLine();
    
            Cliente clienteExistente = clienteServico.buscarID(id);
            if (clienteExistente == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }
    
            System.out.println("Dados atuais do cliente:");
            System.out.println(clienteExistente);
    
            System.out.println("\nInsira os novos dados:");
    
            System.out.print("Nome [" + clienteExistente.getNomeCompleto() + "]: ");
            String nome = teclado.nextLine();
            if (!nome.isEmpty()) {
                clienteExistente.setNomeCompleto(nome);
            }
    
            System.out.print("CPF [" + clienteExistente.getCpf() + "]: ");
            String cpf = teclado.nextLine();
            if (!cpf.isEmpty()) {
                clienteExistente.setCpf(cpf);
            }
    
            System.out.print("Telefone [" + clienteExistente.getCelular() + "]: ");
            String telefone = teclado.nextLine();
            if (!telefone.isEmpty()) {
                clienteExistente.setCelular(telefone);
            }

            System.out.print("Email [" + clienteExistente.getEmail() + "]: ");
            String email = teclado.nextLine();
            if (!email.isEmpty()) {
                clienteExistente.setEmail(email);
            }
    
            System.out.print("Endereço [" + clienteExistente.getEndereco() + "]: ");
            String endereco = teclado.nextLine();
            if (!endereco.isEmpty()) {
                clienteExistente.setEndereco(endereco);
            }
    
            System.out.print("Data de nascimento (dd/MM/yyyy) [" + clienteExistente.getDatanascimento() + "]: ");
            String data = teclado.nextLine();
            if (!data.isEmpty()) {
                try {
                    clienteExistente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                } catch (ParseException e) {
                    System.out.println("Data inválida! Mantendo a data anterior.");
                }
            }
    
            clienteServico.alteraCliente(clienteExistente);
            System.out.println("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    
    // Menu de Aluguel
    public static void menuAluguel(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Aluguel ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Listar");
            System.out.println("4 - Listar");
            System.out.println("5 - Voltar");
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
                    removerAluguel();
                    break;
                case 4:
                    atualizarAluguel();
                    break;
                case 5:
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

    public static void removerAluguel(){
        try {
            System.out.print("Digite o ID do jogo a ser removido: ");
            int id = teclado.nextInt();
            
            Aluguel aluguel = aluguelServico.buscarNumero(id);
            if (aluguel == null) {
                System.out.println("Jogo nao encontrado!");
                return;
            }
            
            System.out.println("Jogo a ser removido:");
            System.out.println(aluguel);
            
            System.out.print("Confirma a remocao? S/N: ");
            String confirmacao = teclado.next();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                aluguelServico.excluir(id);
                System.out.println("Jogo removido com sucesso!");
            } else {
                System.out.println("Operacao cancelada.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao remover o jogo: " + e.getMessage());
        }
    }

    public static void atualizarAluguel() {
        try {
            System.out.print("Digite o número do aluguel a ser atualizado: ");
            int numero = teclado.nextInt();
            teclado.nextLine();
    
            Aluguel aluguel = aluguelServico.buscarNumero(numero);
            if (aluguel == null) {
                System.out.println("Aluguel não encontrado!");
                return;
            }
    
            System.out.println("Dados atuais:");
            System.out.println(aluguel);
    
            System.out.println("\nInsira os novos dados ( ENTER para manter o valor atual):");
    
            System.out.print("Valor [" + aluguel.getCustoAluguel() + "]: ");
            String valorStr = teclado.nextLine();
            if (!valorStr.isEmpty()){ 
                aluguel.setCustoAluguel(Double.parseDouble(valorStr));
            }
            
            aluguelServico.alteraAluguel(aluguel);
            System.out.println("Aluguel atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluguel: " + e.getMessage());
        }
    }

    // Menu de funcionario
    public static void menuFuncionario(){
        int opcao = 0;
        while(opcao != 3){
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - remover");
            System.out.println("4 - alterar");
            System.out.println("5 - Voltar");
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
                    removerFuncionario();
                    break;
                case 4:
                    alterarFuncionario();
                    break;    
                case 5:
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
            for(Funcionario fun : funcionarios){
                System.out.println(fun);
            }
        }
    }

    public static void removerFuncionario(){
        System.out.print("Informe o ID do funcionário a ser removido: ");
        int id = teclado.nextInt();
        boolean sucesso = funcServico.buscarID(id);
        System.out.println(sucesso ? "Funcionário removido com sucesso!" : "Funcionário não encontrado.");
    }
    
    public static void alterarFuncionario(){
        System.out.print("Informe o ID do funcionário a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine();
    
        // Coletar os novos dados
        System.out.print("Novo nome: ");
        String nome = teclado.nextLine();
    
        System.out.print("Nova data de nascimento (dd/MM/yyyy): ");
        String data = teclado.nextLine();
        Date dataNascimento = null;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            return;
        }
    
        System.out.print("Novo CPF: ");
        String cpf = teclado.nextLine();
    
        System.out.print("Novo telefone: ");
        String telefone = teclado.nextLine();
    
        System.out.print("Novo email: ");
        String email = teclado.nextLine();
    
        System.out.print("Novo cargo: ");
        String cargo = teclado.nextLine();
    
        System.out.print("Novo salário: ");
        double salario = teclado.nextDouble();
    
        Funcionario atualizado = new Funcionario(id, nome, dataNascimento, cpf, telefone, email, cargo, salario);
        boolean sucesso = funcServico.alterarFuncionario(atualizado);
        System.out.println(sucesso ? "Funcionário alterado com sucesso!" : "Funcionário não encontrado.");
    }
    
}
