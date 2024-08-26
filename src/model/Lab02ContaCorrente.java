package model;

public class Lab02ContaCorrente {
    private int numAge;
    private int numConta;
    private String nome;
    private double saldo;

    // Método para sacar dinheiro
    public int saque(double pValor) {
        if (pValor > saldo) {
            return 0; // Saldo insuficiente
        } else {
            saldo -= pValor;
            return 1; // Saque realizado com sucesso
        }
    }

    // Método para depositar dinheiro
    public void deposito(double pValor) {
        saldo += pValor;
    }

    // Método para imprimir os dados da conta
    public void imprimir() {
        System.out.println("Número da Agência: " + numAge);
        System.out.println("Número da Conta: " + numConta);
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Saldo: " + saldo);
    }

    // Getters e setters para os atributos
    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setNumNome(String nome) {
        this.nome = nome;
    }

    public void setNumSaldo(double saldo) {
        this.saldo = saldo;
    }
}
