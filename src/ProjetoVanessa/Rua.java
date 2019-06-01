package ProjetoVanessa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rua extends Conexoes {

    private final int id;
    private final String desc;
    private final int x;
    private final int y;
    private int larg;
    private int altu;

    private boolean vertical;

    public Rua(int id, String desc, int x, int y, int larg, int altu) {
        this.id = id;
        this.desc = desc;
        this.x = x;
        this.y = y;
        this.larg = larg;
        this.altu = altu;
        corrigirDados();
    }

    private void corrigirDados() {
        if (y == altu) {
            altu = 5;
            this.larg = this.larg - x;
        } else if (x == larg) {
            larg = 5;
            this.altu = this.altu - y;
        }
    }

    public void desenharRua(Graphics2D g2d, int cX, int cY) {
        /*
         * boolean desenhar = false; for (Eventos evento : Control.ListaEventos) { if
         * (getBounds().intersects(evento.getBounds())) { desenhar = true; } } for
         * (Areas area : Control.ListaAreas) { if
         * (getBounds().intersects(area.getBounds())) { desenhar = true; } }
         */
////        int x = this.x;
////        int y = this.y;
////        int w = this.larg;
////        int h = this.larg;
        if ((cX < larg + x && cY < altu + y)) {
            //g2d.setColor(new Color(0, 255, 0, 50));
            g2d.setColor(new Color(0, 255, 0, 128));
            g2d.fillRect(x - cX, (20 + y) - cY, larg, altu);
            //System.out.println("RUA: " + desc + "\nDESENHANDO NA POSIÇÃO: [X: " + (x - cX) + "][Y: " + (20 + y - cY) + "][LARG: " + larg + "][ALTU: " + altu + "]");
        }
    }

    public static void carregarRuas() {
        try {
            stmt = con.prepareStatement("SELECT * FROM RUAS");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Control.LISTAS_RUAS.add(new Rua(rs.getInt("RUA_ID_PK"),
                        rs.getString("RUA_DESC"),
                        rs.getInt("RUA_X"),
                        rs.getInt("RUA_Y"),
                        rs.getInt("RUA_W"),
                        rs.getInt("RUA_H"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar rua: \n" + e);
        } finally {
            fecharConexao(con, stmt, rs);
        }
    }

    public static String[] ruasStrings() {
        String[] stringReturn = new String[Control.LISTAS_RUAS.size()];
        for (int i = 0; i < Control.LISTAS_RUAS.size(); i++) {
            stringReturn[i] = Control.LISTAS_RUAS.get(i).getDesc();
        }
        return stringReturn;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, larg, altu);
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLarg() {
        return larg;
    }

    public int getAltu() {
        return altu;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", desc='" + getDesc() + "'"
                + ", x='" + getX() + "'"
                + ", y='" + getY() + "'"
                + ", larg='" + getLarg() + "'"
                + ", altu='" + getAltu() + "'"
                + "}";
    }

}
