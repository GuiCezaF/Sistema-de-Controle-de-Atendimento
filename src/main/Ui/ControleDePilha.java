package main.Ui;

import main.Pilha;
import main.TipoLista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList list1;

    public ControleDePilha(){
        setContentPane(uiPanel);
        setTitle("Central de atendimento");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setVisible(true);

        Pilha pilhaUrgente = new Pilha(TipoLista.URGENTE);
        Pilha pilhaIdoso80 = new Pilha(TipoLista.IDOSO80);
        Pilha pilhaIdoso60 = new Pilha(TipoLista.IDOSO);
        Pilha pilhaPreferencial = new Pilha(TipoLista.PREFERENCIAL);
        Pilha pilhaVIP = new Pilha(TipoLista.VIP);
        Pilha pilhaNormal = new Pilha(TipoLista.NORMAL);


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
                String chamar = chamarProximaSenha(pilhaUrgente, pilhaIdoso80, pilhaIdoso60, pilhaPreferencial, pilhaVIP, pilhaNormal);
                lblSenhaAtual.setText(chamar);

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
}
