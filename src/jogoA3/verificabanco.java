package jogoA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class verificabanco {
    private String primerioNome;
    private double primeiroScore;
    private String segundoNome;
    private double segundoScore;
    private String terceiroNome;
    private double terceiroScore;
    
    
    public String getNomePrimeiro() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc";
            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.primerioNome = resultado.getString("userName"); 
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
        return this.primerioNome;
    }
    
    public String getSegundoNome() {
        try {
            // Conexão com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc LIMIT 1 OFFSET 1";
            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.segundoNome = resultado.getString("userName"); 
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
        return this.segundoNome;
    }
    
    public String getTerceiroNome() {
        try {
            // Conexão com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc LIMIT 1 OFFSET 2";
            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.terceiroNome = resultado.getString("userName"); 
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
        return this.terceiroNome;
    }
    
    public double getPrimeiroScore() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc";

            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.primeiroScore = resultado.getDouble("score");
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
        return this.primeiroScore;
    }
    public double getSegundoScore() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc LIMIT 1 OFFSET 1";

            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.segundoScore = resultado.getDouble("score");
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
        return this.segundoScore;
    }
    public double getTerceiroScore() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String consulta = "select userName, score from pontuacao order by score desc LIMIT 1 OFFSET 2";

            PreparedStatement stmt = conexão.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                this.terceiroScore = resultado.getDouble("score");
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
        return this.terceiroScore;
    }
    public void setBanco(String nome, double score) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexão = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10709481", "sql10709481", "rWEXPguNrN");
            String inserir = "INSERT INTO pontuacao (userName, score, date) VALUES (?, ?, NOW())";
            PreparedStatement stmt = conexão.prepareStatement(inserir);

           
            stmt.setString(1, nome);
            stmt.setDouble(2, score);

           
            int linhasAfetadas = stmt.executeUpdate();
            
           
            stmt.close();
            conexão.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
