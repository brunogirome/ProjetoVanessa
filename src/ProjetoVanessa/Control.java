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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Control implements Constantes {

    // https://leafletjs.com/examples/quick-start/
    public static int hora = 1;
    public static int minutos = 0;

    public static String Horario = "00:00";

    public Android Android;

    public Android Android2;

    public Android Android3;

    public static List<Areas> ListaAreas = new ArrayList<>();

    public static List<Eventos> ListaEventos = new ArrayList<>();

    public static final List<Rua> LISTAS_RUAS = new ArrayList<>();

    public Control() {
        new ControleClima();

        Rua.carregarRuas();

        for (Rua rua : LISTAS_RUAS) {
            System.out.println(rua.toString());
        }

        ListaAreas.add(new Areas(0, 0, 300, 540, TipoEventos.chuva));

        //ListaEventos.add(new Eventos(LISTAS_RUAS.get(0), TipoEventos.qArvore, 0.5));
        Android = new Android(new Usuario(1, "Ze", 500, 600), new JFrame());
        Android.revalidate();

//        Android = new Android(new Usuario(2, "antony", 50, 80), new JFrame());
//        Android.revalidate();
//
//        Android = new Android(new Usuario(3, "maria", 900, 600), new JFrame());
//        Android.revalidate();

        ListaEventos.add(new Eventos(LISTAS_RUAS.get(23), TipoEventos.qArvore, 0.2));
        ListaEventos.add(new Eventos(LISTAS_RUAS.get(6), TipoEventos.qArvore, 0.132));
//
//        Android2 = new Android(new Usuario(2, "Zezinho zika", 900, 200), new JFrame());
//        Android2.revalidate();
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

//        Android.repaint();
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
