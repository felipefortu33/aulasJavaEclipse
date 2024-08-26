package view;

import java.util.Scanner;
import model.Lab02ContaCorrente;

public class Lab02Sistema {
    private Lab02ContaCorrente myConta = new Lab02ContaCorrente();
    private static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        Lab02Sistema sistema = new Lab02Sistema();
        sistema.executarLab();
    }

    private void executarLab() {
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("4 - Consulta");
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
                case 4:
                    execConsulta();
                    break;
                case 9:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    public void execCadastramento() {
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
            myConta.setNumAge(agencia);
            myConta.setNumConta(conta);
            myConta.setNumNome(nome);
            myConta.setNumSaldo(saldo);
            System.out.println("Cadastro realizado com sucesso.");
        } else {
            System.out.println("Cadastro não realizado.");
        }
    }

    public void execSaque() {
        double saque;
        do {
            System.out.print("Valor do Saque: ");
            saque = leia.nextDouble();
        } while (saque <= 0.0);

        System.out.print("Confirma saque (S/N): ");
        String saq = leia.next();
        if (saq.equalsIgnoreCase("s")) {
            int resultado = myConta.saque(saque);
            if (resultado == 1) {
                System.out.println("Saque realizado.");
            } else {
                System.out.println("Saldo Insuficiente.");
            }
        } else {
            System.out.println("Saque não realizado.");
        }
    }

    public void execDeposito() {
        double deposito;
        do {
            System.out.print("Valor do Depósito: ");
            deposito = leia.nextDouble();
        } while (deposito <= 0.0);

        System.out.print("Confirma depósito (S/N): ");
        String dep = leia.next();
        if (dep.equalsIgnoreCase("s")) {
            myConta.deposito(deposito);
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Depósito não realizado.");
        }
    }

    public void execConsulta() {
        myConta.imprimir();
    }
}
