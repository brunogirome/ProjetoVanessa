package Android;

import ProjetoVanessa.Constantes;
import ProjetoVanessa.Control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.JTextComponent;

public abstract class AndroidTela extends JInternalFrame implements Constantes {

    private static final long serialVersionUID = 8883926225504151747L;

    protected JPanel painelTopo = new JPanel(null) {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
//            renderHints(g2d);
//            g2d.drawImage(Control.buscarImagem("res\\top.png"), 0, 0, 300, 10, null);
            g2d.setColor(new Color(0, 0, 0, 0));
            g2d.fillRect(0, 0, 300, 10);
        }
    };

    private int xx, xy;

    protected Rectangle tamanhoTela = new Rectangle(0, 0, 300, 600);

    protected Font fonteCampos = new Font("Century Gothic", 0, 16);

    protected JLabel labelBack = new JLabel();

    protected Android android;

    public AndroidTela(Android android) {
        this.android = android;
        android.Ambiente.removeAll();
        android.Ambiente.add(this);

        this.setLayout(null);
        this.setBorder(null);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        painelTopo.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() > 280) {
                    android.frame.dispose();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                xy = e.getY();
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
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        painelTopo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();

                android.frame.setLocation(x - xx, y - xy);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        painelTopo.setBounds(0, 0, 300, 10);

//        this.add(painelTopo);
        this.setVisible(true);

    }

    protected void botaoVoltar(MouseListener mouse, JInternalFrame frame) {
        labelBack.setBounds(50, 560, 30, 30);
        labelBack.addMouseListener(mouse);
        frame.add(labelBack);
    }

    protected void desenharBackground(Graphics2D g2d) {
        g2d.drawImage(Control.buscarImagem("res\\bgc.png"), 0, 0, 300, 550, null);

    }

    protected void desenharFundo(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 550, 300, 40);
        g2d.drawImage(Control.buscarImagem("res\\bottom.png"), 0, 560, 300, 30, null);
        g2d.fillRect(0, 590, 300, 10);

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 300, 20);
        g2d.setColor(new Color(128, 128, 128, 128));
        g2d.fillRect(0, 20, 300, 1);

        g2d.drawImage(Control.buscarImagem("res\\wsb.png"), 217, 0, 42, 20, null);

        g2d.setColor(Color.white);
        g2d.drawString(Constantes.fmtHora.format(Control.Horario), 265, 14);
    }

    private void criarPlaceHolder(Color color, JTextComponent campo, String texto, Font font, JComponent painel) {
        JTextField placeHolder = new JTextField(texto);
        placeHolder.setEnabled(false);
        placeHolder.setBorder(null);
        placeHolder.setBounds(campo.getBounds());
        placeHolder.setDisabledTextColor(color);
        placeHolder.setOpaque(false);
        placeHolder.setFont(font);
        campo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ("".equals(campo.getText())) {
                    placeHolder.setVisible(true);
                    placeHolder.setEnabled(false);
                } else {
                    placeHolder.setVisible(false);
                    placeHolder.setEnabled(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        painel.add(placeHolder);
    }

    protected void criarCampo(JTextComponent campo, Rectangle r, Font font, MouseListener mouse, JComponent painel) {
        campo.setBorder(null);
        campo.setBounds(r);
        campo.setForeground(Color.white);
        campo.setOpaque(false);
        campo.setFont(font);
        campo.addMouseListener(mouse);

        painel.add(campo);
    }

    protected void criarCampo(JTextComponent campo, String texto, Rectangle r, Font font, MouseListener mouse, JComponent painel) {
        criarCampo(campo, r, font, mouse, painel);
        criarPlaceHolder(Color.lightGray, campo, texto, font, painel);
    }

    protected void criarCampo(JTextComponent campo, String texto, Color color, Rectangle r, Font font, MouseListener mouse, JComponent painel) {
        criarCampo(campo, texto, r, font, mouse, painel);
        campo.setForeground(color);
    }

    protected void criarCampo(JTextComponent campo, String texto, Color color, Color colorp, Rectangle r, Font font, MouseListener mouse, JComponent painel) {
        criarCampo(campo, r, font, mouse, painel);
        criarPlaceHolder(colorp, campo, texto, font, painel);
        campo.setForeground(color);
    }

    protected void renderHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private int sN(int p, int d) {
        return (p - d);
    }

    private int sS(int p, int d) {
        return (p + d);
    }

    private int sE(int p, int d) {
        return (p + d);
    }

    private int sW(int p, int d) {
        return (p - d);
    }

    protected void desenharStroke(Graphics2D g2d, String text, int x, int y, Color corTexto, Color corStroke) {
        g2d.setColor(corStroke);
        g2d.drawString(text, sW(x, 1), sN(y, 1));
        g2d.drawString(text, sW(x, 1), sS(y, 1));
        g2d.drawString(text, sE(x, 1), sN(y, 1));
        g2d.drawString(text, sE(x, 1), sS(y, 1));

        g2d.setColor(corTexto);
        g2d.drawString(text, x, y);

    }

}
