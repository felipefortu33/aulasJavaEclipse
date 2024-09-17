package bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaCCEspecial {

    public void criarTabela(Connection con) {
        String tabela = "CREATE TABLE IF NOT EXISTS BancoEspecial ("
                + "agencia INT NOT NULL, "
                + "conta INT NOT NULL, "
                + "limite NUMERIC NOT NULL, "
                + "PRIMARY KEY (agencia, conta), "
                + "CONSTRAINT fk_banco FOREIGN KEY (agencia, conta) "
                + "REFERENCES Banco (agencia, conta)"
                + ")";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(tabela);
            System.out.println("Tabela BancoEspecial criada com sucesso.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Problemas na criação da tabela BancoEspecial.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        }
    }
}
