package main.Uis;

import javax.swing.*;

public class ControleDePilha extends JFrame{
    private JPanel uiPanel;
    private JButton BtnVip;
    private JButton BtnI80;
    private JButton BtnI60;
    private JButton BtnNml;
    private JButton BtnPfl;
    private JButton BtnUrg;
    private JButton BtnChamaProximo;
    private JLabel lblSenhaAtual;
    private JLabel lblSenhaAntiga1;
    private JLabel lblSenhaAntiga2;
    private JLabel lblSenhaAntiga3;
    private JLabel lblSuaSenha;

    public ControleDePilha(){
        setContentPane(uiPanel);
        setTitle("Central de atendimento");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ControleDePilha();
    }
}
