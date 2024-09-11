package model;

public class Lab03ContaCorrenteBancoDados {
    
    // Atributos privados da conta corrente
    private int numAge;  // Número da agência
    private int numConta;  // Número da conta
    private String nome;  // Nome do cliente
    private double saldo;  // Saldo da conta

    // Construtor para criar a conta com agência e número da conta (para consulta, saque e depósito)
    public Lab03ContaCorrenteBancoDados(int ag, int cta) {
        this.numAge = ag;
        this.numConta = cta;
    }

    // Construtor completo para cadastramento da conta
    public Lab03ContaCorrenteBancoDados(int ag, int ca, String nome, double saldo) {
        this.numAge = ag;
        this.numConta = ca;
        this.nome = nome;
        this.saldo = saldo;
    }

    // Método para sacar dinheiro da conta
    public int sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return 1;  // Sucesso no saque
        }
        return 0;  // Falha no saque (saldo insuficiente)
    }

    // Método para realizar depósito na conta
    public void deposito(double valor) {
        this.saldo += valor;
    }

    // Método para imprimir os dados da conta
    public void imprimir() {
        System.out.println("Imprimindo seu Extrato:");
        System.out.println("Agencia: " + this.numAge);
        System.out.println("Conta: " + this.numConta);
        System.out.println("Nome: " + this.nome);
        System.out.println("Saldo: " + this.saldo);
    }

    // Getters e Setters para acessar e modificar os atributos da conta

    public int getNumAge() {
        return numAge;
    }

    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
