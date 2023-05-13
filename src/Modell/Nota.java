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
public class Nota {

    private int codigo;
    private int livro;
    private int capitulo;
    private String nota;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the livro
     */
    public int getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(int livro) {
        this.livro = livro;
    }

    /**
     * @return the capitulo
     */
    public int getCapitulo() {
        return capitulo;
    }

    /**
     * @param capitulo the capitulo to set
     */
    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

}
