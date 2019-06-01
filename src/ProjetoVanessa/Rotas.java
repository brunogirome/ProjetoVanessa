package ProjetoVanessa;

import java.sql.Time;
import java.util.List;

public class Rotas extends Conexoes {

    private final int id;
    private final String desc;
    private final Time ini;
    private final Time fim;
    private final List<Rua> ruas;
    private boolean chuva;
    private boolean tempestade;
    private boolean alagamento;
    private boolean qLuz;
    private boolean qArvore;
    private boolean qPoste;
    private boolean acidente;
    private boolean alertar;

    public Rotas(int id, String desc, Time ini, Time fim, List<Rua> ruas) {
        this.id = id;
        this.desc = desc;
        this.ini = ini;
        this.fim = fim;
        this.ruas = ruas;
        this.chuva = false;
        this.tempestade = false;
        this.alagamento = false;
        this.qLuz = false;
        this.qArvore = false;
        this.qPoste = false;
        this.acidente = false;
        this.alertar = false;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Time getIni() {
        return ini;
    }

    public Time getFim() {
        return fim;
    }

    public List<Rua> getRuas() {
        return ruas;
    }

    public boolean isChuva() {
        return chuva;
    }

    public boolean isTempestade() {
        return tempestade;
    }

    public boolean isAlagamento() {
        return alagamento;
    }

    public boolean isqLuz() {
        return qLuz;
    }

    public boolean isqArvore() {
        return qArvore;
    }

    public boolean isqPoste() {
        return qPoste;
    }

    public boolean isAcidente() {
        return acidente;
    }

    public void setqPoste(boolean qPoste) {
        this.qPoste = qPoste;
    }

    public void setChuva(boolean chuva) {
        this.chuva = chuva;
    }

    public void setTempestade(boolean tempestade) {
        this.tempestade = tempestade;
    }

    public void setAlagamento(boolean alagamento) {
        this.alagamento = alagamento;
    }

    public void setqLuz(boolean qLuz) {
        this.qLuz = qLuz;
    }

    public void setqArvore(boolean qArvore) {
        this.qArvore = qArvore;
    }

    public void setAcidente(boolean acidente) {
        this.acidente = acidente;
    }

    public boolean isAlertar() {
        return alertar;
    }

    public void setAlertar(boolean alertar) {
        this.alertar = alertar;
    }

    @Override
    public String toString() {
        String aux = "\n\nLista de ruas: \n";
        aux = ruas.stream().map((rua) -> "\n" + rua.getDesc()).reduce(aux, String::concat);
        return "Rotas\n{" + "id=" + id + "\n, desc=" + desc + "\n, ini=" + ini + "\n, fim=" + fim + "\n, ruas=" + ruas + "\n, chuva=" + chuva + "\n, tempestade=" + tempestade + "\n, alagamento=" + alagamento + "\n, qLuz=" + qLuz + "\n, qArvore=" + qArvore + "\n, qPoste=" + qPoste + "\n, acidente=" + acidente + aux + '}';
    }

}
