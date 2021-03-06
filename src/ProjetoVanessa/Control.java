package ProjetoVanessa;

import Android.Android;
import static ProjetoVanessa.Control.hora;
import static ProjetoVanessa.Control.minutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Control implements Constantes {

    public static int hora = 0;
    public static int minutos = 0;

    public static Time Horario = updateHora();

    public static List<Areas> ListaAreas = new ArrayList<>();

    public static List<Eventos> ListaEventos = new ArrayList<>();

    public static final List<Rua> LISTAS_RUAS = new ArrayList<>();

    public static List<Android> ListaAndroid = new ArrayList<>();

    public Control() {
        Rua.carregarRuas();

        //ListaAndroid.add(new Android(new Usuario(LISTAS_RUAS.get(24), 0.7), new JFrame(), 23, 0.5f, 10));
        //ListaEventos.add(new Eventos(LISTAS_RUAS.get(23), TipoEventos.qArvore, 0.9));
        //ListaAreas.add(new Areas(0, 0, 500, 300, TipoEventos.chuva));
        new ControleClima.ControleClima();

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

        for (Android android : ListaAndroid) {
            android.repaint();
        }

        Horario = updateHora();
        checarRotas();
    }

    private static Time updateHora() {
        return Time.valueOf(FORMATO_HORA.format(hora) + ":" + FORMATO_MIN.format(minutos) + ":00");
    }

    private void checarRotas() {
        for (Android android : ListaAndroid) {
            for (Rotas rota : android.getRotasUser()) {
                if (rota.getIni().getTime() <= Horario.getTime() && rota.getFim().getTime() >= Horario.getTime()) {
                    System.out.println(rota.getDesc() + " está sendo analizada.");
                    for (Rua rua : rota.getRuas()) {
                        for (Eventos evento : ListaEventos) {
                            //if (rua.getBounds().intersects(evento.getBounds())) {
                            if (rua.getBounds().intersects(evento.getBounds())) {
                                if (evento.getTipo() == TipoEventos.qArvore) {
                                    rota.setqArvore(true);
                                }
                                if (evento.getTipo() == TipoEventos.qPoste) {
                                    rota.setqPoste(true);
                                }
                                if (evento.getTipo() == TipoEventos.acidente) {
                                    rota.setAcidente(true);
                                }
                                if (evento.getTipo() == TipoEventos.qLuz) {
                                    rota.setqLuz(true);
                                }
                            }
                        }
                        for (Areas area : ListaAreas) {
                            if (rua.getBounds().intersects(area.getBounds())) {
                                rota.setAlertar(true);
                                if (area.getTipo() == TipoEventos.alagamento) {
                                    rota.setAlagamento(true);
                                } else if (area.getTipo() == TipoEventos.tempestade) {
                                    rota.setTempestade(true);
                                } else if (area.getTipo() == TipoEventos.chuva) {
                                    rota.setChuva(true);
                                } else {
                                    rota.setAlagamento(false);
                                    rota.setTempestade(false);
                                    rota.setChuva(false);
                                }
                            } else {
                                rota.setAlertar(false);
                            }
                        }
                    }

                } else {
                    rota.setAlertar(false);
                }
            }
        }
    }

    protected Timer timer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarHora();

            System.out.println("Hora atual: " + Horario.toString());
            System.out.println("------------------------");
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
