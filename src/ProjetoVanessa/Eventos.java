package ProjetoVanessa;

import java.awt.Graphics2D;

public class Eventos {

    private int x, y;
    private TipoEventos evento;

    private final int TAM_IMAGEM = 24;

    public Eventos(int x, int y, TipoEventos evento) {
        this.x = x;
        this.y = y;
        this.evento = evento;
    }

    public void desenharEvento(Graphics2D g2d, int xMapa, int yMapa) {
        Android.Android.desenharObjeto(x, y, xMapa, yMapa, TAM_IMAGEM, g2d, "res\\" + this.evento + ".png");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TipoEventos getEvento() {
        return evento;
    }

    public void setEvento(TipoEventos evento) {
        this.evento = evento;
    }

}
