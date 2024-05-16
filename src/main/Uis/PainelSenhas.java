package main.Uis;

import javax.swing.*;

public class PainelSenhas extends JFrame{
    private JPanel PainelSenhaAt;
    private JLabel lblSenhaAntiga3;
    private JLabel lblSenhaAntiga2;
    private JLabel lblSenhaAntiga1;
    private JPanel PainelSenhaAntiga;
    private JLabel lblSenhaAtual;
    private JPanel uiPanelPainelSenhas;

    public PainelSenhas(){
        setContentPane(uiPanelPainelSenhas);
        setTitle("Painel de senhas");
        setSize(700, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PainelSenhas();
    }
}
