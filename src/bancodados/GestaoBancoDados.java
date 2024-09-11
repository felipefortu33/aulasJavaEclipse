package bancodados;
import java.sql.Connection;
import java.sql.SQLException;

import model.Lab03ContaCorrenteBancoDados;

public class GestaoBancoDados {
    public static void main(String[] args) {
        ConexaoBancoDados objLocal = new ConexaoBancoDados();
        Connection conex = objLocal.conectarBanco();
        if (conex != null) {
            System.out.println("Conectado com sucesso no PostgreSQL.");
            CriarTabela cr = new CriarTabela();
            try {
                // Cria a tabela
                cr.criarTabela(conex);

                // Teste de inserção de dados
                InsereDados ins = new InsereDados();
                ins.inserirDados(conex, new Lab03ContaCorrenteBancoDados(3387, 1404, "Felipe", 1000));

                // Outros testes ou operações
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conex.close();
                    System.out.println("Conexão encerrada com sucesso.");
                } catch (SQLException e) {
                    System.out.println("Problemas ao encerrar a conexão.");
                    e.printStackTrace();
                }
            }
        }
    }
}
