/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

/**
 *
 * @author YU7
 */
public class Livro {

    private int id_livro;
    private String testamento;
    private String nome_livro;
    private String abrev;

    public Livro() {}

    public Livro(int id_livro, String testamento, String abrev, String nome_livro) {
        this.id_livro = id_livro;
        this.testamento = testamento;
        this.nome_livro = nome_livro;
        this.abrev = abrev;
    }

      /**
     * @return the abrev
     */
    public String getAbrev() {
        return abrev;
    }

    /**
     * @param abrev the abrev to set
     */
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }
    
    /**
     * @return the id_livro
     */
    public int getId_livro() {
        return id_livro;
    }

    /**
     * @param id_livro the id_livro to set
     */
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    /**
     * @return the testamento
     */
    public String getTestamento() {
        return testamento;
    }

    /**
     * @param testamento the testamento to set
     */
    public void setTestamento(String testamento) {
        this.testamento = testamento;
    }

    /**
     * @return the nome_livro
     */
    public String getNome_livro() {
        return nome_livro;
    }

    /**
     * @param nome_livro the nome_livro to set
     */
    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }
    
    
    
}
