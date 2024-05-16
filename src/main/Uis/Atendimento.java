package main.Uis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atendimento extends JFrame{
    private JButton simButton;
    private JPanel uiAtendimento;

    public Atendimento() {
        setContentPane(uiAtendimento);
        setTitle("Atendimento");
        setSize(430, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        simButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new Atendimento();
    }
}
