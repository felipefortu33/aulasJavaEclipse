package aula01;

public class Aluno {
	private String nome;
	public void inserirNome(String nn ) {
		nome = nn;
	}
	public String recuperarNome() {
		return nome;
	}
	public static void main(String args[]) {
		Aluno a = new Aluno();
		a.inserirNome("Felipe");
		System.out.println("saida: "+a.recuperarNome());
	}

}
