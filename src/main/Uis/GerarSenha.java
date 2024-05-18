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
                Pilha pilhaIdoso = new Pilha(TipoLista.IDOSO);

                lblSenha.setText(pilhaIdoso.inserir());
            }
        });
        BtnI80.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnNML.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnPFL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnURG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BtnVIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new GerarSenha();
    }
}
