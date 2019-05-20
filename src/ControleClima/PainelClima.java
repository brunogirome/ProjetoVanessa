package ControleClima;

import javax.swing.JPanel;

import java.awt.Color;

public abstract class PainelClima extends JPanel  {

    private static final long serialVersionUID = 2264041920250958167L;

    public static int x, y, width, height;

    public PainelClima(Color color, int x, int y, int width, int height, JPanel panel) {
        PainelClima.x = x;
        PainelClima.y = y;
        PainelClima.width = width;
        PainelClima.height = height;

        construirTela();

        gerarTela(color, panel);

    }

    private void gerarTela(Color color, JPanel panel) {
        this.setLayout(null);
        this.setBackground(color);
        this.setBounds(PainelClima.x, PainelClima.y, PainelClima.width, PainelClima.height);
        panel.add(this);
    }

    protected abstract void construirTela();

}
