/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author AYU7-WN
 */
public class IconeAplication {
    
    public static Image getIcone(){
        URL url = new IconeAplication().getClass().getResource("/Images/book48.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        return imagemTitulo;
    }
    
}
