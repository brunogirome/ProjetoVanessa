package ProjetoVanessa;

import java.awt.Graphics2D;

public class Eventos {

    public int x, y;
    private TipoEventos evento;

    private final int TAM_IMAGEM = 24;

    public Eventos(int x, int y, TipoEventos evento) {
        this.x = x;
        this.y = y;
        this.evento = evento;
    }

    public void desenharEvento(Graphics2D g2d, int cX, int cY) {
        Android.Android.desenharObjeto(x, y, cX, cY, TAM_IMAGEM, g2d, "res\\" + this.evento + ".png");
    }

}
