package Android;

import ProjetoVanessa.Constantes;
import ProjetoVanessa.Control;
import ProjetoVanessa.Rotas;
import ProjetoVanessa.Rua;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AndroidVisRota extends AndroidTela implements MouseListener, Constantes {

    private List<JLabel> listaBTN = new ArrayList<>();

    private JPanel painelVisRota = new JPanel(null) {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);
            desenharFundo(g2d);

            renderHints(g2d);
            paineisRota(g2d);

        }
    };

    public AndroidVisRota(Android android) {
        super(android);

        painelVisRota.addMouseListener(this);
        painelVisRota.setBounds(tamanhoTela);

        this.add(painelVisRota);

    }

    private void paineisRota(Graphics2D g2d) {
        for (int i = 0; i < android.getRotasUser().size(); i++) {
            painelRota(g2d, android.getRotasUser().get(i), i);
            configurarBotao(i);
        }
<<<<<<< HEAD
    }

    private void configurarBotao(int i) {
        listaBTN.add(new JLabel(new ImageIcon("res\\tracarRota.png")));
        listaBTN.get(i).setBounds(10, 87 + (i * 134), 44, 52);
        listaBTN.get(i).addMouseListener(this);
        painelVisRota.add(listaBTN.get(i));
    }

=======
    }

    private void configurarBotao(int i) {
        listaBTN.add(new JLabel(new ImageIcon("res\\tracarRota.png")));
        listaBTN.get(i).setBounds(10, 87 + (i * 134), 44, 52);
        listaBTN.get(i).addMouseListener(this);
        painelVisRota.add(listaBTN.get(i));
    }

>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
    private void painelRota(Graphics2D g2d, Rotas rota, int i) {
        BufferedImage bg = Control.buscarImagem("res\\cardLimpo.png");
        if (rota.isAlertar()) {
            if (rota.isAlagamento()) {
                bg = Control.buscarImagem("res\\cardAlagamento.png");
            } else if (rota.isTempestade()) {
                bg = Control.buscarImagem("res\\cardTempestade.png");
            } else if (rota.isChuva()) {
                bg = Control.buscarImagem("res\\cardChuva.png");
            }
        } else {
            bg = Control.buscarImagem("res\\cardLimpo.png");
        }
        g2d.drawImage(bg, 10, 30 + (i * 134), 280, 124, null);
        g2d.setFont(new Font("Microsoft Sans Serif", 0, 24));
        desenharStroke(g2d, rota.getDesc(), 20, 60 + (i * 134), Color.WHITE, Color.BLACK);
        g2d.setFont(new Font("Microsoft Sans Serif", 0, 18));
        desenharStroke(g2d, fmtHora.format(rota.getIni()), 235, 60 + (i * 134), Color.WHITE, Color.BLACK);
        desenharStroke(g2d, fmtHora.format(rota.getFim()), 235, 80 + (i * 134), Color.WHITE, Color.BLACK);
        //g2d.drawImage(Control.buscarImagem("res\\tracarRota.png"), 10, 87, 44, 52, null);
<<<<<<< HEAD
        desenharEvts(g2d, rota, i);
    }

    private void desenharEvts(Graphics2D g2d, Rotas rota, int i) {
        if (rota.isqArvore()) {
            g2d.drawImage(Control.buscarImagem("res\\qArvore.png"), 234, 108 + (i * 134), 36, 36, null);
        }
        if (rota.isqPoste()) {
            g2d.drawImage(Control.buscarImagem("res\\qPoste.png"), 188, 108 + (i * 134), 36, 36, null);
        }
        if (rota.isAcidente()) {
            g2d.drawImage(Control.buscarImagem("res\\acidente.png"), 142, 108 + (i * 134), 36, 36, null);
        }
        if (rota.isqLuz()) {
            g2d.drawImage(Control.buscarImagem("res\\qLuz.png"), 96, 108 + (i * 134), 36, 36, null);
        }
=======

>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
    }

    private void botaoTracar(MouseEvent e) {
        if (listaBTN.size() > 0) {
            for (int i = 0; i < listaBTN.size(); i++) {
                if (e.getSource() == listaBTN.get(i)) {
                    android.getRuasTracar().clear();
                    for (Rua rua : android.getRotasUser().get(i).getRuas()) {
                        android.getRuasTracar().add(rua);
                    }
                    android.setDesenharRuas(android.isDesenharRuas() == false);
                    System.out.println("Estado da var do androide que desenha as parada: " + android.isDesenharRuas());
                    new AndroidMapa(android);
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() < 80 && e.getY() > 550) {
            new AndroidMapa(android);
        }
        botaoTracar(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
}
