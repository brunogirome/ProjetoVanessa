package ProjetoVanessa;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Eventos {

    public int x, y;
    private TipoEventos evento;

    private final int TAM_IMAGEM = 24;

    private RuaVO rua;

    public Eventos(RuaVO rua, TipoEventos evento) {

        this.evento = evento;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 1, 1);
    }

    public void desenharEvento(Graphics2D g2d, int cX, int cY) {
        Android.Android.desenharObjeto(x, y, cX, cY, TAM_IMAGEM, g2d, "res\\" + this.evento + ".png");
    }

}
