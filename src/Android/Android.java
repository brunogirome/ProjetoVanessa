package Android;

import ProjetoVanessa.Control;
import ProjetoVanessa.Janela;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Android extends JPanel {

    private static final long serialVersionUID = 4801318033194283596L;

    public static JDesktopPane Ambiente;

    public static final int LARGURA = 300, ALTURA = 600;

    public static Login login;
    public static Mapa dashboard;

    public static JFrame Frame;
    public static int InicialX, InicialY;

    public Android(int x, int y) {

        Android.InicialX = x;
        Android.InicialY = y;

        Frame = new JFrame();
        Frame.setIconImage(new ImageIcon("res\\ficon.png").getImage());

        Ambiente = new JDesktopPane();
        login = new Login(Frame);

        Dimension aSize = new Dimension(300, 600);

        Ambiente.setMinimumSize(aSize);
        Ambiente.setMaximumSize(aSize);
        Ambiente.setPreferredSize(aSize);
        Ambiente.setSize(aSize);

        Ambiente.setLayout(new GridLayout(1, 1));

        this.add(Ambiente);

        new Janela(Frame, this, "Celular", LARGURA, ALTURA, JFrame.DISPOSE_ON_CLOSE, true);
    }

    public static void desenharObjeto(int x, int y, int cX, int cY, int tamImagem, Graphics2D g2d, String localImagem) {
        if (cX < (x + tamImagem / 2) && cY < y) {
            g2d.drawImage(Control.buscarImagem(localImagem), x - cX - (tamImagem / 2), (20 + y) - cY - tamImagem, tamImagem, tamImagem, null);
        }
    }
}
