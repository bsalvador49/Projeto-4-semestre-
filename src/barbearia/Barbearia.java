package barbearia;

import java.sql.Connection;
import java.util.Scanner;

public class Barbearia {

    public static void main(String[] args) {
        
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            System.out.println("Conexão com o banco estabelecida com sucesso!\n");
        } else {
            System.out.println("Falha ao conectar. Verifique se o pgAdmin está rodando e a senha.");
            return; 
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("=== BARBEARIA TRATO FINO ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n=== LOGIN ===");
                    System.out.print("Digite seu CPF: ");
                    String cpfLogin = scanner.nextLine();
                    
                    System.out.print("Digite sua Senha: ");
                    String senhaLogin = scanner.nextLine();
                    
                    UsuarioDAO daoLogin = new UsuarioDAO();
                    String resultadoLogin = daoLogin.fazerLogin(cpfLogin, senhaLogin);
                    
                    if (resultadoLogin != null) {
                        
                        String[] dados = resultadoLogin.split(":");
                        String perfilUsuario = dados[0];
                        String nomeUsuario = dados[1];
                        
                        System.out.println("\n✅ Login realizado com sucesso!");
                        System.out.println("Bem-vindo(a), " + nomeUsuario + " (" + perfilUsuario + ")\n");
                        
                    } else {
                        System.out.println("\n❌ CPF ou senha incorretos!\n");
                    }
                    break;
                    
                case 2:
                    System.out.println("\n=== CADASTRO DE CLIENTE ===");
                    System.out.print("Nome completo: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("CPF (somente números): ");
                    String cpf = scanner.nextLine();
                    
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    
                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    UsuarioDAO dao = new UsuarioDAO();
                    if (dao.cadastrarCliente(nome, cpf, senha, telefone, email)) {
                        System.out.println("\n✅ Cliente cadastrado com sucesso!\n");
                    } else {
                        System.out.println("\n❌ Falha ao cadastrar. Verifique se o CPF já existe.\n");
                    }
                    break;
                    
                case 0:
                    System.out.println("\nSaindo do sistema. Até logo!");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }
        scanner.close();
    }
}
