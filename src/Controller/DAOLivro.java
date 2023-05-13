/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modell.Informacao;
import Modell.Livro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YU7
 */
public class DAOLivro {

    private final Conexao con;

    public DAOLivro() {this.con = new Conexao();}

    public Livro getLivro(int codigo) {

        Livro livro = new Livro();
        try {
            con.Conectar();
            con.executaSQL("SELECT * FROM LIVROS WHERE Livro="+codigo);
            
            if(con.rs.first()){
                livro.setId_livro(con.rs.getInt("Livro"));
                livro.setTestamento(con.rs.getString("Testamento"));
                livro.setAbrev(con.rs.getString("Abreviacao"));
                livro.setNome_livro(con.rs.getString("Nome"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.Desconectar();
        return livro;
    }

    public ArrayList<Livro> listLivros(String sql) {

        ArrayList<Livro> livros = new ArrayList<>();

        con.Conectar();
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                do {
                    livros.add(new Livro(con.rs.getInt("Livro"),
                            con.rs.getString("Testamento"), 
                            con.rs.getString("Abreviacao"),
                            con.rs.getString("Nome")));
                } while (con.rs.next());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOLivro.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.Desconectar();
        return livros;
    }

    public Informacao getInfomacao(int livro){
        
        Informacao info = new Informacao();
        
        try {
            con.Conectar();
            con.executaSQL("SELECT * FROM Informacoes WHERE Livro="+livro);
            
            if(con.rs.first()){
                info.setChave(con.rs.getString("Chave"));
                info.setInfo(con.rs.getString("Info"));
                info.setFonte(con.rs.getString("Fonte"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.Desconectar();
        return info;
        
    }
    
}
