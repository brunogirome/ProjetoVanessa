package ProjetoVanessa;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Eventos {

    private int x = 0;
    private int y = 0;
    private final TipoEventos evento;
    private final int TAM_IMAGEM = 36;
    private final Rua rua;
    private final double desloc;

    public Eventos(Rua rua, TipoEventos evento, double desloc) {
        this.rua = rua;
        this.evento = evento;
        this.desloc = desloc;

        defXY();
    }

    private void defXY() {
        if (rua.getX() == (rua.getX() + rua.getLarg()) - 5) {
            this.x = rua.getX() + 2;
            this.y = rua.getY() + (int) (rua.getAltu() * desloc);
        } else if (rua.getY() == (rua.getY() + rua.getAltu()) - 5) {
            this.x = rua.getX() + (int) (rua.getLarg() * desloc);
            this.y = rua.getY() + 2;
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

    public TipoEventos getTipo() {
        return this.evento;
    }

    @Override
    public String toString() {
        return "{" + " x='" + getX() + "'" + ", y='" + getY() + "'" + ", evento='" + evento + "'" + ", TAM_IMAGEM='"
                + TAM_IMAGEM + "'" + ", rua='" + rua.getDesc() + "'" + ", desloc='" + desloc + "'" + "}";
    }

}
