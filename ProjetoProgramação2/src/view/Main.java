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
import Repositorio.FuncionarioRepositorioJDBC;
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
    public static FuncionarioRepositorioJDBC funcionarioRepositorio = new FuncionarioRepositorioJDBC();
    public static FuncionarioServico funcServico = new FuncionarioServico(funcionarioRepositorio);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n === Menu de escolha ===");
            System.out.println("1 - Gerenciar Equipamentos");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Gerenciar Aluguéis");
            System.out.println("4 - Gerenciar Funcionários");
            System.out.println("5 - Encerrar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
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
    public static void menuEquipamento() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== Menu Equipamento ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
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

    private static void CadastraEquipamento() {
        System.out.print("Digite o id: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o nome do equipamento: ");
        String nome = teclado.next();

        System.out.print("Digite o tipo do equipamento: ");
        String tipo = teclado.next();

        Equipamento equipamento = new Equipamento(id, nome, tipo);

        try {
            equipamentoServico.adicionar(equipamento); // adiciona no repositório
            System.out.println("Equipamento cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Equipamento: " + e.getMessage());
        }
    }

    private static void listarEquipamento() {
        List<Equipamento> equipamentos = equipamentoServico.listar();
        if (equipamentos.isEmpty()) {
            System.out.println("Nenhum equipamento encontrado.");
        } else {
            for (Equipamento eq : equipamentos) {
                System.out.println(eq);
            }
        }
    }

    private static void removerEquipamento() {
        System.out.print("Informe o ID do Equipamento a ser removido: ");
        int id = teclado.nextInt();
        boolean sucesso = equipamentoServico.excluir(id); // remove da estrutura e banco
        System.out.println(sucesso ? "Equipamento removido com sucesso!" : "Equipamento não encontrado.");
    }

    private static void atualizarEquipamento() {
        System.out.print("Informe o ID do Cliente a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        // Verifica se existe no banco
        if (!equipamentoServico.buscarID(id)) {
            System.out.println("Cliente com ID " + id + " não encontrado.");
            return;
        }

        // Coletar os novos dados
        System.out.print("Novo nome: ");
        String nome = teclado.nextLine();

        System.out.print("Novo tipo: ");
        String tipo = teclado.nextLine();

        Equipamento atualizado = new Equipamento(id, nome, tipo);
        boolean sucesso = equipamentoServico.alteraEquipamento(atualizado);
        System.out.println(sucesso ? "Equipamento alterado com sucesso!" : "Erro ao alterar Equipamento.");
    }

    // Menu de cliente
    public static void menuCliente() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
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

    private static void CadastraCliente() {
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
        
        try {
            clienteServico.cadastra(cliente); // adiciona no repositório
            System.out.println("cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private static void listarCliente() {
        List<Cliente> clientes = clienteServico.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            for (Cliente cli : clientes) {
                System.out.println(cli);
            }
        }
    }

    private static void removerCliente() {
        System.out.print("Informe o ID do Cliente a ser removido: ");
        int id = teclado.nextInt();
        boolean sucesso = clienteServico.excluir(id); // remove da estrutura e banco
        System.out.println(sucesso ? "Cliente removido com sucesso!" : "Cliente não encontrado.");
    }

    private static void atualizarCliente() {
        System.out.print("Informe o ID do Cliente a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        // Verifica se existe no banco
        if (!clienteServico.buscarID(id)) {
            System.out.println("Cliente com ID " + id + " não encontrado.");
            return;
        }

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

        System.out.print("Novo endereco: ");
        String endereco = teclado.nextLine();

        Cliente atualizado = new Cliente(id, nome, dataNascimento, cpf, telefone, email, endereco);
        boolean sucesso = clienteServico.alteraCliente(atualizado);
        System.out.println(sucesso ? "Cliente alterado com sucesso!" : "Erro ao alterar Cliente.");
    }

    // Menu de Aluguel
    public static void menuAluguel() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== Menu Aluguel ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Altera");
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

    private static void CadastraAluguel() {
        System.out.print("Digite o numero do aluguel: ");
        int numero = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Digite o valor do aluguel: ");
        double valor = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("Digite o valor de manutenção: ");
        double manutencao = teclado.nextDouble();

        Aluguel aluguel = new Aluguel(numero, valor, manutencao);
        try {
            aluguelServico.salvar(aluguel); // adiciona no repositório
            System.out.println("aluguel cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluguel: " + e.getMessage());
        }
    }

    private static void listarAluguel() {
        List<Aluguel> alugueis = aluguelServico.listar();
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado.");
        } else {
            for (Aluguel aluguel : alugueis) {
                System.out.println(aluguel);
            }
        }
    }

    private static void removerAluguel() {
        System.out.print("Informe o ID do aluguel a ser removido: ");
        int id = teclado.nextInt();
        boolean sucesso = aluguelServico.excluir(id); // remove da estrutura e banco
        System.out.println(sucesso ? "aluguel removido com sucesso!" : "aluguel não encontrado.");
    }

    private static void atualizarAluguel() {
        System.out.print("Informe o ID do aluguel a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        // Verifica se existe no banco
        if (!aluguelServico.buscarNumero(id)) {
            System.out.println("Aluguel com ID " + id + " não encontrado.");
            return;
        }

        // Coletar os novos dados

        System.out.print("Novo custo de aluguel: ");
        Double custo  = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("Novo custo manutenção: ");
        Double manutencao = teclado.nextDouble();
        teclado.nextLine();

        Aluguel atualizado = new Aluguel(id, custo, manutencao);
        boolean sucesso = aluguelServico.alteraAluguel(atualizado);
        System.out.println(sucesso ? "Aluguel alterado com sucesso!" : "Erro ao alterar Aluguel.");
    }

    // Menu de funcionario
    public static void menuFuncionario() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Alterar");
            System.out.println("5 - Voltar");
            System.out.print("Sua escolha: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
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

    private static void cadastrarFuncionario() {
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

        try {
            funcServico.adicionarFuncionario(funcionario); // adiciona no repositório (fila + banco)
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    private static void listarFuncionario() {
        List<Funcionario> funcionarios = funcServico.exibirFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            for (Funcionario fun : funcionarios) {
                System.out.println(fun);
            }
        }
    }

    private static void removerFuncionario() {
        System.out.print("Informe o ID do funcionário a ser removido: ");
        int id = teclado.nextInt();
        boolean sucesso = funcServico.removerFuncionario(id); // remove da estrutura e banco
        System.out.println(sucesso ? "Funcionário removido com sucesso!" : "Funcionário não encontrado.");
    }

    private static void alterarFuncionario() {
        System.out.print("Informe o ID do funcionário a ser alterado: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        // Verifica se existe no banco
        if (!funcServico.BuscarPorId(id)) {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
            return;
        }

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
        System.out.println(sucesso ? "Funcionário alterado com sucesso!" : "Erro ao alterar funcionário.");
    }
}
