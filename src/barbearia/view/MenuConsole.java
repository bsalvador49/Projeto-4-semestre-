package barbearia.view;

import barbearia.service.UsuarioService;
import java.util.Scanner;

public class MenuConsole {
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n=== BARBEARIA TRATO FINO ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Fazer Login");
            System.out.println("3 - Cadastrar Barbeiro");
            System.out.println("4 - Novo Agendamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            String entrada = scanner.nextLine();
            int opcao;
            
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite apenas numeros!");
                continue;
            }

            OpcaoMenuPrincipal escolha = OpcaoMenuPrincipal.fromInt(opcao);
            
            if (escolha == null) {
                System.out.println("[ERRO] Opcao invalida. Tente novamente.");
                continue;
            }

            switch (escolha) {
                case CADASTRAR:
                    executarCadastro();
                    break;
                case LOGIN:
                    System.out.println("Modulo de login em construcao...");
                    break;
                case CADASTRAR_BARBEIRO:
                    executarCadastroBarbeiro();
                    break;
                    case AGENDAR:
                    executarAgendamento(); 
                    break;
                case SAIR:
                    System.out.println("Saindo do sistema. Ate logo!");
                    return;
            }
        }
    }

    private void executarCadastro() {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        
        System.out.print("CPF (somente numeros): ");
        String cpf = scanner.nextLine().trim();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();
        
        System.out.print("E-mail: ");
        String email = scanner.nextLine().trim();

        UsuarioService service = new UsuarioService();
        
        if (service.cadastrarNovoCliente(nome, cpf, senha, telefone, email)) {
            System.out.println("\n[OK] Cliente cadastrado com sucesso no banco de dados!");
        } else {
            System.out.println("\n[ERRO] Falha ao cadastrar cliente. Verifique os dados inseridos.");
        }
}
    private void executarCadastroBarbeiro() {
        System.out.println("\n--- CADASTRO DE BARBEIRO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        
        System.out.print("CPF (somente numeros): ");
        String cpf = scanner.nextLine().trim();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine().trim();
        
        System.out.print("Especialidade (ex: Tesoura, Degradê): ");
        String especialidade = scanner.nextLine().trim();

        barbearia.service.BarbeiroService service = new barbearia.service.BarbeiroService();
        
        if (service.cadastrarNovoBarbeiro(nome, cpf, senha, especialidade)) {
            System.out.println("\n[OK] Barbeiro cadastrado com sucesso no banco de dados!");
        } else {
            System.out.println("\n[ERRO] Falha ao cadastrar barbeiro. Verifique os dados inseridos.");
        }
    }
    private void executarAgendamento() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");
        
        System.out.print("ID do Cliente (veja no pgAdmin): ");
        int idCliente = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("ID do Barbeiro (veja no pgAdmin): ");
        int idBarbeiro = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("ID do Serviço (digite 1 para Degradê): ");
        int idServico = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("Data e Hora (Ex: 09/11/2026 15:30): ");
        String dataHora = scanner.nextLine().trim();

        barbearia.service.AgendamentoService service = new barbearia.service.AgendamentoService();
        
        if (service.criarAgendamento(idCliente, idBarbeiro, idServico, dataHora)) {
            System.out.println("\n[OK] Agendamento confirmado com sucesso!");
        } else {
            System.out.println("\n[FALHA] Não foi possível concluir o agendamento.");
        }
    }
}