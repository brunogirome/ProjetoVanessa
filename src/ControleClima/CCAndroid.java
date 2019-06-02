package ControleClima;

import Android.Android;
import ProjetoVanessa.Control;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class CCAndroid extends JPanel implements ActionListener {

    private DefaultTableModel ModeloTabela;
    private JTable table;
    private JScrollPane scrollTabela;
    private JButton novoCelular = new JButton("Novo Celular...");

    public CCAndroid(JPanel mainPanel) {
        this.setBounds(0, 0, 180, 360);
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

        novoCelular.setBounds(5, 30, 170, 30);
        novoCelular.addActionListener(this);
        this.add(novoCelular);

        //------------------Tabela------------------------------
        ModeloTabela = new DefaultTableModel();

        table = new JTable(ModeloTabela);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        String[] colunasTable = {"Cód.:", "User:", "Rotas:"};
        for (String colunasTable1 : colunasTable) {
            ModeloTabela.addColumn(colunasTable1);
        }
        rowsTabela();

        scrollTabela = new JScrollPane();
        scrollTabela.setViewportView(table);
        scrollTabela.setBounds(5, 65, 170, 200);
        this.add(scrollTabela);
        //------------------------------------------------------

        mainPanel.add(this);
    }

    private void rowsTabela() {
        for (int i = 0; i < Control.ListaAndroid.size(); i++) {
            ModeloTabela.addRow(
                    new String[]{
                        i + "",
                        Control.ListaAndroid.get(i).getUser().getNome(),
                        Control.ListaAndroid.get(i).getRotasUser().size() + ""
                    }
            );
        }
    }

    private void atualizarTabela() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
