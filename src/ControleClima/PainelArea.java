package ControleClima;

import ProjetoVanessa.TipoEventos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelArea extends JPanel implements ActionListener {

    private JTextField posX = new JTextField();
    private JTextField posY = new JTextField();
    private JTextField widht = new JTextField();
    private JTextField height = new JTextField();

    public PainelArea(int x, int y, TipoEventos tipoEvt, JPanel panel) {
        //posX.setBounds(5, 5,);
    }

    private void camposDados(JTextField tField, int x, int y) {
        tField.setBounds(x, y, 120, 30);
        tField.setFont(new Font("Microsoft Sans Serif", 0, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
