package aula01;

import java.util.Random;

public class Aluno {
    // Atributos
    private String nome;
    private int idade;
    private long codigo_identificador;
    private Random aleatorio;
    
    // Construtor
    public Aluno(String nome, int idade) {
        aleatorio = new Random();
        this.nome = nome;
        this.idade = idade;
        this.codigo_identificador = aleatorio.nextLong(); // Gera um identificador long
    }
    
    // Métodos
    public void definirNome(String nome) {
        this.nome = nome;
    }
    
    public void definirIdade(int idade) {
        this.idade = idade;
    }
    
    // Método main para testar a classe
    public static void main(String[] args) {
        Aluno aluno = new Aluno("João", 20);
        System.out.println("Nome: " + aluno.nome);
        System.out.println("Idade: " + aluno.idade);
        System.out.println("Código Identificador: " + aluno.codigo_identificador);
    }
}





