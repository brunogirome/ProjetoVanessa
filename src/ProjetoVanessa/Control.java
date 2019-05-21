package ProjetoVanessa;

import ControleClima.ControleClima;
import Android.Android;
import static ProjetoVanessa.Control.hora;
import static ProjetoVanessa.Control.minutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Control implements Constantes {

    // https://leafletjs.com/examples/quick-start/
    public static int hora = 1;
    public static int minutos = 0;

    public static String Horario = "00:00";

    public static Android Android;

    public static List<Areas> ListaAreas = new ArrayList<>();

    public static List<Eventos> ListaEventos = new ArrayList<>();

    public static List<Rua> ListaRuas = new ArrayList<>();

    public Control() {
        new ControleClima();

        ListaRuas.add(new Rua(1, "rua 1", 3, 3, 1194, 3));

        System.out.println(ListaRuas.get(0).toString());

        ListaEventos.add(new Eventos(ListaRuas.get(0), TipoEventos.qArvore, 0.5));

        System.out.println(ListaEventos.get(0).toString());

        Android = new Android(500, 880);
        Android.revalidate();

        timer.start();
    }

    private void atualizarHora() {
        minutos++;
        if (minutos > 60) {
            hora++;
            minutos = 0;
            if (hora > 23) {
                hora = 0;
            }
        }

        Horario = Control.FORMATO_HORA.format(hora) + ":" + Control.FORMATO_MIN.format(minutos);
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException e) {
            System.out.println("Erro no Look and Feel:\n" + e);
        }
        new Control();

    }

}
