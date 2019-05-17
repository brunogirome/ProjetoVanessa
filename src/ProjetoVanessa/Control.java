package ProjetoVanessa;

import Android.Android;
import static ProjetoVanessa.Control.hora;
import static ProjetoVanessa.Control.minutos;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Control {
    
    //https://leafletjs.com/examples/quick-start/

    public static int hora = 1;
    public static int minutos = 0;

    public static String Horario = "00:00";

    public static Android Android;

    public static List<Rectangle> Chuva = new ArrayList<>();

    public static List<Rectangle> Alagamentos = new ArrayList<>();

    public static List<Eventos> Eventos = new ArrayList<>();

    public Control() {
        new Controladora();

        Android = new Android(115, 350);
        Android.revalidate();

        timer.start();
    }

    public static DecimalFormat fmtMin = new DecimalFormat("00");
    public static DecimalFormat fmtHora = new DecimalFormat(" 0");

    private void atualizarHora() {
        minutos++;
        if (minutos > 60) {
            hora++;
            minutos = 0;
            if (hora > 23) {
                hora = 0;
            }
        }

        Horario = Control.fmtHora.format(hora) + ":" + Control.fmtMin.format(minutos);
        Android.repaint();
    }

    protected Timer timer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarHora();
        }
    });

    public static BufferedImage buscarImagem(String local) {
        try {
            return ImageIO.read(new File(local));
        } catch (IOException e) {
            System.out.println("Erro ao carregar imagem:\n" + e);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Erro no Look and Feel:\n" + e);
        }
        new Control();
    }

}
