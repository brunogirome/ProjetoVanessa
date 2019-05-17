package ProjetoVanessa;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controladora extends JPanel implements ActionListener {

    JFrame frame;

    JTextField xic = new JTextField("x Chuva");
    JTextField xfc = new JTextField("larg Chuva");
    JTextField yic = new JTextField("y Chuva");
    JTextField yfc = new JTextField("alt Chuva");

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

            Control.Chuva.add(
                    new Rectangle(
                            Integer.parseInt(xic.getText()),
                            Integer.parseInt(yic.getText()),
                            Integer.parseInt(xfc.getText()),
                            Integer.parseInt(yfc.getText())
                    )
            );

            Control.Android.repaint();
        }
    }
}
