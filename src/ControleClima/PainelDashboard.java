package ControleClima;

import ProjetoVanessa.Constantes;
import javax.swing.JPanel;

public class PainelDashboard extends PainelClima {

    private static final long serialVersionUID = -2664005652611754845L;

    public static final int LARG = (ControleClima.LARG / 16) * 12, ALTU = ControleClima.ALTU - ControleClima.PAINEL_TOPO;

    public PainelDashboard(JPanel panel) {
        super(Constantes.CINZAESC, PainelLateral.LARG, ControleClima.PAINEL_TOPO, LARG, ALTU, panel);
    }

    @Override
    public void construirTela() {
    }

}
