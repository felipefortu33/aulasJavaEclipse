package bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Lab03ContaCorrenteBancoDados;

public class SelecionaDados {

    public void selecionarDados(Connection con, Lab03ContaCorrenteBancoDados banco) {
        String query = "SELECT nome, agencia, conta, saldo FROM Banco WHERE agencia = ? AND conta = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, banco.getNumAge());
            stmt.setInt(2, banco.getNumConta());

            try (ResultSet ret = stmt.executeQuery()) {
                if (ret.next()) {
                    // Exibir e atualizar os dados da conta
                    System.out.println("Dados selecionados:");
                    System.out.println("Agencia: " + ret.getInt("agencia"));
                    System.out.println("Conta: " + ret.getInt("conta"));
                    System.out.println("Nome: " + ret.getString("nome"));
                    System.out.println("Saldo: " + ret.getDouble("saldo"));

                    // Atualizando o objeto
                    banco.setNome(ret.getString("nome"));
                    banco.setSaldo(ret.getDouble("saldo"));
                } else {
                    System.out.println("Nenhum dado encontrado para os parâmetros informados.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Problemas na consulta dos dados.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        }
    }
}
