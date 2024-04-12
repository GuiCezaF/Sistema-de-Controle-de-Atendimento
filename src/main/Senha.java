package main;

/*
 * Autor         Prof. Marcos
 * Data          15/03/2024
 * Disciplina    Programação Orientada a Objetos
 */
public class Senha {
    //Define a classe 'main.Senha'
    private static int ultimoNumero = 0;          //Registra o último número de senha para
                                                  // objetos da classe - atributo de classe
    private int numero = 0;                       //Registra o número de uma senha específica
    private boolean chamado = false;              //Registra o chamado da senha
    public void gerarSenha() {                    //Gera um número para a senha
        ultimoNumero++;
        this.numero = ultimoNumero;
    }
    public String retornarSenha() {               //Retorna o número da senha formatado
        if(this.chamado)
            return String.format("%04d", this.numero) + "*";
        return String.format("%04d", this.numero);
    }
    public boolean getChamado(){
        return this.chamado;
    }
    public void setChamado(){
        this.chamado = true;
    }
}
