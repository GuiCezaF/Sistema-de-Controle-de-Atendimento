/*
 * Disciplina: Programação Orientada a Objetos
 *
 * Autores: Gabriel Eduardo Alves da Silva ; RA: 196046
 *          Guilherme Cezarino Felioe ; RA: 195249
 *          Felipe Zamariolli Lacerda Guedes ; RA: 196239
 *
 * Atividade Final 3EC
 *
 * Data 13/06/2024
 */

package main.Uis;

import main.Pilha;
import main.TipoLista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerarSenha extends JFrame {
    private JPanel uiPanelGerarSenha;
    private JButton BtnI80;
    private JButton BtnNML;
    private JButton BtnPFL;
    private JButton BtnURG;
    private JButton BtnVIP;
    private JButton BtnI60;
    private JLabel lblSenha;

    public GerarSenha(){
        setContentPane(uiPanelGerarSenha);
        setTitle("Gerador de senhas");
        setSize(650, 300);
        setLocationRelativeTo(null);
        setVisible(true);


        BtnI60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaIdoso60 = new Pilha(TipoLista.IDOSO);

                lblSenha.setText(pilhaIdoso60.inserir());
            }
        });
        BtnI80.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaIdoso80 = new Pilha(TipoLista.IDOSO80);

                lblSenha.setText(pilhaIdoso80.inserir());
            }
        });
        BtnNML.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaNormal = new Pilha(TipoLista.NORMAL);

                lblSenha.setText(pilhaNormal.inserir());
            }
        });
        BtnPFL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaPref = new Pilha(TipoLista.PREFERENCIAL);

                lblSenha.setText(pilhaPref.inserir());
            }
        });
        BtnURG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaUrg = new Pilha(TipoLista.URGENTE);

                lblSenha.setText(pilhaUrg.inserir());
            }
        });
        BtnVIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pilha pilhaVIP = new Pilha(TipoLista.VIP);

                lblSenha.setText(pilhaVIP.inserir());
            }
        });
    }

    public static void main(String[] args) {
        new GerarSenha();
    }
}
