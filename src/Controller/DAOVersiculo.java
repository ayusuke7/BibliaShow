package Controller;

import Modell.Versiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YU7
 */
public class DAOVersiculo {

    private final Conexao con;

    public DAOVersiculo() {
        this.con = new Conexao();
    }

    public Versiculo getVersiculo(int codigo) {

        Versiculo vers = new Versiculo();
        con.Conectar();

        try {
            con.executaSQL("SELECT * FROM Versiculos WHERE Codigo=?");
            if (con.rs.first()) {
                vers.setCodigo(con.rs.getInt("Codigo"));
                vers.setLivro(con.rs.getInt("Livro"));
                vers.setCapitulo(con.rs.getInt("Capitulo"));
                vers.setVersiculo(con.rs.getInt("Versiculo"));
                vers.setTexto(con.rs.getString("Descricao"));
                vers.setFavorito(con.rs.getBoolean("Favorito"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOLivro.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return vers;
    }

    public ArrayList<Versiculo> listVersiculos(String sql) {

        ArrayList<Versiculo> versiculos = new ArrayList<>();

        con.Conectar();
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                do {
                    versiculos.add(new Versiculo(
                            con.rs.getInt("Codigo"),
                            con.rs.getInt("Livro"),
                            con.rs.getInt("Capitulo"),
                            con.rs.getInt("Versiculo"),
                            con.rs.getString("Descricao"),
                            con.rs.getBoolean("Favorito")));
                } while (con.rs.next());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOLivro.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return versiculos;

    }

    public boolean setFavorito(int codigo, boolean favorito) {

        con.Conectar();

        try {

            String sql = "UPDATE Versiculos SET Favorito=? WHERE Codigo=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setBoolean(1, favorito);
            pst.setInt(2, codigo);
            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return false;

    }

    public ArrayList<Versiculo> sortVersiculos(){
        
        String sql = "SELECT TOP 10 * FROM Versiculos ORDER BY Rnd(Len(Descricao))";
        ArrayList<Versiculo> versiculos = listVersiculos(sql);
        return versiculos;
        
    }
    
}
