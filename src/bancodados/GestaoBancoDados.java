package bancodados;
import java.sql.Connection;
import java.sql.SQLException;
import model.Lab03ContaCorrente;
import model.Lab03ContaCorrenteBancoDados;
public class GestaoBancoDados {
	public static void main(String[] args) {
		ConexaoBancoDados objLocal = new ConexaoBancoDados();
		Connection conex = objLocal.conectarBanco();
		if (conex != null) {
			System.out.println("Conectado com sucesso no Postgree.");
			CriarTabela cr = new CriarTabela();
			CriarTabelaCCEspecial cre = new CriarTabelaCCEspecial();
			RemoverTabela rem = new RemoverTabela();
			InsereDados ins = new InsereDados();
			SelecionaDados sel = new SelecionaDados();
			try {
				//cre.criarTabela(conex);
				//rem.removerTabela(conex);
				//cr.criarTabela(conex);
				//ins.inserirDados(conex, 
				//		new Lab03ContaCorrente(10,400,"Douglas Mendes",100.50));
//				sel.selecionarDados(conex, 
//						new Lab03ContaCorrenteBancoDados(10,400));
				
				conex.close();
				System.out.println("Conexão encerrada com sucesso.");
			} catch (SQLException e) {
				System.out.println("Problemas para encerrar a conexão.");
				e.printStackTrace();
			}
		}
	}
}