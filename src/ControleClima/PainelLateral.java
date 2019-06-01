package ControleClima;

import ProjetoVanessa.Constantes;
import javax.swing.JPanel;

public class PainelLateral extends PainelClima {

    private static final long serialVersionUID = -2271353278551313357L;

    public static final int LARG = (ControleClima.LARG / 16) * 4, ALTU = ControleClima.ALTU;

    public PainelLateral(JPanel panel) {
        super(Constantes.CINZATOPO, 0, 0, LARG, ALTU, panel);
    }

    @Override
    protected void construirTela() {
    }

    

    

}
