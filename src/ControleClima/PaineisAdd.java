package ControleClima;

import ProjetoVanessa.Areas;
import ProjetoVanessa.Control;
import ProjetoVanessa.Eventos;
import ProjetoVanessa.Rua;
import ProjetoVanessa.TipoEventos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class PaineisAdd extends JPanel implements ActionListener {

    private JTextField posX = new JTextField();
    private JTextField posY = new JTextField();
    private JTextField widht = new JTextField();
    private JTextField height = new JTextField();

    private JLabel lX = new JLabel("PosX:");
    private JLabel lY = new JLabel("PosY:");
    private JLabel lW = new JLabel("Larg:");
    private JLabel lH = new JLabel("Altu:");

    private JComboBox<String> tipoEvt = new JComboBox<>();
    private TipoEventos[] vetorEvetos;

    private JComboBox<String> listRuas = new JComboBox<>();
    private JTextField deslocEvt = new JTextField();

    private JButton botao = new JButton("Adicionar...");

    private int tipo;

    public PaineisAdd(JPanel panel, int x, String[] list, TipoEventos[] vetorEvento, int tipo) {
        this.setLayout(null);
<<<<<<< HEAD
        this.setBounds(x, 0, 222, 195);
=======
        this.setBounds(x, 40, 222, 320);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
        this.setBorder(new EtchedBorder(1));

        this.vetorEvetos = vetorEvento;
        this.tipo = tipo;

        if (tipo == 0) {
            camposDados(posX, 51, 5);
            camposDados(posY, 162, 5);
            labelDados(lX, posX);
            labelDados(lY, posY);
            camposDados(widht, 51, 35);
            camposDados(height, 162, 35);
            labelDados(lW, widht);
            labelDados(lH, height);
        } else {
            seleCionarTipo(listRuas, Rua.ruasStrings(), 5, 40);
            JLabel label = new JLabel("Deslocação (em %): ");
            label.setBounds(5, 5, 152, 25);
            label.setFont(new Font("Microsft Sans Serif", 0, 14));
            label.setHorizontalAlignment(JLabel.HORIZONTAL);
            this.add(label);
            camposDados(deslocEvt, 162, 5);
        }
        seleCionarTipo(tipoEvt, list, 5, 70);

        botaoAdicionar(botao);

        panel.add(this);
    }

    private void camposDados(JTextField tField, int x, int y) {
<<<<<<< HEAD
        tField.setBounds(x, y, 55, 20);
=======
        tField.setBounds(x, y, 55, 25);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
        tField.setFont(new Font("Microsoft Sans Serif", 0, 18));
        tField.setHorizontalAlignment(JTextField.HORIZONTAL);
        this.add(tField);
    }

    private void labelDados(JLabel label, JTextField tField) {
        label.setBounds(tField.getX() - 46, tField.getY(), 41, 25);
        label.setFont(new Font("Microsft Sans Serif", 0, 14));
        label.setHorizontalAlignment(JLabel.HORIZONTAL);
        this.add(label);
    }

    //5, 70, 212
    private void seleCionarTipo(JComboBox<String> comboBox, String[] list, int x, int y) {
        comboBox.setModel(new DefaultComboBoxModel<>(list));
        comboBox.setBounds(x, y, 212, 25);
        comboBox.setFont(new Font("Microsoft Sans Serif", 0, 14));
        this.add(comboBox);
    }

    private void botaoAdicionar(JButton botao) {
<<<<<<< HEAD
        botao.setBounds(5, 150, 212, 35);
=======
        botao.setBounds(5, 100, 212, 25);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
        botao.setFont(new Font("Microsoft Sans Serif", 0, 14));
        botao.addActionListener(this);
        this.add(botao);
    }

    private int textoInt(JTextField tField) {
        return Integer.parseInt(tField.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao) {
            if (tipo == 0) {
                Control.ListaAreas.add(new Areas(textoInt(posX), textoInt(posY), textoInt(widht), textoInt(height), vetorEvetos[tipoEvt.getSelectedIndex()]));
            } else if (tipo == 1) {
                Control.ListaEventos.add(new Eventos(Control.LISTAS_RUAS.get(listRuas.getSelectedIndex()), vetorEvetos[tipoEvt.getSelectedIndex()], Float.parseFloat(deslocEvt.getText()) / 100));
            }
        }

    }

}
