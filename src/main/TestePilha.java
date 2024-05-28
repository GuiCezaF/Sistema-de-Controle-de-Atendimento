package main;

import java.util.ArrayList;
import java.util.List;

public class TestePilha {
    public static void main(String[] args) {
        List<Pilha> pilhas = new ArrayList<>();

        // Criando instâncias de Pilha para diferentes tipos de lista
        Pilha pilhaUrgente = new Pilha(TipoLista.URGENTE);
        Pilha pilhaIdoso80 = new Pilha(TipoLista.IDOSO80);
        Pilha pilhaIdoso60 = new Pilha(TipoLista.IDOSO);
        Pilha pilhaPreferencial = new Pilha(TipoLista.PREFERENCIAL);
        Pilha pilhaVip = new Pilha(TipoLista.VIP);
        Pilha pilhaNormal = new Pilha(TipoLista.NORMAL);

        pilhas.add(pilhaUrgente);
        pilhas.add(pilhaIdoso80);
        pilhas.add(pilhaIdoso60);
        pilhas.add(pilhaPreferencial);
        pilhas.add(pilhaVip);
        pilhas.add(pilhaNormal);




        // Inserindo senhas nas pilhas
        pilhaUrgente.inserir();
        pilhaUrgente.inserir();
        pilhaUrgente.inserir();
        pilhaNormal.inserir();
        pilhaIdoso80.inserir();
        pilhaIdoso80.inserir();
        pilhaIdoso60.inserir();
        pilhaPreferencial.inserir();
        pilhaPreferencial.inserir();
        pilhaVip.inserir();
        pilhaVip.inserir();
        pilhaNormal.inserir();
        pilhaNormal.inserir();
        String chamada = chamarProximaSenha(pilhaUrgente, pilhaIdoso80, pilhaIdoso60, pilhaPreferencial, pilhaVip, pilhaNormal);

        System.out.println(chamada);

        System.out.println(pilhaNormal.listar());
        System.out.println(listarChamadas(pilhas));



        // Chamar as senhas uma por uma, seguindo a ordem de prioridade global
//       String chamada;
//          chamada = chamarProximaSenha(pilhaUrgente, pilhaIdoso80, pilhaIdoso60, pilhaPreferencial, pilhaVip, pilhaNormal);
//      do {
//          System.out.println(chamada);
//      } while (!chamada.equals("Nenhuma senha disponível."));
   }
   private static String listarChamadas(List<Pilha> pilhas) {
        StringBuilder sb = new StringBuilder();
        for (Pilha pilha : pilhas) {
            sb.append("Prioridade ").append(pilha.getTipoLista().tipo).append(":\n");
            sb.append(pilha.listar());
        }
        return sb.toString();
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

