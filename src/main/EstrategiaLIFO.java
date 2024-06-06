package main;

/*
 * Autor         Prof. Marcos
 * Data          15/03/2024
 * Disciplina    Programação Orientada a Objetos
 */

public abstract class EstrategiaLIFO {
    //Define a classe abstrata 'main.EstrategiaLIFO' a partir do método LIFO

    public abstract String inserir();

    public abstract void remover();

    public abstract String chamar();

    public abstract String atender();

    public abstract String listar();
}
