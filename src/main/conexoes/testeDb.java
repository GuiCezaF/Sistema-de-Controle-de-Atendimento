package main.conexoes;

import java.sql.Connection;

public class testeDb {
    public static void main(String[] args) {
        status();

    }

    private static void status(){
        Connection con;
        ConexaoMySQL db = new ConexaoMySQL();
        try {
            con = db.conectar();
            if(con == null){
                System.out.println("Erro de Conexão!");
            }else {
                System.out.println("Banco conectado...");
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
