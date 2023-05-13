/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modell.Nota;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YU7
 */
public class DAONota {

    private final Conexao con;

    public DAONota() {
        this.con = new Conexao();
    }

    public Nota getNota(int livro, int capitulo) {

        Nota nota = new Nota();

        con.Conectar();
        con.executaSQL("SELECT * FROM Notas WHERE Livro=" + livro + " AND Capitulo=" + capitulo);
        try {
            if (con.rs.first()) {
                do {
                    nota.setCodigo(con.rs.getInt("Codigo"));
                    nota.setLivro(con.rs.getInt("Livro"));
                    nota.setCapitulo(con.rs.getInt("Capitulo"));
                    nota.setNota(con.rs.getString("Nota"));
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return nota;

    }

    public boolean addNota(Nota nota) {

        con.Conectar();
        try {
            String sql = "INSERT INTO Notas (Livro, Capitulo, Nota) values (?,?,?)";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setInt(1, nota.getLivro());
            pst.setInt(2, nota.getCapitulo());
            pst.setString(3, nota.getNota());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Nota adicionada");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return false;

    }

    public boolean deleteNota(int codigo) {

        con.Conectar();
        try {
            String sql = "DELETE FROM Notas WHERE Codigo=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Nota removida");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.Desconectar();
        return false;
    }

    public boolean updateNota(Nota nota) {

        con.Conectar();
        try {
            String sql = "UPDATE Notas SET Nota=? WHERE Codigo=?";
            PreparedStatement pst = con.con.prepareStatement(sql);
            pst.setString(1, nota.getNota());
            pst.setInt(2, nota.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Nota atualizada");
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return false;

    }

    public ArrayList<Nota> listNotas() {

        ArrayList<Nota> notas = new ArrayList<>();

        con.Conectar();
        con.executaSQL("SELECT * FROM Notas");
        try {
            if (con.rs.first()) {
                do {
                    Nota nota = new Nota();
                    nota.setCodigo(con.rs.getInt("Codigo"));
                    nota.setLivro(con.rs.getInt("Livro"));
                    nota.setCapitulo(con.rs.getInt("Capitulo"));
                    nota.setNota(con.rs.getString("Nota"));
                    notas.add(nota);
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAONota.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return notas;
    }

}
