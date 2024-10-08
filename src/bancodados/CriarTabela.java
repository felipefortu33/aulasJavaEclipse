package bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {

    public void criarTabela(Connection con) {
        String tabela = "CREATE TABLE IF NOT EXISTS Banco ("
                + "codigo SERIAL PRIMARY KEY, "
                + "nome VARCHAR(30) NOT NULL, "
                + "agencia INT NOT NULL, "
                + "conta INT NOT NULL, "
                + "saldo NUMERIC NOT NULL, "
                + "CONSTRAINT agencia_conta_unique UNIQUE (agencia, conta)"
                + ")";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(tabela);
            System.out.println("Tabela Banco criada com sucesso.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Problemas na criação da tabela Banco.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        }
    }
}
