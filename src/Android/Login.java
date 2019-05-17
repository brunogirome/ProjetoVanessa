package Android;

import ProjetoVanessa.Control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TextField;
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
import javax.swing.text.JTextComponent;

public class Login extends Telas implements MouseListener {

    private static final long serialVersionUID = 2797310196318049029L;

    private JButton entrar;

    private JLabel criarCadastro = new JLabel("Criar Cadastro");

    private JPanel painelLogin = new JPanel(null) {

        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            desenharBackground(g2d);

            g2d.drawImage(Control.buscarImagem("res\\logo.png"), 63, 85, 174, 150, null);

            g2d.setColor(Color.white);
            g2d.drawImage(Control.buscarImagem("res\\iconuser.png"), 63, 290, 20, 20, null);
            g2d.fillRect(63, 315, 194, 2);

            g2d.drawImage(Control.buscarImagem("res\\iconpass.png"), 63, 330, 20, 20, null);
            g2d.fillRect(63, 355, 194, 2);

            desenharFundo(g2d);

        }

    };

    private JTextField campoLogin = new JTextField();

    private JPasswordField campoPw = new JPasswordField();

    public Login(JFrame frame) {
        super(frame);

        criarCampo(campoLogin, "Usuário", new Rectangle(88, 295, 169, 30), fonteCampos, this, this);

        criarCampo(campoPw, "Senha", new Rectangle(88, 335, 169, 30), new Font("", 0, 16), this, this);

        entrar = new JButton();
        entrar.setIcon(new ImageIcon("res\\entrarW.png"));
        entrar.setBounds(63, 385, 194, 45);
        entrar.addMouseListener(this);
        this.add(entrar);

        criarCadastro.setBounds(63, 450, 194, 20);
        criarCadastro.setForeground(Color.white);
        criarCadastro.setFont(new Font("Century Gothic", 0, 14));
        criarCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        criarCadastro.addMouseListener(this);
        this.add(criarCadastro);

        painelLogin.setBounds(tamanhoTela);
        this.add(painelLogin);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getSource() == campoLogin) {
//            campoLogin.setText("");
//            campoLogin.setForeground(Color.white);
//        }
//
//        if (e.getSource() == campoPw) {
//            campoPw.setText("");
//            campoPw.setForeground(Color.white);
//        }

        if (e.getSource() == entrar) {
            new Home(Android.Frame);
            //criarCadastro.setVisible(false);
        }

        if (e.getSource() == criarCadastro) {
            new Cadastro(Android.Frame);
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
        if (e.getSource() == criarCadastro) {
            criarCadastro.setText("<html><u>Criar Cadastro");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == criarCadastro) {
            criarCadastro.setText("Criar Cadastro");
        }
    }

}
