package bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {

    public void criarTabela(Connection con) {
        String tabela = "CREATE TABLE IF NOT EXISTS Banco (" +
                        "codigo serial PRIMARY KEY, " +
                        "nome varchar(30) NOT NULL, " +
                        "agencia int NOT NULL, " +
                        "conta int NOT NULL, " +
                        "saldo numeric NOT NULL, " +
                        "PRIMARY KEY (agencia, conta))";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(tabela);
            System.out.println("Tabela criada com sucesso.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Problemas na criação da tabela.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        }
    }
}
