/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AYU7-WN
 */
public class AplicarLookAndFeel {

    private final Component component;

    public AplicarLookAndFeel(Component component) {
        this.component = component;
    }

    public void aplicar(String tema) {

        switch (tema) {
            case "Acryl":
                setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                break;
            case "Aluminium":
                setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                break;
            case "Luna":
                setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                break;
            case "Mint":
                setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
                break;
            case "Smart":
                setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                break;
            case "Windows":
                setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Nimbus":
                setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
        }

    }

    private void setLookAndFeel(String tema) {
        try {
            javax.swing.UIManager.setLookAndFeel(tema);
            javax.swing.SwingUtilities.updateComponentTreeUI(component);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO APLICAR SKIN\n" + ex.getMessage(), "AVISO", JOptionPane.OK_OPTION);
        }
    }

}
