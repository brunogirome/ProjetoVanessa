package ProjetoVanessa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Rotas {

    /*
     chuva,
     tempestade,
     alagamento,
     qArvore,
     qLuz,
     acidente
     */
    private int id;
    private String desc;
    private Time ini;
    private Time fim;
    private Rua[] ruas;
    private boolean chuva;
    private boolean tempestade;
    private boolean alagamento;
    private boolean qLuz;
    private boolean qArvore;
    private boolean qPoste;
    private boolean acidente;

    public Rotas(int id, String desc, Time ini, Time fim) {
        this.id = id;
        this.desc = desc;
        this.ini = ini;
        this.fim = fim;
    }

    private Rua[] buscarRuas() {
        //select banco

        /*for ( ) {
         return null;
         }*/
        return null;
    }

    public static void subirRotas() {
        Conexoes.abrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs;
        Rotas rota;
        try {
            rs = stmt.executeQuery("SELECT * FROM Rotas");
            rota = new Rotas(rs.getInt("ROTA_ID_PK"),
                    rs.getString("ROTA_DESC"),
                    rs.getTime("ROTA_INI"),
                    rs.getTime("ROTA_FIM")
            );
        } catch (SQLException e) {
            System.out.println("Erro ao subir rotas: " + e);
        }

    }

}
