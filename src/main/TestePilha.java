package main;

public class TestePilha {
    public static void main(String[] args) {
        // Criando instâncias de Pilha para diferentes tipos de lista
        Pilha pilhaUrgente = new Pilha(TipoLista.URGENTE);
        Pilha pilhaIdoso80 = new Pilha(TipoLista.IDOSO80);
        Pilha pilhaIdoso60 = new Pilha(TipoLista.IDOSO);
        Pilha pilhaPreferencial = new Pilha(TipoLista.PREFERENCIAL);
        Pilha pilhaVip = new Pilha(TipoLista.VIP);
        Pilha pilhaNormal = new Pilha(TipoLista.NORMAL);

        // Inserindo senhas nas pilhas
        pilhaUrgente.inserir();
        pilhaIdoso80.inserir();
        pilhaIdoso80.inserir();
        pilhaIdoso60.inserir();
        pilhaPreferencial.inserir();
        pilhaPreferencial.inserir();
        pilhaVip.inserir();
        pilhaVip.inserir();
        pilhaNormal.inserir();
        pilhaNormal.inserir();
        pilhaNormal.inserir();

        // Chamar as senhas uma por uma, seguindo a ordem de prioridade global
        String chamada;
        do {
            chamada = chamarProximaSenha(pilhaUrgente, pilhaIdoso80, pilhaIdoso60, pilhaPreferencial, pilhaVip, pilhaNormal);
            System.out.println(chamada);
        } while (!chamada.equals("Nenhuma senha disponível."));
    }

    public static String chamarProximaSenha(Pilha... pilhas) {
        for (TipoLista tipo : getOrdemPrioridade()) {
            for (Pilha pilha : pilhas) {
                if (pilha.getTipoLista() == tipo) {
                    String chamada = pilha.chamar();
                    if (!chamada.equals("Nenhuma senha disponível.")) {
                        return chamada;
                    }
                }
            }
        }
        return "Nenhuma senha disponível.";
    }

    public static TipoLista[] getOrdemPrioridade() {
        return new TipoLista[]{TipoLista.URGENTE, TipoLista.IDOSO80, TipoLista.IDOSO, TipoLista.PREFERENCIAL, TipoLista.VIP, TipoLista.NORMAL};
    }
}
