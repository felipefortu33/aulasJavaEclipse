package view;

import java.util.Scanner;

public class Lab01Sistema {
    // Criar uma única instância do Scanner para reutilização
    private static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("9 - Fim");
            System.out.println("Digite sua opção: ");
            opcao = leia.nextInt();

            if (opcao == 1) {
                execCadastramento();
            } else if (opcao == 2) {
                execSaque();
            } else if (opcao != 9) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        // Fechar o Scanner ao final do uso
        leia.close();
    }

    public static void execCadastramento() {
        System.out.println("Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.println("Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.println("Nome do Cliente: ");
        String nome = leia.next();
        System.out.println("Saldo: ");
        double saldo = leia.nextDouble();
        System.out.println("Confirma cadastramento (S/N): ");
        String cad = leia.next();
        if (cad.equalsIgnoreCase("s")) {
            System.out.println("Cadastro Realizado com sucesso");
        }
    }

    public static void execSaque() {
        System.out.println("Numero da Agencia :");
        int agencia = leia.nextInt();
        System.out.println("Numero da Conta   :");
        int conta = leia.nextInt();
        System.out.println("Valor do Saque: ");
        double saque = leia.nextDouble();
        System.out.println("Confirma saque (S/N) :");
        String cad = leia.next();
        if (cad.equalsIgnoreCase("s")) {
            System.out.println("Saque realizado");
        }
    }
}
