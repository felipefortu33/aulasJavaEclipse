package bancodados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoverTabela {

    public void removerTabela(Connection con) {
        String tabela = "DROP TABLE IF EXISTS Banco"; // Verifica se a tabela existe antes de remover
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            int ret = stmt.executeUpdate(tabela);
            System.out.println("Tabela removida com sucesso. ID Retorno: " + ret);
        } catch (SQLException e) {
            System.out.println("Problemas na remoção da tabela.");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("Código SQL: " + e.getSQLState());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar o Statement.");
                    e.printStackTrace();
                }
            }
        }
    }
}
