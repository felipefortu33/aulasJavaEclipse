package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import bancodados.AtualizaDados;
import bancodados.ConexaoBancoDados;
import bancodados.InsereDados;
import bancodados.SelecionaDados;
import model.Lab03ContaCorrenteBancoDados;

public class Lab03SistemaBancoDados {
    
    // Criando um único Scanner para ser utilizado em todo o programa.
    private Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        new Lab03SistemaBancoDados().executarLab();
    }

    private void executarLab() {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Cadastramento");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            System.out.println("4 - Imprimir");
            System.out.println("9 - Fim ");
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
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        leia.close();  // Fechar o Scanner ao final do programa
    }

    public void execCadastramento() {
        System.out.println("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.println("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.println("Digite o Nome do Cliente: ");
        String nome = leia.next();
        System.out.println("Digite o Saldo: ");
        double saldo = leia.nextDouble();
        System.out.println("Confirma cadastramento (S/N):");
        String cad = leia.next();

        if (cad.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta, nome, saldo);
            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            Connection con = conexPost.conectarBanco();
            InsereDados ins = new InsereDados();
            ins.inserirDados(con, myConta);

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Problemas ao encerrar a conexão.");
                e.printStackTrace();
            }

            System.out.println("Cadastro realizado com sucesso.");
        } else {
            System.out.println("Cadastro cancelado.");
        }
    }

    public void execSaque() {
        System.out.println("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.println("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.println("Digite o valor do saque: ");
        double valor = leia.nextDouble();
        System.out.println("Confirma saque (S/N):");
        String saq = leia.next();

        if (saq.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta);

            // Conectar ao banco e selecionar os dados da conta
            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            Connection con = conexPost.conectarBanco();
            SelecionaDados sel = new SelecionaDados();
            sel.selecionarDados(con, myConta);  // Aqui você deve garantir que os dados estão carregados

            System.out.println("Saldo atual: " + myConta.getSaldo());

            int ret = myConta.sacar(valor);  // Realiza o saque
            if (ret == 1) {
                AtualizaDados atu = new AtualizaDados();
                atu.atualizarDados(con, myConta);  // Atualiza os dados no banco de dados
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente.");
            }

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Problemas ao encerrar a conexão.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Saque cancelado.");
        }
    }

    public void execDeposito() {
        System.out.println("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.println("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.println("Digite o valor do depósito: ");
        double valor = leia.nextDouble();
        System.out.println("Confirma depósito (S/N):");
        String dep = leia.next();

        if (dep.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta);

            // Conectar ao banco e selecionar os dados da conta
            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            Connection con = conexPost.conectarBanco();
            SelecionaDados sel = new SelecionaDados();
            sel.selecionarDados(con, myConta);  // Buscar dados da conta

            System.out.println("Saldo atual: " + myConta.getSaldo());

            myConta.deposito(valor);  // Realiza o depósito
            AtualizaDados atu = new AtualizaDados();
            atu.atualizarDados(con, myConta);  // Atualiza os dados no banco de dados

            System.out.println("Depósito realizado com sucesso.");

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Problemas ao encerrar a conexão.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Depósito cancelado.");
        }
    }

    public void execConsulta() {
        System.out.println("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.println("Digite o Numero da Conta: ");
        int conta = leia.nextInt();

        Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta);

        // Conectar ao banco e selecionar os dados da conta
        ConexaoBancoDados conexPost = new ConexaoBancoDados();
        Connection con = conexPost.conectarBanco();
        SelecionaDados sel = new SelecionaDados();
        sel.selecionarDados(con, myConta);  // Buscar dados da conta

        myConta.imprimir();  // Imprimir os dados da conta

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Problemas ao encerrar a conexão.");
            e.printStackTrace();
        }
    }
}
