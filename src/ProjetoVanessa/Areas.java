package ProjetoVanessa;

import Android.Android;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

public class Areas {

    public int x, y;

    public int comp, altu;

    private TipoEventos evento;

    private final int TAM_ICONE = 32;

    private Color c1 = null, c2 = null;

    public Areas(int x, int y, int comp, int altu, TipoEventos evento) {
        this.x = x;
        this.y = y;
        this.comp = comp;
        this.altu = altu;
        this.evento = evento;

        checarCor();
    }

    public void desenharArea(Graphics2D g2d, int cX, int cY) {
        //RuaX < areax + areaw
        if ((cX < comp + x && cY < altu + y)) {
            g2d.setColor(c1);
            g2d.fillRect(x - cX, (20 + y) - cY, comp, altu);
            g2d.setColor(c2);
            g2d.drawRect(x - cX, (20 + y) - cY, comp, altu);
            Android.desenharObjeto((comp / 2) + x,
                    (altu / 2) + y,
                    cX,
                    cY,
                    TAM_ICONE,
                    g2d,
                    "res\\" + evento + ".png");
        }

    }

    private void checarCor() {
        switch (this.evento) {
            case chuva:
                c1 = new Color(45, 45, 90, 52);
                c2 = new Color(45, 45, 180, 128);
                break;
            case alagamento:
                break;
            default:
                throw new IllegalArgumentException("Tipo de evento inválido");
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.comp, this.altu);
    }

    /**
     * @deprecated Método de posicionamento do ícone referente a área no centro
     * da área visível no momento em X.<br>Atualmente não funcional.
     *
     */
    private int iconeX(int cX, Areas area) {
        int x = area.x;
        int comp = area.comp;

        if (x < cX) {
            x = 0;
        }
        if (comp > (cX + 300)) {
            comp = 300;
        }
        if (x == 0 && comp == 300) {
            return 150;
        } else {
            return ((x + comp) / 2) + (x - cX);
        }
    }

    /**
     * @deprecated Método de posicionamento do ícone referente a área no centro
     * da área visível no momento em Y.<br> Atualmente não funcional.
     *
     */
    private int iconeY(int cY, Areas area) {
        int y = area.y;
        int altu = area.altu;

        if (y < cY) {
            y = 0;
        }
        if (altu > (cY + 540)) {
            altu = 540;
        }
        if (y == 0 && altu == 540) {
            return 270;
        } else {
            return ((y + altu) / 2) + (y - cY);
        }
    }
}
