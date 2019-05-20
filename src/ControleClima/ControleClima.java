package ControleClima;

import ProjetoVanessa.Constantes;
import ProjetoVanessa.Janela;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class ControleClima extends JPanel implements Constantes {
    //https://www.flaticon.com/free-icon/flash-off_656434#term=light%20off&page=2&position=41 <- faltou baixar esse ícone!

    private static final long serialVersionUID = -3870078794436517340L;

    public static final int LARG = 800, ALTU = (LARG / 16) * 9, PAINEL_TOPO = 32;

    public static JFrame Frame;

    public static JLabel labelClose = new JLabel(new ImageIcon("res\\close.png"));

    public static JLabel labelMini = new JLabel(new ImageIcon("res\\mini1.png"));

    private ControleClimaMouse ccm;

    JWindow window;

    public ControleClima() {

        new PainelLateral(this);
        new PainelDashboard(this);

        ccm = new ControleClimaMouse();

        this.addMouseListener(ccm);
        this.addMouseMotionListener(ccm);

        inicarLabelsTopo();

        Frame = new JFrame();
        new Janela(Frame, this, "Simulação de climas e eventos", LARG, ALTU, JFrame.EXIT_ON_CLOSE, true);

        this.revalidate();
    }

    private void inicarLabelsTopo() {
        labelClose.setBounds(LARG - 26, 8, 18, 18);
        labelClose.addMouseListener(ccm);
        this.add(labelClose);
        labelMini.setBounds(LARG - 52, 8, 18, 18);
        labelMini.addMouseListener(ccm);
        this.add(labelMini);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.BLACK);
    }

}
