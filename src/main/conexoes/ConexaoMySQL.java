package main.conexoes;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {
    Dotenv dotenv = Dotenv.load(); // Carrega o arquivo .env na raiz do projeto
    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = dotenv.get("MYSQL_URL");
    private String user = dotenv.get("MYSQL_USER");
    private String password = dotenv.get("MYSQL_PASSWORD");

    public Connection conectar(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


}



