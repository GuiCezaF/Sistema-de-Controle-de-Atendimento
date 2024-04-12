package main;

/*
 * Disciplina Programação Orientada a Objetos
 * Guilherme Cezarino Felipe RA 195249
 * Gabriel Eduardo Alves da Silva RA 196046
 * Felipe Zamariolli Lacerda Guedes RA 196239
 * Atividade Final 3EC
 * Data 13/06/2024
 */

public abstract class EstrategiaLIFO {
    //Define a classe abstrata 'main.EstrategiaLIFO' a partir do método LIFO

    public abstract String inserir();

    public abstract void remover();

    public abstract String chamar();

    public abstract String atender();

    public abstract String listar();
}
