package view;

import java.util.Scanner;

public class Lab01Sistema {

    // Instanciar o Scanner uma vez
    private static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("9 - Fim");
            System.out.print("Digite sua opção: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    execCadastramento();
                    break;
                case 2:
                    execSaque();
                    break;
                case 3:
                    execDeposito();
                    break;
                case 9:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        leia.close(); // Fechar o Scanner no final
    }

    public static void execCadastramento() {
        System.out.print("Número da Agência: ");
        int agencia = leia.nextInt();
        System.out.print("Número da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Nome do Cliente: ");
        String nome = leia.next();
        System.out.print("Saldo: ");
        double saldo = leia.nextDouble();
        System.out.print("Confirma cadastramento (S/N): ");
        String cad = leia.next();
        if (cad.equalsIgnoreCase("s")) {
            System.out.println("Cadastro realizado com sucesso.");
        } else {
            System.out.println("Cadastro não realizado.");
        }
    }

    public static void execSaque() {
        System.out.print("Número da Agência: ");
        int agencia = leia.nextInt();
        System.out.print("Número da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Valor do Saque: ");
        double saque = leia.nextDouble();
        System.out.print("Confirma saque (S/N): ");
        String saq = leia.next();
        if (saq.equalsIgnoreCase("s")) {
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Saque não realizado.");
        }
    }

    public static void execDeposito() {
        System.out.print("Número da Agência: ");
        int agencia = leia.nextInt();
        System.out.print("Número da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Valor do Depósito: ");
        double deposito = leia.nextDouble();
        System.out.print("Confirma depósito (S/N): ");
        String dep = leia.next();
        if (dep.equalsIgnoreCase("s")) {
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Depósito não realizado.");
        }
    }
}
