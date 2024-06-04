package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ControleDePilha extends JFrame{
    private JPanel uiPanel;
    private JButton BtnVip;
    private JButton BtnI80;
    private JButton BtnI60;
    private JButton BtnNml;
    private JButton BtnPfl;
    private JButton BtnUrg;
    private JButton BtnChamaProximo;
    private JLabel lblSuaSenha;
    private JLabel lblSenhaAtual;
    private JList listaSenhas;
    private JButton atenderButton;
    List<Pilha> pilhas = new ArrayList<>();

//   TODO: Colocar as cores nas senhas( Acho que pode ser usado ANSI CODE {ex: "\u001B[30m" -> vermelho} para isso)


    public ControleDePilha(){
        setContentPane(uiPanel);
        setTitle("Central de atendimento");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(820, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        Pilha pilhaUrgente = new Pilha(TipoLista.URGENTE);
        Pilha pilhaIdoso80 = new Pilha(TipoLista.IDOSO80);
        Pilha pilhaIdoso60 = new Pilha(TipoLista.IDOSO);
        Pilha pilhaPreferencial = new Pilha(TipoLista.PREFERENCIAL);
        Pilha pilhaVIP = new Pilha(TipoLista.VIP);
        Pilha pilhaNormal = new Pilha(TipoLista.NORMAL);

        // Cria lista contendo todas as pilhas
        pilhas.add(pilhaUrgente);
        pilhas.add(pilhaIdoso80);
        pilhas.add(pilhaIdoso60);
        pilhas.add(pilhaPreferencial);
        pilhas.add(pilhaVIP);
        pilhas.add(pilhaNormal);


        BtnUrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaUrgente.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });

        BtnI80.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaIdoso80.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });
        BtnI60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaIdoso60.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });
        BtnPfl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaPreferencial.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });
        BtnVip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaVIP.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });
        BtnNml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senhaAtual = pilhaNormal.inserir();
                lblSuaSenha.setText(senhaAtual);
            }
        });

        BtnChamaProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chamar Proxima senha
                String chamar = chamarProximaSenha(pilhaUrgente, pilhaIdoso80, pilhaIdoso60, pilhaPreferencial, pilhaVIP, pilhaNormal);
                lblSenhaAtual.setText(chamar);

                // Listar Senhas
                listaSenhas.setListData(listarChamadas(pilhas).lines().toArray());
            }
        });
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atenderProximaSenha();
            }
        });
    }

    public static void main(String[] args) {
        new ControleDePilha();
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
    private static String listarChamadas(List<Pilha> pilhas) {
        StringBuilder sb = new StringBuilder();
        for (Pilha pilha : pilhas) {
            sb.append(pilha.listar()).append("\n");

        }
        return sb.toString();
    }

    private void atenderProximaSenha() {
        for (Pilha pilha : pilhas) {
            String resultado = pilha.atender();
            if (!resultado.equals("Nenhuma senha para atender.")) {
                JOptionPane.showMessageDialog(this, resultado);
                listaSenhas.setListData(listarChamadas(pilhas).lines().toArray());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Nenhuma senha para atender.");
    }
}
