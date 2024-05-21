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
            public void actionPerformed(ActionEvent actionEvent) {
                new ChamarProximaSenha();
            }
        });
    }

    public static void main(String[] args) {
        new Atendimento();
    }
}
