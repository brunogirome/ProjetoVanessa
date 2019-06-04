package ControleClima;

import ProjetoVanessa.Janela;
import ProjetoVanessa.TipoEventos;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControleClima extends JPanel {

    public ControleClima() {
        this.setLayout(null);
        new CCAndroid(this);
        new PaineisAdd(this, 185, new String[]{"Chuva", "Tempestade", "Alagamento"}, new TipoEventos[]{TipoEventos.chuva, TipoEventos.tempestade, TipoEventos.alagamento}, 0);
        new PaineisAdd(this, 412, new String[]{"Queda de Ávore", "Queda de Poste", "Acidente", "Queda de Luz"}, new TipoEventos[]{TipoEventos.qArvore, TipoEventos.qPoste, TipoEventos.acidente, TipoEventos.qLuz}, 1);

<<<<<<< HEAD
        new Janela(this, "Painel de Control de Dados", 640, 195, JFrame.EXIT_ON_CLOSE, null);
=======
        new Janela(this, "Painel de Control de Dados", 640, 360, JFrame.EXIT_ON_CLOSE, null);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178

    }

}
