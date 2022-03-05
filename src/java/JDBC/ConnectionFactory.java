package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import models.Filme;

/**
 *
 * @author rapha
 */
public class ConnectionFactory {

    private Connection conn;
    private String excecao;
    private Statement statement;
    private ResultSet rs;

    private String user;
    private String password;
    private String url;

    public ConnectionFactory() {
        this.user = "raphael";
        this.password = "159357Sql@";
        this.url = "jdbc:mysql://localhost:3306/mov";
    }

    public ConnectionFactory(String url, String user, String password){
        this.user = user;
        this.password = password;
        this.url = url;
    }
    
    public ArrayList<Filme> getMoviesDataBase(String query) {
        ArrayList<Filme> filmes = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                String[] generoDoFilme = rs.getString("genero").split(",");

                filmes.add( new Filme(rs.getString("nome"), generoDoFilme, rs.getString("cover"), rs.getString("faixarEtaria"), rs.getString("dataLanc")));
            }
            this.conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            filmes.clear();
        } 

        return filmes;
    }

    public String[] getUniqueGenre(){
        String[] generos = new String[10];
        String query = "SELECT SUBSTRING_INDEX(genero, ',', -1) as generosFilm FROM filmes GROUP BY genero;";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            int ind = 0;
            while(rs.next()){
                System.out.println(rs.getString("generosFilm"));

                generos[ind] = rs.getString("generosFilm");

                if(ind == generos.length - 1){
                    break;
                }

                ind++;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return generos;
    }
}
