package main;
/*
 * Autor         Prof. Marcos
 * Data          15/03/2024
 * Disciplina    Programação Orientada a Objetos
 */

public enum TipoLista {
    //Define o enum main.TipoLista
    IDOSO("I60"),
    IDOSO80("I80"),
    NORMAL("NML"),
    PREFERENCIAL("PFL"),
    URGENTE("URG"),
    VIP("VIP");

    protected String tipo;

    TipoLista(String tipo){
        this.tipo = tipo.toUpperCase();
    }
}
