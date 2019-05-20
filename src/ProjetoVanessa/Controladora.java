package ProjetoVanessa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controladora extends JPanel implements ActionListener {

    JFrame frame;

    JTextField xic = new JTextField("xChuva");
    JTextField xfc = new JTextField("largChuva");
    JTextField yic = new JTextField("yChuva");
    JTextField yfc = new JTextField("altChuva");

    JTextField xia = new JTextField("x Alagamento");
    JTextField xfa = new JTextField("larg Alagamento");
    JTextField yia = new JTextField("y Alagamento");
    JTextField yfa = new JTextField("alt Alagamento");

    JButton btn = new JButton("enviar dados");

    public Controladora() {
        frame = new JFrame();
        new Janela(this, "Controladora", 750, 30, JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(this);

        this.add(xic);
        this.add(yic);
        this.add(xfc);
        this.add(yfc);

        this.add(btn);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn) {
            Control.ListaAreas.add(
                    new Areas(
                            Integer.parseInt(xic.getText()),
                            Integer.parseInt(yic.getText()),
                            Integer.parseInt(xfc.getText()),
                            Integer.parseInt(yfc.getText()),
                            TipoEventos.chuva
                    )
            );
            Control.Android.repaint();
        }
    }
}
