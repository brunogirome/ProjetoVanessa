package ProjetoVanessa;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Janela {

    int xx, xy;

    public Janela(Container painel, String titulo, int altura, int largura, int closeOP) {

        JFrame frame = new JFrame(titulo);

        Dimension tamanho = new Dimension(altura, largura);
        painel.setMinimumSize(tamanho);
        painel.setMaximumSize(tamanho);
        painel.setPreferredSize(tamanho);

        painel.setLayout(new GridLayout(1, 1));

        frame.setDefaultCloseOperation(closeOP);
        frame.setResizable(false);
        frame.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Janela(JFrame frame, Container painel, String titulo, int altura, int largura, int closeOP, boolean undecorated) {

        frame.setTitle(titulo);
        frame.setUndecorated(undecorated);

        Dimension tamanho = new Dimension(altura, largura);
        painel.setMinimumSize(tamanho);
        painel.setMaximumSize(tamanho);
        painel.setPreferredSize(tamanho);

        painel.setLayout(new GridLayout(1, 1));

        frame.setDefaultCloseOperation(closeOP);
        frame.setResizable(false);
        frame.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
