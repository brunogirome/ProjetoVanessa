package ProjetoVanessa;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Eventos {

    private int x = 0;
    private int y = 0;
    private TipoEventos evento;
    private final int TAM_IMAGEM = 24;
    private Rua rua;
    private double desloc;

    public Eventos(Rua rua, TipoEventos evento, double desloc) {
        this.rua = rua;
        this.evento = evento;
        this.desloc = desloc;

        defXY();
    }

    private void defXY() {
        if (rua.getX() == (rua.getX() + rua.getLarg()) - 6) {
            this.x = rua.getX() + 3;
            this.y = (int) (rua.getAltu() * desloc);
        } else if (rua.getY() == (rua.getY() + rua.getAltu()) - 6) {
            this.x = (int) (rua.getLarg() * desloc);
            this.y = rua.getY() + 3;
        } else {

        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 1, 1);
    }

    public void desenharEvento(Graphics2D g2d, int cX, int cY) {
        Android.Android.desenharObjeto(x, y, cX, cY, TAM_IMAGEM, g2d, "res\\" + this.evento + ".png");
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "{" + " x='" + getX() + "'" + ", y='" + getY() + "'" + ", evento='" + evento + "'" + ", TAM_IMAGEM='"
                + TAM_IMAGEM + "'" + ", rua='" + rua.getDesc() + "'" + ", desloc='" + desloc + "'" + "}";
    }

}
