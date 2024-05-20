package main;

import java.util.LinkedList;
import java.util.ListIterator;

public class Pilha extends EstrategiaLIFO {

    protected LinkedList<Senha> pilha;
    private TipoLista tipoLista;

    public Pilha(TipoLista tipoLista) {
        this.pilha = new LinkedList<>();
        this.tipoLista = tipoLista;
    }

    @Override
    public String inserir() {
        Senha senha = new Senha();
        senha.gerarSenha();
        pilha.push(senha);
        return String.format(" %s - %s ", tipoLista.tipo, senha.retornarSenha());
    }

    @Override
    public void remover() {
        if (!pilha.isEmpty()) {
            pilha.pop();
        }
    }

    @Override
    public String chamar() {
        if (pilha.isEmpty()) {
            return "";
        }

        Senha senhaPrioritaria = null;
        ListIterator<Senha> iterator = pilha.listIterator(pilha.size());
        while (iterator.hasPrevious()) {
            Senha senha = iterator.previous();
            if (senhaPrioritaria == null || compararPrioridade(senhaPrioritaria, senha) > 0) {
                senhaPrioritaria = senha;
            }
        }

        if (senhaPrioritaria != null) {
            senhaPrioritaria.setChamado();
            pilha.remove(senhaPrioritaria);
            return String.format("%s | Senha: %s", tipoLista.tipo, senhaPrioritaria.retornarSenha());
        }

        return "";
    }

    private int compararPrioridade(Senha s1, Senha s2) {
        return getPrioridade(s1).compareTo(getPrioridade(s2));
    }

    private Integer getPrioridade(Senha senha) {
        switch (tipoLista.tipo) {
            case "URG":
                return 1;
            case "I80":
                return 2;
            case "I60":
                return 3;
            case "PFL":
                return 4;
            case "VIP":
                return 5;
            case "NML":
                return 6;
            default:
                return Integer.MAX_VALUE;
        }
    }

    @Override
    public String atender() {
        remover();
        return "Atendido";
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        for (Senha senha : pilha) {
            sb.append(tipoLista.tipo).append(" ").append(senha.retornarSenha()).append("\n");
        }
        return sb.toString();
    }
}
