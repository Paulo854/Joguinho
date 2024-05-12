package jogoA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class verificabanco {
    private String nomeMelhor;
    private double scoreMelhor;
    
    public String getNomeDoScore() {
        try {
            // Conexão com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://us-cluster-east-01.k8s.cleardb.net:3306/heroku_f9bf39b8613908b", "bc62cb06767181", "1cea70b3");
            String consulta = "select userName, score from pontuacao order by score desc";
            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.nomeMelhor = resultado.getString("userName"); // Corrigido para "userName"
            }
            resultado.close();
            stmt.close();
            conexão.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado");
            e.printStackTrace();
        }
        return this.nomeMelhor;
    }
    
    public double getMelhorScore() {
        try {
            // Conexão com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://us-cluster-east-01.k8s.cleardb.net:3306/heroku_f9bf39b8613908b", "bc62cb06767181", "1cea70b3");
            String consulta = "select userName, score from pontuacao order by score desc";

            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.scoreMelhor = resultado.getDouble("score");
            }
            resultado.close();
            stmt.close();
            conexão.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado");
            e.printStackTrace();
        }
        return this.scoreMelhor;
    }
}
