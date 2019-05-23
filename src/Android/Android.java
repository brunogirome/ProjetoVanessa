package Android;

import ProjetoVanessa.Control;
import ProjetoVanessa.Janela;
import ProjetoVanessa.Rotas;
import ProjetoVanessa.Usuario;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Android extends JPanel {

    private static final long serialVersionUID = 4801318033194283596L;

    public JDesktopPane Ambiente;

    public static final int LARGURA = 300, ALTURA = 600;

    public AndroidLogin login;
    public AndroidMapa dashboard;

    public JFrame frame;

    public List<Rotas> rotasUser = new ArrayList<>();

    private Usuario user;

    private int temp;
    private float porcenChuva;
    private int vento;

    public Android(Usuario user, JFrame frame, int temp, float porcenChuva, int vento) {
        this.user = user;
        this.frame = frame;

        this.temp = temp;
        this.porcenChuva = porcenChuva;
        this.vento = vento;
        frame.setIconImage(new ImageIcon("res\\ficon.png").getImage());

        Ambiente = new JDesktopPane();

        login = new AndroidLogin(this);

        Dimension aSize = new Dimension(300, 600);

        Ambiente.setMinimumSize(aSize);
        Ambiente.setMaximumSize(aSize);
        Ambiente.setPreferredSize(aSize);
        Ambiente.setSize(aSize);

        Ambiente.setLayout(new GridLayout(1, 1));

        this.add(Ambiente);

        new Janela(frame, this, "Celular", LARGURA, ALTURA, JFrame.DISPOSE_ON_CLOSE, true);
        frame.createBufferStrategy(2);
    }

    public static void desenharObjeto(int x, int y, int cX, int cY, int tamImagem, Graphics2D g2d, String localImagem) {
        if (cX < (x + tamImagem / 2) && cY < y) {
            g2d.drawImage(Control.buscarImagem(localImagem), x - cX - (tamImagem / 2), (20 + y) - cY - tamImagem, tamImagem, tamImagem, null);
        }
    }

    public Usuario getUser() {
        return this.user;
    }

    public int getTemp() {
        return temp;
    }

    public float getPorcenChuva() {
        return porcenChuva;
    }

    public int getVento() {
        return vento;
    }

}
