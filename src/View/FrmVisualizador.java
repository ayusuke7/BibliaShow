package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author AYU7-WN
 */
public class FrmVisualizador extends javax.swing.JFrame {

    private BufferedImage background;
    private Color color;

    /**
     * Creates new form FrmVisualizador
     *
     */
    public FrmVisualizador() {
        initComponents();
        this.setExtendedState(FrmVisualizador.MAXIMIZED_BOTH);
        this.setFocusableWindowState(false);

        setAcessibilidade();
    }

    private void setAcessibilidade() {

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        getRootPane().getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public void setBackground(BufferedImage image) {

        if (image != null) {
            this.background = image;
            this.repaint();
        }

    }

    public void removeBackground() {
        this.background = null;
        this.repaint();
    }

    @Override
    public void setBackground(Color color) {
        this.color = color;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackg = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (background != null) {
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
                }else{
                    this.setBackground(color);
                }
            }
        };
        lbTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout panelBackgLayout = new javax.swing.GroupLayout(panelBackg);
        panelBackg.setLayout(panelBackgLayout);
        panelBackgLayout.setHorizontalGroup(
            panelBackgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        panelBackgLayout.setVerticalGroup(
            panelBackgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbTexto;
    private javax.swing.JPanel panelBackg;
    // End of variables declaration//GEN-END:variables
}
