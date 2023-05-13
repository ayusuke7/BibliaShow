package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * Classe responsavel por conectar/desconectar com o Banco de Dados função de
 * executar comandosSQL
 *
 * @author YU7
 */
public class Conexao {

    public Statement stm;
    public ResultSet rs;
    public Connection con;

    private final String driver;
    private final String caminho;
    private final String senha;
    private final String install;// = System.getProperty("user.dir");

    public Conexao() {

        this.install = System.getProperty("user.dir");
        this.driver = "net.ucanaccess.jdbc.UcanaccessDriver";
        this.caminho = "jdbc:ucanaccess://" + install + "/data/bibliadb.accdb;memory=false";
        this.senha = "";

    }

    public boolean Conectar() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(caminho, "", senha);
            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "ERRO AO CONECTAR COM BANCO DE DADOS", "PROBLEMAS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean Desconectar() {

        try {
            con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "ERRO AO DESCONECTAR DO BANCO DE DADOS", "PROBLEMAS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void executaSQL(String sql) {

        try {

            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "ERRO AO EXECUTAR QUERY", "PROBLEMAS", JOptionPane.ERROR_MESSAGE);
        }
    }

}
