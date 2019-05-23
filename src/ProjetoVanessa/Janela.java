package ProjetoVanessa;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Janela {

    int xx, xy;

    public Janela(Container painel, String titulo, int altura, int largura, int closeOP) {
        JFrame frame = new JFrame(titulo);

        Dimension tamanho = new Dimension(altura, largura);
        painel.setMinimumSize(tamanho);
        painel.setMaximumSize(tamanho);
        painel.setPreferredSize(tamanho);

        painel.setLayout(new GridLayout(1, 1));

        frame.setDefaultCloseOperation(closeOP);
        frame.setResizable(false);
        frame.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public Janela(JFrame frame, Container painel, String titulo, int altura, int largura, int closeOP, boolean undecorated) {
        frame.setTitle(titulo);
        frame.setUndecorated(undecorated);
        frame.setBackground(new Color(0, 0, 0, 0));

        Dimension tamanho = new Dimension(altura, largura);
        painel.setMinimumSize(tamanho);
        painel.setMaximumSize(tamanho);
        painel.setPreferredSize(tamanho);
////
////        JPanel shadowPanel = new JPanel(new BorderLayout()) {
////            @Override
////            protected void paintComponent(Graphics g) {
////                Graphics2D g2d = (Graphics2D) g.create();
////                applyQualityRenderingHints(g2d);
////                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
////                g2d.fillRect(10, 10, getWidth(), getHeight());
////                g2d.dispose();
////            }
////
////        };
////
////        shadowPanel.setOpaque(false);
////        shadowPanel.setBackground(Color.BLACK);
////        shadowPanel.setBorder(new EmptyBorder(0, 0, 20, 20));
////        painel.setLayout(new GridLayout(1, 1));
        
        painel.setLayout(null);

        frame.setDefaultCloseOperation(closeOP);
        frame.setResizable(false);
        frame.setContentPane(painel);
////        frame.setContentPane(shadowPanel);
////        shadowPanel.add(painel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);

    }

    private void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

}
