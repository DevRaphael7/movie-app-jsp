package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import models.Comentario;
import models.Filme;
import models.Serie;
import models.Usuarios;

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
        this.url = "jdbc:mysql://localhost:3306/dbfilmes";
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
  
                filmes.add( 
                    new Filme(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        generoDoFilme, 
                        rs.getString("cover"),
                        rs.getString("faixa_etaria").isEmpty() ? "" : rs.getString("faixa_etaria"), 
                        rs.getString("data_lancamento").isEmpty() ? "" : rs.getString("data_lancamento"),
                        rs.getString("sinopse"),
                        rs.getString("descricao")
                    )
                );
            }
            this.conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            filmes.clear();
        } 

        return filmes;
    }

    public ArrayList<String> getUniqueGenre(String type){
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<String> getGenerosDB = new ArrayList<>();

        String query = "SELECT genero FROM filmes GROUP BY genero";
        switch(type){
            case "mov":
                query = "SELECT genero FROM filmes GROUP BY genero";
            break;
            case "ser":
                query = "SELECT genero FROM series GROUP BY genero";
            break;
            default:
                query = "SELECT genero FROM filmes GROUP BY genero";
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                getGenerosDB.add(rs.getString("genero"));
            }

            for(String itemGetGeneroDB: getGenerosDB){
                String[] generos = itemGetGeneroDB.split(", ");

                for(String itemGeneros: generos){
                    if(genres.size() == 0){
                        genres.add(itemGeneros);
                        continue;
                    }

                    Boolean temOuNao = false;
                    int lengthGenres = genres.size();
                    while(lengthGenres > 0){
                        if(genres.get(lengthGenres - 1).equals(itemGeneros)){
                            temOuNao = true;
                            break;
                        }

                        lengthGenres--;
                    }

                    if(!temOuNao){
                        genres.add(itemGeneros);
                    }
                }
            }
            this.conn.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return genres;
    }

    public int getLoginDataBase(Usuarios user, String query){
        Usuarios userLogin = user;
        int validacao = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);
            
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                if(userLogin.getNome().equals(rs.getString("nome")) && userLogin.getPassword().equals(rs.getString("senha"))){
                    validacao = rs.getInt("id_usuario");
                }
            }

            this.conn.close();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return validacao;
    }

    public Usuarios getUserDB(Usuarios usuarioLogin) {
        Usuarios usuario = usuarioLogin;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuario WHERE nome = '" + usuario.getNome() + "' && senha = '" + usuario.getPassword() + "'");

            while(rs.next()){
                String avatar = rs.getString("avatar").isEmpty() ? "https://static.vecteezy.com/ti/vetor-gratis/p1/2275847-avatar-masculino-perfil-icone-de-homem-caucasiano-sorridente-vetor.jpg" : rs.getString("avatar");
                usuario.setAvatar(avatar);
                usuario.setNome(rs.getString("nome"));
                usuario.setPassword(rs.getString("senha"));
                usuario.setId(rs.getInt("id_usuario"));
            }
            conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return usuario;
    }

    public Boolean cadUser(Usuarios user){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            String values = "'" + user.getNome() + "', '" + user.getPassword() + "', '" + user.getAvatar() + "'";
        
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO usuario(nome, senha, avatar) VALUES (" + values + ")");
            
            conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    // public Serie(String nome, String[] genero, String faixaEtaria, String cover, String dataLancamento, String sinopse){
    public ArrayList<Serie> getSerie(String query){
        ArrayList<Serie> seriesLista = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                
                rs.getString("descricao");
                seriesLista.add(
                    new Serie(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero").split("-"),
                        rs.getString("faixa_etaria"),
                        rs.getString("cover"),
                        rs.getString("data_lancamento"),
                        rs.getString("sinopse"),
                        rs.getString("descricao")
                    )
                );
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return seriesLista;
    }

    public Boolean adicionarComentario(String comentario, int idUsuario, int idFilme) {
        Boolean cadComen = false;
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            String query = "INSERT INTO comentarios(id_usuario, id_filmes, titulo_comentario, conteudo_comentario) VALUES ("
            + idUsuario + ", " + idFilme + ",'" + comentario + "','comentario')";

            statement = conn.createStatement();
            statement.executeUpdate(query);
            
           cadComen = true;
           conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return cadComen;
    }

    public ArrayList<Comentario> obterComentarios(int idMov) {
        ArrayList<Comentario> listaComentarios = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            String query = "SELECT * FROM comentarios WHERE id_filmes = " + idMov;

            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()) {
                listaComentarios.add(new Comentario(
                    rs.getInt("id_comentario"),
                    rs.getInt("id_usuario"),
                    rs.getInt("id_filmes"),
                    rs.getString("titulo_comentario")
                ));
            }

           conn.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    
        return listaComentarios;
    }

    public Usuarios getUserById(int id){
        Usuarios user = new Usuarios();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

            String query = "SELECT * FROM usuario WHERE id_usuario = " + id;

            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()) {

                user = new Usuarios(
                    rs.getString("nome"),
                    rs.getString("senha"),
                    "email.com",
                    rs.getString("avatar")
                );

                user.setId(rs.getInt("id_usuario"));
            }

            conn.close();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }
}
