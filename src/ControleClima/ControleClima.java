package ControleClima;

import ProjetoVanessa.Janela;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControleClima extends JPanel {

    public ControleClima() {
        this.setLayout(null);
        new CCAndroid(this);
        new PainelArea(this);

        new Janela(this, "Painel de Control de Dados", 640, 360, JFrame.EXIT_ON_CLOSE, null);

    }

}
