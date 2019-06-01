package ControleClima;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ControleClimaMouse implements MouseListener, MouseMotionListener {

    int xx, xy;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == ControleClima.labelClose) {
            System.exit(0);
        } else if (e.getSource() == ControleClima.labelMini) {
            ControleClima.Frame.setState(JFrame.ICONIFIED);
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
        if (e.getSource() == ControleClima.labelMini) {
            ControleClima.labelMini.setIcon(new ImageIcon("res\\mini2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == ControleClima.labelMini) {
            ControleClima.labelMini.setIcon(new ImageIcon("res\\mini1.png"));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getX() > PainelLateral.LARG && e.getY() < ControleClima.PAINEL_TOPO) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();

            ControleClima.Frame.setLocation(x - xx, y - xy);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
