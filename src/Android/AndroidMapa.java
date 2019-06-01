package Android;

import ProjetoVanessa.Areas;
import ProjetoVanessa.Constantes;
import ProjetoVanessa.Control;
import ProjetoVanessa.Eventos;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AndroidMapa extends AndroidTela implements MouseListener, MouseMotionListener, Constantes {

    private static final long serialVersionUID = -5395688902855962555L;

    // “Câmera X”, “Câmera Y”, pontos iniciar de renderização da sub-imagem do mapa
    private int cX, cY;

    private Point clickInicial;

    public boolean abrirSidePanel = false;

    private final JPanel painelMapa = new JPanel(null) {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            renderizarMapa(g2d);

            desenharFundo(g2d);

            renderHints(g2d);
            desenharPainel(g2d, 0, 486, 300, 64);

            sidePanel(g2d, abrirSidePanel);
            desenharRect(g2d);
        }
    };

    public AndroidMapa(Android android) {
        super(android);

        centralizarPonto(android.getUser().getX(), android.getUser().getY());

        painelMapa.addMouseListener(this);
        painelMapa.addMouseMotionListener(this);
        painelMapa.setBounds(tamanhoTela);

        this.add(painelMapa);
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

    private void desenharPainel(Graphics2D g2d, int x, int y, int w, int h) {
        g2d.drawImage(Control.buscarImagem("res\\pmS.png"), x, y, h, h, null);
        g2d.setColor(AZUL1);
        g2d.fillRect(h, y, w - 64, h);

        //chuva        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) android.getPorcenChuva()));
        g2d.drawImage(Control.buscarImagem("res\\cpbw.png"), w - 64, y + 8, 48, 48, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        g2d.setFont(new Font(Century, 0, 32));
        desenharStroke(g2d, FORMATO_MIN.format((android.getPorcenChuva() * 100)), w - 58, y + 38, new Color(22, 163, 224), Color.black);
        g2d.setFont(new Font(Century, 0, 18));
        desenharStroke(g2d, "%", w - 44, y + 56, new Color(22, 163, 224), Color.black);
        //vento
        g2d.drawImage(Control.buscarImagem("res\\vp.png"), w - 64 - 48 - 8, y + 8, 48, 48, null);
        g2d.setFont(new Font(Century, 0, 32));
        desenharStroke(g2d, android.getVento() + "", w - 110, y + 38, Color.lightGray, Color.black);
        g2d.setFont(new Font(Century, 0, 18));
        desenharStroke(g2d, "km/h", w - 112, y + 56, Color.lightGray, Color.black);
        //temp
        g2d.setColor(Color.black);
        g2d.setFont(new Font(Century, 0, 48));
        desenharStroke(g2d, android.getTemp() + "º", h + 16, 535, Color.white, Color.black);

        g2d.drawImage(Control.buscarImagem("res\\mpm.png"), x + 8, y + 8, 48, 48, null);
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
        g2d.drawImage(Control.buscarImagem("res\\cidade.png").getSubimage(cX, cY, 300, 476), 0, 21, 300, 476, null);
    }

    // Metódo utilizado para centralizar a câmera em um certo ponto
    private void centralizarPonto(int x, int y) {
        cX = x - 150;
        cY = y - 270;
        android.repaint();
    }

    private int xSP = -255;
    private Timer timerSP = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (xSP < 0) {
                if (abrirSidePanel) {
                    xSP += 60;
                }
                if (xSP >= 0) {
                    xSP = 0;
                    timerSP.stop();
                }
            }
        }
    });

    private void sidePanel(Graphics2D g2d, boolean sinal) {
        if (sinal) {
            g2d.setColor(new Color(0, 0, 0, 128));
            g2d.fillRect(0, 20, 300, 530);
            g2d.setColor(Color.white);
            g2d.fillRect(xSP, 20, 255, 530);

            g2d.setColor(Color.lightGray);
            g2d.fillRect(xSP, 70, 255, 1);
            g2d.setColor(CINZAESC);
            g2d.setFont(new Font(Century, 0, 18));
            g2d.drawImage(Control.buscarImagem("res\\spAdd.png"), xSP + 10, 91, 24, 24, null);
            g2d.drawString("Adicionar Rota", xSP + 45, 110);
            g2d.drawImage(Control.buscarImagem("res\\spVis.png"), xSP + 10, 141, 24, 24, null);
            g2d.drawString("Suas Rotas", xSP + 45, 160);
            g2d.drawImage(Control.buscarImagem("res\\spInfo.png"), xSP + 10, 191, 24, 24, null);
            g2d.drawString("Sobre", xSP + 45, 210);
            //g2d.fillRect(xSP, 90, 255, 2);

        } else {
            xSP = -255;
        }
        painelMapa.repaint();
    }

    // Método utilizado para evitar erros ao carregar a sub-imagem do mapa
    private void limitarCamera() {
        if (cX > 900) {
            cX = 900;
        }
        if (cX < 0) {
            cX = 0;
        }
        if (cY > 724) {
            cY = 724;
        }
        if (cY < 0) {
            cY = 0;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() < 64 && e.getY() > 486 && e.getY() < 550 && !abrirSidePanel) {
            this.abrirSidePanel = !this.abrirSidePanel;
            timerSP.start();
        } else if (e.getX() > 255 && e.getY() > 20 && e.getY() < 550 && abrirSidePanel) {
            this.abrirSidePanel = !this.abrirSidePanel;
        } else if (e.getX() > 0 && e.getX() < 255 && e.getY() > 80 && e.getY() < 125 && abrirSidePanel) {
            new AndroidRota(android);
        } else if (e.getX() > 0 && e.getX() < 255 && e.getY() > 130 && e.getY() < 175 && abrirSidePanel) {
            //System.out.println("vis rota");
            new AndroidVisRota(android);
        } else if (e.getX() > 0 && e.getX() < 255 && e.getY() > 180 && e.getY() < 225 && abrirSidePanel) {
            System.out.println("sobre");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickInicial = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

        int x = thisX - (int) xMoved / 4;
        int y = thisY - (int) yMoved / 4;

        cX = x;
        cY = y;

        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        android.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX() > 0 && e.getX() < 255 && e.getY() > 80 && e.getY() < 125 && abrirSidePanel) {//botao1
            rectY = 80;
            desenharRect = true;
            painelMapa.repaint();
        } else if (e.getX() > 0 && e.getX() < 255 && e.getY() > 130 && e.getY() < 175 && abrirSidePanel) {//botao2
            rectY = 130;
            desenharRect = true;
            painelMapa.repaint();
        } else if (e.getX() > 0 && e.getX() < 255 && e.getY() > 180 && e.getY() < 225 && abrirSidePanel) {//botao3
            rectY = 180;
            desenharRect = true;
            painelMapa.repaint();
        } else {
            rectY = 0;
            desenharRect = false;
            painelMapa.repaint();
        }
    }

    private boolean desenharRect = false;
    private int rectY = 0;

    private void desenharRect(Graphics2D g2d) {
        if (abrirSidePanel && desenharRect) {
            g2d.setColor(new Color(52, 52, 52, 25));
            g2d.fillRect(xSP + 10, rectY, 235, 45);
        }
    }

}
