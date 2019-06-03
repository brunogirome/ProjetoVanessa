package ControleClima;

import ProjetoVanessa.TipoEventos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class PainelArea extends JPanel implements ActionListener {

    private JTextField posX = new JTextField();
    private JTextField posY = new JTextField();
    private JTextField widht = new JTextField();
    private JTextField height = new JTextField();

    public PainelArea(JPanel panel) {
        this.setLayout(null);
        this.setBounds(185, 40, 222, 320);
        this.setBorder(new EtchedBorder(1));

        camposDados(posX, 25, 5);
        camposDados(posY, 110, 5);
        camposDados(widht, 5, 40);
        camposDados(height, 110, 40);

        panel.add(this);
    }

    private void camposDados(JTextField tField, int x, int y) {
        tField.setBounds(x, y, 55, 25);
        tField.setFont(new Font("Microsoft Sans Serif", 0, 18));
        tField.setHorizontalAlignment(JTextField.HORIZONTAL);
        this.add(tField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
