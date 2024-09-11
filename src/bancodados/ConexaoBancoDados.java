package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe para gerenciar a conexão com o banco de dados
public class ConexaoBancoDados {
    
    public Connection conectarBanco() {
        try {
            // Carregar o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // URL de conexão com o banco de dados
            String url = "jdbc:postgresql://localhost:5432/postgres";
            
            // Criar a conexão (substituir "12345" pela senha correta do seu banco de dados)
            Connection con = DriverManager.getConnection(url, "postgres", "root");
            
            // Retornar a conexão estabelecida
            return con;
        } catch (ClassNotFoundException e) {
            // Erro ao carregar o driver do PostgreSQL
            System.out.println("Driver do PostgreSQL não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro ao estabelecer a conexão com o banco de dados
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
        
        // Retornar null caso ocorra algum erro na conexão
        return null;
    }
}
