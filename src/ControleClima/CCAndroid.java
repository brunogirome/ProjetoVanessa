package ControleClima;

import Android.Android;
import ProjetoVanessa.Control;
import ProjetoVanessa.Janela;
import ProjetoVanessa.Rua;
import ProjetoVanessa.Usuario;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class CCAndroid extends JPanel implements ActionListener {

    private DefaultTableModel ModeloTabela;
    private JTable table;
    private JScrollPane scrollTabela;
    private JButton novoCelular = new JButton("Novo Celular...");
    private JButton botaoAtualizar = new JButton(new ImageIcon("res\\reload.png"));

    public CCAndroid(JPanel mainPanel) {
<<<<<<< HEAD
        this.setBounds(0, 0, 180, 195);
=======
        this.setBounds(0, 0, 180, 360);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
        this.setBorder(new EtchedBorder(1));
        this.setLayout(null);

        JLabel label = new JLabel("Celulares");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Microsoft Sans Serif", 0, 18));
        label.setBounds(30, 5, 120, 20);
        this.add(label);

        JLabel labelIcon = new JLabel(new ImageIcon("res\\ficonAndroid.png"));
        labelIcon.setBounds(5, 5, 20, 20);
        this.add(labelIcon);

        novoCelular.setBounds(5, 30, 135, 30);
        novoCelular.addActionListener(this);
        this.add(novoCelular);

        botaoAtualizar.setBounds(145, 30, 30, 30);
        botaoAtualizar.addActionListener(this);
        this.add(botaoAtualizar);

        //------------------Tabela------------------------------
        ModeloTabela = new DefaultTableModel();

        table = new JTable(ModeloTabela);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        String[] colunasTable = {"Cód.:", "Pos:", "Rotas:"};
        for (String colunasTable1 : colunasTable) {
            ModeloTabela.addColumn(colunasTable1);
        }
        rowsTabela();

        scrollTabela = new JScrollPane();
        scrollTabela.setViewportView(table);
<<<<<<< HEAD
        scrollTabela.setBounds(5, 65, 170, 120);
=======
        scrollTabela.setBounds(5, 65, 170, 200);
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
        this.add(scrollTabela);
        //------------------------------------------------------

        mainPanel.add(this);
    }

    private void rowsTabela() {
        for (int i = 0; i < Control.ListaAndroid.size(); i++) {
            ModeloTabela.addRow(
                    new String[]{
                        i + "",
                        Control.ListaAndroid.get(i).getUser().getX() + ", " + Control.ListaAndroid.get(i).getUser().getY(),
                        Control.ListaAndroid.get(i).getRotasUser().size() + ""
                    }
            );
        }
    }

    private void atualizarTabela() {
        while (table.getRowCount() > 0) {
            ModeloTabela.removeRow(0);
        }
        rowsTabela();
    }

    private void labelAdd(JLabel label, int y, JPanel panel) {
        label.setBounds(5, y, 170, 20);
        label.setFont(new Font("Microsoft Sans Serif", 0, 14));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);
    }

    private void fieldAdd(JTextField field, int y, JPanel panel) {
        field.setBounds(65, y, 50, 20);
        field.setFont(new Font("Microsoft Sans Serif", 0, 14));
        field.setHorizontalAlignment(JLabel.CENTER);
        panel.add(field);
    }

    private void adicionarCelular() {
        JPanel paneladd = new JPanel(null);
        JFrame frameadd = new JFrame();

        JLabel lRua = new JLabel("RUA:");
        labelAdd(lRua, 5, paneladd);
        JComboBox<String> bRua = new JComboBox();
        bRua.setModel(new DefaultComboBoxModel(Rua.ruasStrings()));
        bRua.setBounds(5, 25, 170, 20);
        paneladd.add(bRua);

        JLabel lDes = new JLabel("DESLOCAMENTO:");
        labelAdd(lDes, 45, paneladd);
        JTextField desloc = new JTextField();
        fieldAdd(desloc, 65, paneladd);

        JLabel lTemp = new JLabel("TEMPERATURA:");
        labelAdd(lTemp, 85, paneladd);
        JTextField temp = new JTextField();
        fieldAdd(temp, 105, paneladd);

        JLabel lChuva = new JLabel("%CHUVA:");
        labelAdd(lChuva, 125, paneladd);
        JTextField chuva = new JTextField();
        fieldAdd(chuva, 145, paneladd);

        JLabel lVent = new JLabel("VEL. VENTO:");
        labelAdd(lVent, 165, paneladd);
        JTextField vento = new JTextField();
        fieldAdd(vento, 185, paneladd);

        JButton botaoAdd = new JButton("Adicionar");
        botaoAdd.setBounds(5, 205, 170, 40);
        botaoAdd.setFont(new Font("Microsoft Sans Serif", 0, 14));
        botaoAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Control.ListaAndroid.add(
                        new Android(
<<<<<<< HEAD
                                new Usuario(Control.LISTAS_RUAS.get(bRua.getSelectedIndex()), Float.parseFloat(desloc.getText()) / 100),
                                new JFrame(),
                                Integer.parseInt(temp.getText()),
                                Float.parseFloat(chuva.getText()) / 100,
=======
                                new Usuario(Control.LISTAS_RUAS.get(bRua.getSelectedIndex()), Float.parseFloat(desloc.getText())),
                                new JFrame(),
                                Integer.parseInt(temp.getText()),
                                Float.parseFloat(chuva.getText()),
>>>>>>> 0156769e9b1ea9db2788d6bb520a47dd0990c178
                                Integer.parseInt(vento.getText())
                        )
                );
                JOptionPane.showMessageDialog(null, "Nova instância criada!");
                frameadd.dispose();
            }
        });
        paneladd.add(botaoAdd);

        new Janela(paneladd, 180, 245, JFrame.EXIT_ON_CLOSE, null, frameadd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAtualizar) {
            atualizarTabela();
        } else if (e.getSource() == novoCelular) {
            adicionarCelular();
        }
    }

}
