package Android;

import ProjetoVanessa.Constantes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class AndroidVisRota extends AndroidTela implements MouseListener, Constantes {

    private JPanel painelVisRota = new JPanel(null) {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);
            desenharFundo(g2d);

            renderHints(g2d);
        }
    };

    public AndroidVisRota(Android android) {
        super(android);

        painelVisRota.addMouseListener(this);
        painelVisRota.setBounds(tamanhoTela);

        this.add(painelVisRota);
    }

    private void panelRota() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
