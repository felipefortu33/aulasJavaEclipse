package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import bancodados.AtualizaDados;
import bancodados.ConexaoBancoDados;
import bancodados.InsereDados;
import bancodados.InsereDadosCCEspecial;
import bancodados.SelecionaDados;
import bancodados.SelecionaDadosCCEspecial;
import model.Lab03ContaCorrenteBancoDados;
import model.Lab05ContaCorrenteEspecial;

public class Lab05SistemaBancoDados {
    private Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        new Lab05SistemaBancoDados().executarLab();
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
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        leia.close();
    }

    public void execCadastramento() {
        System.out.print("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.print("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Digite o Nome do Cliente: ");
        String nome = leia.next();
        System.out.print("Digite o Saldo: ");
        double saldo = leia.nextDouble();
        double limite = 0.0;

        if (agencia >= 5000) {
            System.out.print("Digite o limite: ");
            limite = leia.nextDouble();
        }

        System.out.print("Confirma cadastramento(S/N): ");
        String cad = leia.next();
        if (cad.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta, nome, saldo);
            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            InsereDados ins = new InsereDados();
            Connection con = null;
            try {
                con = conexPost.conectarBanco();
                ins.inserirDados(con, myConta);
                if (agencia >= 5000) {
                    Lab05ContaCorrenteEspecial cEsp = new Lab05ContaCorrenteEspecial(agencia, conta, nome, saldo, limite);
                    InsereDadosCCEspecial insE = new InsereDadosCCEspecial();
                    insE.inserirDados(con, cEsp);
                }
                System.out.println("Cadastro realizado com sucesso.");
            } catch (Exception e) {
                System.out.println("Problemas ao conectar com o banco de dados.");
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Problemas ao encerrar a conexão.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void execSaque() {
        System.out.print("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.print("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Digite o valor do saque: ");
        double val = leia.nextDouble();
        System.out.print("Confirma saque(S/N): ");
        String saq = leia.next();
        if (saq.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = agencia >= 5000 
                ? new Lab03ContaCorrenteBancoDados(agencia, conta) 
                : new Lab05ContaCorrenteEspecial(agencia, conta);

            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            SelecionaDados sel = new SelecionaDados();
            Connection con = null;
            try {
                con = conexPost.conectarBanco();
                sel.selecionarDados(con, myConta);
                System.out.println("Saldo atual: " + myConta.getSaldo());

                int ret = myConta.sacar(val);

                if (ret == 1) {
                    AtualizaDados atu = new AtualizaDados();
                    atu.atualizarDados(con, myConta);
                    System.out.println("Saque realizado com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } catch (Exception e) {
                System.out.println("Problemas ao conectar com o banco de dados.");
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Problemas ao encerrar a conexão.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void execDeposito() {
        System.out.print("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.print("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        System.out.print("Digite o valor de deposito: ");
        double val = leia.nextDouble();
        System.out.print("Confirma deposito(S/N): ");
        String dep = leia.next();
        if (dep.equalsIgnoreCase("s")) {
            Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta);
            ConexaoBancoDados conexPost = new ConexaoBancoDados();
            SelecionaDados sel = new SelecionaDados();
            Connection con = null;
            try {
                con = conexPost.conectarBanco();
                sel.selecionarDados(con, myConta);
                System.out.println("Saldo atual: " + myConta.getSaldo());
                myConta.deposito(val);
                AtualizaDados atu = new AtualizaDados();
                atu.atualizarDados(con, myConta);
                System.out.println("Deposito realizado com sucesso.");
            } catch (Exception e) {
                System.out.println("Problemas ao conectar com o banco de dados.");
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Problemas ao encerrar a conexão.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void execConsulta() {
        System.out.print("Digite o Numero da Agencia: ");
        int agencia = leia.nextInt();
        System.out.print("Digite o Numero da Conta: ");
        int conta = leia.nextInt();
        Lab03ContaCorrenteBancoDados myConta = new Lab03ContaCorrenteBancoDados(agencia, conta);
        ConexaoBancoDados conexPost = new ConexaoBancoDados();
        SelecionaDados sel = new SelecionaDados();
        Connection con = null;
        try {
            con = conexPost.conectarBanco();
            sel.selecionarDados(con, myConta);

            SelecionaDadosCCEspecial selE = new SelecionaDadosCCEspecial();
            selE.selecionarDados(con, new Lab05ContaCorrenteEspecial(agencia, conta));

            System.out.println("Consulta realizada com sucesso.");
        } catch (Exception e) {
            System.out.println("Problemas ao conectar com o banco de dados.");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println("Problemas ao encerrar a conexão.");
                    e.printStackTrace();
                }
            }
        }
    }
}
