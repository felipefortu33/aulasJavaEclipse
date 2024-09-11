package bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Lab03ContaCorrenteBancoDados;

public class InsereDados {

    public void inserirDados(Connection con, Lab03ContaCorrenteBancoDados banco) {
        String ins = "INSERT INTO banco (nome, agencia, conta, saldo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(ins)) {
            stmt.setString(1, banco.getNome());
            stmt.setInt(2, banco.getNumAge());
            stmt.setInt(3, banco.getNumConta());
            stmt.setDouble(4, banco.getSaldo());
            stmt.execute();
            System.out.println("Dados inseridos com sucesso.");
        } catch (SQLException e) {
            System.out.println("Problemas na inserção dos dados.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        }
    }
}
