package Android;

import ProjetoVanessa.Control;
import ProjetoVanessa.Rua;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class AndroidRota extends AndroidTela implements ProjetoVanessa.Constantes, MouseListener {

    private JPanel painelRegRota = new JPanel(null) {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);

            desenharFundo(g2d);
        }
    };

    public AndroidRota(Android android) {
        super(android);

        painelRegRota.addMouseListener(this);
        painelRegRota.setBounds(tamanhoTela);

        this.add(painelRegRota);

        elementosTela();
    }

    private void elementosTela() {

    }

    private void desenharTela(Graphics2D g2d) {
        desenharStroke(g2d, "Cadestre uma rota: ", WIDTH, WIDTH, AZUL1, AZUL1);
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
