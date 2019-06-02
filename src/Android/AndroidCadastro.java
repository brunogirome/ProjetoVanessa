package Android;

import ProjetoVanessa.Control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AndroidCadastro extends AndroidTela implements MouseListener {

    private static final long serialVersionUID = -7980272468065386510L;

    int teste = 3;

    private JPanel panelCadastro = new JPanel(null) {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);

            g2d.setColor(Color.WHITE);

            g2d.drawImage(Control.buscarImagem("res\\iconuser.png"), 35, 145, 20, 20, null);
            g2d.fillRect(35, 170, 230, 2);

            g2d.drawImage(Control.buscarImagem("res\\iconuser.png"), 35, 195, 20, 20, null);
            g2d.fillRect(35, 220, 230, 2);

            g2d.drawImage(Control.buscarImagem("res\\iconemail.png"), 35, 245, 20, 20, null);
            g2d.fillRect(35, 270, 230, 2);

            g2d.drawImage(Control.buscarImagem("res\\iconpass.png"), 35, 295, 20, 20, null);
            g2d.fillRect(35, 320, 230, 2);

            g2d.drawImage(Control.buscarImagem("res\\iconpass.png"), 35, 345, 20, 20, null);
            g2d.fillRect(35, 370, 230, 2);

            desenharFundo(g2d);
        }
    };

    private JLabel label = new JLabel("Cadastre-se");

    private JTextField nome = new JTextField();

    private JTextField user = new JTextField();

    private JTextField email = new JTextField();

    private JPasswordField senha1 = new JPasswordField();

    private JPasswordField senha2 = new JPasswordField();

    private JButton botaoRegistrar = new JButton();

    public AndroidCadastro(Android android) {
        super(android);

        label.setBounds(0, 50, 300, 50);
        label.setFont(new Font("Century Gothic", 0, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.white);
        panelCadastro.add(label);

        criarCampo(nome, "Nome", Color.white, Color.darkGray, new Rectangle(60, 140, 205, 30), fonteCampos, this, this);

        criarCampo(user, "Usuário", Color.white, Color.darkGray, new Rectangle(60, 190, 205, 30), fonteCampos, this, this);

        criarCampo(email, "E-Mail", Color.white, Color.darkGray, new Rectangle(60, 240, 205, 30), fonteCampos, this, this);

        criarCampo(senha1, "Senha", Color.white, Color.darkGray, new Rectangle(60, 290, 205, 30), new Font("", 0, 16), this, this);

        criarCampo(senha2, "Confirme sua senha", Color.white, Color.DARK_GRAY, new Rectangle(60, 340, 195, 30), new Font("", 0, 16), this, this);

        botaoRegistrar.setBounds(35, 425, 230, 45);
        botaoRegistrar.setIcon(new ImageIcon("res\\registrar.png"));

        this.add(botaoRegistrar);

        botaoVoltar(this, this);

        panelCadastro.setBounds(tamanhoTela);
        this.add(panelCadastro);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == labelBack) {
            new AndroidLogin(android);
        }
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
