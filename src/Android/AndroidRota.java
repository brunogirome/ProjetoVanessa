package Android;

import ProjetoVanessa.Control;
import ProjetoVanessa.Rotas;
import ProjetoVanessa.Rua;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class AndroidRota extends AndroidTela implements ProjetoVanessa.Constantes, MouseListener {

    private JPanel painelRegRota = new JPanel(null) {
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);
            desenharFundo(g2d);
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 20, 300, 530);

            renderHints(g2d);
            desenharTela(g2d);
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
        labelRota(labelNome, 20, 80, 260, 20);
        fieldRota(fieldNome, 20, 100, 260, 30);

        labelRota(lhIni, 20, 140, 120, 20);
        fieldRota(hIni, 20, 160, 120, 30);
        hIni.setModel(new DefaultComboBoxModel(listaHora()));

        labelRota(lhFim, 160, 140, 120, 20);
        fieldRota(hFim, 160, 160, 120, 30);
        hFim.setModel(new DefaultComboBoxModel<>(listaHora()));

        labelRota(labelRuas, 20, 190, 260, 30);

        listaRua.setModel(new AbstractListModel() {
            @Override
            public int getSize() {
                return Rua.ruasStrings().length;
            }

            @Override
            public Object getElementAt(int index) {
                return Rua.ruasStrings()[index];
            }
        });
        listaRua.setFont(new Font(Century, 0, 15));
        listaRua.setSelectionBackground(AZUL1);
        JScrollPane paneSelect = new JScrollPane();
        configurarScroll(paneSelect);
        paneSelect.setViewportView(listaRua);
        paneSelect.setBounds(20, 220, 260, 120);
        painelRegRota.add(paneSelect);

        botaoRota(botaoRem, 20, 345, 120, 30);
        botaoRota(botaoAdd, 160, 345, 120, 30);

        listaSelec.setSelectionBackground(AZUL1);
        listaSelec.setFont(new Font(Century, 0, 15));
        JScrollPane scroll2 = new JScrollPane();
        configurarScroll(scroll2);
        scroll2.setBounds(20, 380, 260, 120);
        scroll2.setViewportView(listaSelec);
        painelRegRota.add(scroll2);

        botaoRota(botaoFinalizar, 20, 510, 260, 30);
    }

    private String[] listaView() {
        String[] sRua = new String[ruasRota.size()];
        for (int i = 0; i < sRua.length; i++) {
            sRua[i] = ruasRota.get(i).getDesc();
        }
        return sRua;
    }

    private String[] listaHora() {
        String[] aux = new String[144];
        int x = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 6; j++) {
                aux[x] = FORMATO_MIN.format(i) + ":" + FORMATO_MIN.format(j * 10);
                x++;
            }
        }
        return aux;
    }

    private void configurarScroll(JScrollPane scr) {
        scr.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void fieldRota(JComponent field, int x, int y, int w, int h) {
        field.setBounds(x, y, w, h);
        field.setFont(fonteCampos);
        field.setForeground(CINZATOPO);
        painelRegRota.add(field);
    }

    private void labelRota(JLabel label, int x, int y, int w, int h) {
        label.setBounds(x, y, w, h);
        label.setFont(new Font(Century, 0, 18));
        label.setForeground(CINZAESC);
        painelRegRota.add(label);
    }

    private void botaoRota(JButton btn, int x, int y, int w, int h) {
        btn.setBounds(x, y, w, h);
        btn.setFont(new Font(Century, 0, 16));
        btn.addMouseListener(this);
        painelRegRota.add(btn);
    }

    private void desenharTela(Graphics2D g2d) {
        g2d.setColor(AZUL1);
        g2d.fillRect(0, 20, 300, 50);
        g2d.setColor(AZUL3);
        g2d.fillRect(0, 60, 300, 10);
        g2d.setColor(Color.white);
        g2d.setFont(new Font(Century, 0, 32));
        g2d.drawString("Crie sua rota", 20, 55);
    }

    private void criarRota() {
        android.rotasUser.add(new Rotas(0, fieldNome.getText(), Time.valueOf(hIni.getSelectedItem().toString() + ":00"), Time.valueOf(hFim.getSelectedItem().toString() + ":00"), ruasRota));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!listaRua.isSelectionEmpty() && e.getSource() == botaoAdd) {
            ruasRota.add(Control.LISTAS_RUAS.get(listaRua.getSelectedIndex()));
            listaSelec.setModel(modelSelect());
        } else if (!listaSelec.isSelectionEmpty() && e.getSource() == botaoRem) {
            ruasRota.remove(listaSelec.getSelectedIndex());
            listaSelec.setModel(modelSelect());
        } else if (checarCadastro(e)) {
            criarRota();
            JOptionPane.showMessageDialog(null, "Rota criada com sucesso! :)");
//            for (Rotas rota : android.rotasUser) {
//                System.out.println(rota.toString());
//            }
            new AndroidMapa(android);
        }
    }

    private boolean checarCadastro(MouseEvent e) {
        if (e.getSource() == botaoFinalizar) {
            if (!fieldNome.getText().equals("")) {
                if (!ruasRota.isEmpty()) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Selecio alguma via");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insira um nome para a rota!");
                return false;
            }
        } else {
            return false;
        }
    }

    private AbstractListModel modelSelect() {
        return new AbstractListModel() {
            @Override
            public int getSize() {
                return listaView().length;
            }

            @Override
            public Object getElementAt(int index) {
                return listaView()[index];
            }
        };
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

    private JLabel labelNome = new JLabel("Descrição:");
    private JTextField fieldNome = new JTextField();

    private JLabel lhIni = new JLabel("Início:");
    //private JTextField hIni = new JTextField();
    private JComboBox<String> hIni = new JComboBox();

    private JLabel lhFim = new JLabel("Fim:");
    //private JTextField hFim = new JTextField();
    private JComboBox<String> hFim = new JComboBox();

    private JLabel labelRuas = new JLabel("Ruas:");
    private JList listaRua = new JList();

    private JButton botaoAdd = new JButton("Adicionar");
    private JButton botaoRem = new JButton("Remover");

    private JLabel labelSelec = new JLabel("Ruas:");
    private JList listaSelec = new JList();

    private List<Rua> ruasRota = new ArrayList<>();

    private JButton botaoFinalizar = new JButton("Concluir criação");
}
