/*
 * Disciplina: Programação Orientada a Objetos
 *
 * Autores: Gabriel Eduardo Alves da Silva ; RA: 196046
 *          Guilherme Cezarino Felioe ; RA: 195249
 *          Felipe Zamariolli Lacerda Guedes ; RA: 196239
 *
 * Atividade Final 3EC
 *
 * Data 13/06/2024
 */

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

    public Connection conectar() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        }catch (Exception e){
            throw new Exception(String.format("Erro ao conectar no banco\n Erro: %s", e));
        }
    }


}



