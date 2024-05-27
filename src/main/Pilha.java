package main;

import java.util.LinkedList;

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
        Senha senha = getNextSenha();
        if (senha != null) {
            senha.setChamado();
            pilha.remove(senha);
            return String.format("%s | Senha: %s", tipoLista.tipo, senha.retornarSenha());
        }
        return "Nenhuma senha disponível.";
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

    public TipoLista getTipoLista() {
        return this.tipoLista;
    }

    private Senha getNextSenha() {
        for (Senha senha : pilha) {
            if (!senha.getChamado()) {
                return senha;
            }
        }
        return null;
    }
}
