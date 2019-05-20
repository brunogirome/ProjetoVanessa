package ProjetoVanessa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RuaVO {

    private int id;
    private String desc;
    private int x;
    private int y;
    private int larg;
    private int altu;
    private int id_rua;
    private double loc;

    public RuaVO(int id, String desc, int x, int y, int larg, int altu, int id_rua, double loc) {
        this.id = id;
        this.desc = desc;
        this.x = x;
        this.y = y;
        this.larg = defLarg();
        this.altu = defAltu();
        this.id_rua = id_rua;
        this.loc = loc;
    }

    private int defLarg() {
        if (this.altu == this.y) {
            return x;
        } else {
            return 6;
        }
    }

    private int defAltu() {
        if (this.larg == this.x) {
            return y;
        } else {
            return 6;
        }
    }

    public void desenharRUA(Graphics2D g2d, int cX, int cY) {
        boolean desenhar = false;
        for (Eventos evento : Control.ListaEventos) {
            if (getBounds().intersects(evento.getBounds())) {
                desenhar = true;
            }
        }
        for (Areas area : Control.ListaAreas) {
            if (getBounds().intersects(area.getBounds())) {
                desenhar = true;
            }
        }
        if ((cX < larg + x && cY < altu + y) && desenhar) {
            g2d.setColor(new Color(0, 160, 0, 50));
            g2d.fillRect(x - cX, (20 + y) - cY, larg, altu);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public int getLarg() {
        return larg;
    }

    public void setLarg(int larg) {
        this.larg = larg;
    }

    public int getAltu() {
        return altu;
    }

    public void setAltu(int altu) {
        this.altu = altu;
    }

    public int getId_rua() {
        return id_rua;
    }

    public void setId_rua(int id_rua) {
        this.id_rua = id_rua;
    }

    public double getLoc() {
        return loc;
    }

    public void setLoc(double loc) {
        this.loc = loc;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, larg, altu);
    }
}
