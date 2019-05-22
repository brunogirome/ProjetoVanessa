package ProjetoVanessa;

public class Usuario {

    private int id;
    private String nome;
    private Rua rua;
    private int x;
    private int y;
    private int tempLocal;
    private int ventoLocal;
    private double porcenChuva;

    public Usuario(int id, String nome, Rua rua, double desloc) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getTempLocal() {
        return tempLocal;
    }

    public void setTempLocal(int tempLocal) {
        this.tempLocal = tempLocal;
    }

    public int getVentoLocal() {
        return ventoLocal;
    }

    public void setVentoLocal(int ventoLocal) {
        this.ventoLocal = ventoLocal;
    }

    public double getPorcenChuva() {
        return porcenChuva;
    }

    public void setPorcenChuva(double porcenChuva) {
        this.porcenChuva = porcenChuva;
    }
    
    

}
