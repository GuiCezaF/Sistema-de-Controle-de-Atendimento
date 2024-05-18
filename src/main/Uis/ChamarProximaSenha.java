package main.Uis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ChamarProximaSenha extends JFrame {
    private JButton BtnSim;
    private JButton BtnNao;
    private JPanel uiProximo;
    private Consumer<String> callback;

    public ChamarProximaSenha() {
        setContentPane(uiProximo);
        setTitle("Chamar Próximo");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        BtnSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                callback.accept("Nova senha");
            }
        });
        BtnNao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public void setCallback(Consumer<String> callback) {
        this.callback = callback;
    }

    public static void main(String[] args) {
        new ChamarProximaSenha();
    }
}
