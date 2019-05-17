package Android;

import ProjetoVanessa.Control;
import ProjetoVanessa.Eventos;
import ProjetoVanessa.TipoEventos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home extends Telas implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -5395688902855962555L;

    private int cX, cY;

    private Point clickInicial;

    private final JPanel painelDashboard = new JPanel(null) {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharMapa(g2d);

            //desenharChuva(g2d);
            desenharLocalidade(g2d);

            desenharArea(g2d, Control.Chuva, TipoEventos.chuva);

            desenharFundo(g2d);

        }
    };

    public Home(JFrame frame) {
        super(frame);

        cX = Android.InicialX - 150;
        cX = Android.InicialY - 150;

        painelDashboard.addMouseListener(this);
        painelDashboard.addMouseMotionListener(this);

        painelDashboard.setBounds(tamanhoTela);
        this.add(painelDashboard);

    }

    //Método responsável pelo desenho das áreas no mapa, como chuva, alagamentos, e etc...
    private void desenharArea(Graphics2D g2d, List<Rectangle> lista, TipoEventos evento) {
        Color c1 = null;
        Color c2 = null;
        switch (evento) {
            case chuva:
                lista = Control.Chuva;
                c1 = new Color(45, 45, 90, 52);
                c2 = new Color(45, 45, 180, 128);
                break;
            case alagamento:
                lista = Control.Alagamentos;
                break;
            default:
                throw new IllegalArgumentException("Tipo de evento inválido");
        }
        for (Rectangle area : lista) {
            if ((cX < area.width + area.x && cY < area.height + area.y)) {
                g2d.setColor(c1);
                g2d.fillRect(area.x - cX, (20 + area.y) - cY, area.width, area.height);
                g2d.setColor(c2);
                g2d.drawRect(area.x - cX, (20 + area.y) - cY, area.width, area.height);
                Android.desenharObjeto((area.width / 2) + area.x,
                        (area.height / 2) + area.y,
                        cX,
                        cY,
                        32,
                        g2d,
                        "res\\chuva .png");
                System.out.println("res\\" + evento.toString() + ".png");
            }
        }
    }

    //Méotodo responsável pelo desenho do local em que o celular da aplica se encontra
    private void desenharLocalidade(Graphics2D g2d) {
        Android.desenharObjeto(Android.InicialX, Android.InicialY, cX, cY, 24, g2d, "res\\lf.png");
    }

    //Método responsável pelo desenho dos eventos do mapa
    private void desenharEventos(Graphics2D g2d) {
        for (Eventos evento : Control.Eventos) {
            evento.desenharEvento(g2d, cX, cY);
        }
    }

    private void desenharMapa(Graphics2D g2d) {
        if (cX > 900) {
            cX = 900;
        }
        if (cX < 0) {
            cX = 0;
        }
        if (cY > 660) {
            cY = 660;
        }
        if (cY < 0) {
            cY = 0;
        }
        g2d.drawImage(Control.buscarImagem("res\\cidade.png").getSubimage(cX, cY, 300, 540), 0, 21, 300, 540, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickInicial = e.getPoint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int thisX = cX;
        int thisY = cY;

        int xMoved = (thisX + e.getX()) - (thisX + clickInicial.x);
        int yMoved = (thisY + e.getY()) - (thisY + clickInicial.y);

        int x = thisX - (int) xMoved / 10;
        int y = thisY - (int) yMoved / 10;

        cX = x;
        cY = y;

        Control.Android.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
