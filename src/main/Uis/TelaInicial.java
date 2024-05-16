package main.Uis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame{
    private JButton BtnSenha;
    private JButton BtnPainelSenha;
    private JButton BtnAtend;
    private JPanel uiPanelTelaInicial;

    public TelaInicial(){
        setContentPane(uiPanelTelaInicial);
        setTitle("Central de atendimento");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(660, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        BtnSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerarSenha();
            }
        });
        BtnPainelSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PainelSenhas();
            }
        });
        BtnAtend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atendimento();
            }
        });
    }

    public static void main(String[] args) {
        new TelaInicial();
    }
}
