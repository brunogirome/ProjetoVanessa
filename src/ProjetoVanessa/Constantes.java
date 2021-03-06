package ProjetoVanessa;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public interface Constantes {

    //Constantes de formatação
    public final static DecimalFormat FORMATO_MIN = new DecimalFormat("00");
    public final static DecimalFormat FORMATO_HORA = new DecimalFormat("0");

    //Cores básicas da aplicação
    public final static Color AZUL1 = new Color(23, 163, 224);
    public final static Color AZUL2 = new Color(0, 116, 174);
    public final static Color AZUL3 = new Color(103, 212, 255);
    public final static Color CINZACLARO = new Color(30, 30, 30);
    public final static Color CINZAESC = new Color(18, 18, 18);
    public final static Color CINZATOPO = new Color(55, 55, 55);

    public static final String Century = "Century Gothic";
    public static final String MSanSerif = "Microsoft Sans Serif";

    public static final SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm");
    public static final DateTimeFormatter horaSQL = DateTimeFormatter.ofPattern("HH:mm");

}
