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
public class Versiculo {

    private int codigo;
    private int livro;
    private int capitulo;
    private int versiculo;
    private String texto;
    private boolean favorito;

    public Versiculo() {
    }

    public Versiculo(int codigo, int livro, int capitulo, int versiculo, String texto, boolean favorito) {
        this.codigo = codigo;
        this.livro = livro;
        this.capitulo = capitulo;
        this.versiculo = versiculo;
        this.texto = texto;
        this.favorito = favorito;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public int getVersiculo() {
        return versiculo;
    }

    public void setVersiculo(int versiculo) {
        this.versiculo = versiculo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the favorito
     */
    public boolean isFavorito() {
        return favorito;
    }

    /**
     * @param favorito the favorito to set
     */
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

}
