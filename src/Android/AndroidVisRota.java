package Android;

import ProjetoVanessa.Constantes;
import ProjetoVanessa.Control;
import ProjetoVanessa.Rotas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class AndroidVisRota extends AndroidTela implements MouseListener, Constantes {

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
        }
    }

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
        }
        g2d.drawImage(bg, 10, 30 + (i * 134), 280, 124, null);
        g2d.setFont(new Font("Microsoft Sans Serif", 0, 24));
        desenharStroke(g2d, rota.getDesc(), 20, 60 + (i * 134), Color.WHITE, Color.BLACK);
        g2d.setFont(new Font("Microsoft Sans Serif", 0, 18));
        desenharStroke(g2d, fmtHora.format(rota.getIni()), 235, 60 + (i * 134), Color.WHITE, Color.BLACK);
        desenharStroke(g2d, fmtHora.format(rota.getFim()), 235, 80 + (i * 134), Color.WHITE, Color.BLACK);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() < 80 && e.getY() > 550) {
            new AndroidMapa(android);
        }
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
