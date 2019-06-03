package ProjetoVanessa;

public class Usuario {

    private Rua rua;
    private int x;
    private int y;
    private double desloc;

    public Usuario(Rua rua, double desloc) {
        this.rua = rua;
        this.desloc = desloc;

        defXY(desloc);

    }

    private void defXY(double desloc) {
        if (rua.getX() == (rua.getX() + rua.getLarg()) - 5) {
            this.x = rua.getX() + 2;
            this.y = rua.getY() + (int) (rua.getAltu() * desloc);
        } else if (rua.getY() == (rua.getY() + rua.getAltu()) - 5) {
            this.x = rua.getX() + (int) (rua.getLarg() * desloc);
            this.y = rua.getY() + 2;
        } else {
        }
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

    public Rua getRua() {
        return rua;
    }

    public double getDesloc() {
        return desloc;
    }

}
