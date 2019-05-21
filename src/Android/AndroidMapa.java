package Android;

import ProjetoVanessa.Areas;
import ProjetoVanessa.Control;
import ProjetoVanessa.Eventos;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ProjetoVanessa.Rua;

public class AndroidMapa extends AndroidTela implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = -5395688902855962555L;

    // “Câmera X”, “Câmera Y”, pontos iniciar de renderização da sub-imagem do mapa
    private int cX, cY;

    private Point clickInicial;

    private final JPanel painelDashboard = new JPanel(null) {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            renderizarMapa(g2d);

            desenharFundo(g2d);

        }
    };

    public AndroidMapa(Android android) {
        super(android);

        centralizarPonto(android.getUser().getX(), android.getUser().getY());

        painelDashboard.addMouseListener(this);
        painelDashboard.addMouseMotionListener(this);
        painelDashboard.setBounds(tamanhoTela);

        this.add(painelDashboard);
    }

    // Méotodo responsável pelo desenho do local em que o celular da aplicação se
    // encontra
    private void desenharLocalidade(Graphics2D g2d) {
        Android.desenharObjeto(android.getUser().getX(), android.getUser().getY(), cX, cY, 48, g2d, "res\\lf.png");
    }

    // Método responsável pelo desenho dos eventos do mapa
    private void desenharEventos(Graphics2D g2d) {
        for (Eventos evento : Control.ListaEventos) {
            evento.desenharEvento(g2d, cX, cY);
        }
    }

    // Método responsável pelo desenho das áreas
    private void desenharAreas(Graphics2D g2d) {
        for (Areas area : Control.ListaAreas) {
            area.desenharArea(g2d, cX, cY);
        }
    }

    private void desenharRuas(Graphics2D g2d) {
        for (Rua rua : Control.LISTAS_RUAS) {
            rua.desenharRua(g2d, cX, cY);
        }
    }

    // Método que une todas as classes que desenham objetos no mapa, em suas
    // respectivas ordens de camada.
    // (Os métodos desenhados por último fica por cima dos primeiros).
    private void renderizarMapa(Graphics2D g2d) {
        // Primeira layer, câmera sobre as coordenadas do mapa.
        camera(g2d);
        // Layer de desenho de ruas
        //desenharRuas(g2d);
        // Segunda layer, áreas como chuvas, alagamentos, e etc.
        desenharAreas(g2d);
        // Terceira layer, eventos, como queda de árvore, acidentes e etc.
        desenharEventos(g2d);
        // Quarta layer, posicionamento atual do GPS.
        desenharLocalidade(g2d);
    }

    // Método responsável pela visualização de uma determinada parte do mapa, que é
    // controlada pelo mouse
    private void camera(Graphics2D g2d) {
        limitarCamera();
        g2d.drawImage(Control.buscarImagem("res\\cidade.png").getSubimage(cX, cY, 300, 540), 0, 21, 300, 540, null);
    }

    // Metódo utilizado para centralizar a câmera em um certo ponto
    private void centralizarPonto(int x, int y) {
        cX = x - 150;
        cY = y - 270;
        android.repaint();
    }

    // Método utilizado para evitar erros ao carregar a sub-imagem do mapa
    private void limitarCamera() {
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
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        //android.repaint();
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

        int x = thisX - (int) xMoved / 8;
        int y = thisY - (int) yMoved / 8;

        cX = x;
        cY = y;

        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        android.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
       System.out.println("xy: " + e.getX() + ", " + e.getY());
    }

}
