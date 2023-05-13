package View.Panels;

import View.Dialogs.DialogImagens;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AYU7-WN
 */
public class PainelGaleria extends javax.swing.JPanel {

    private final String path = System.getProperty("user.dir");
    private DialogImagens dialog;

    /**
     * Creates new form PainelGaleria
     */
    public PainelGaleria() {
        initComponents();

    }

    private JLabel getLabelIcon(File f) {

        JLabel lb = new JLabel();
        ImageIcon image = new ImageIcon(f.getAbsolutePath());
        lb.setIcon(new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        lb.setToolTipText(f.getAbsolutePath());
        lb.setHorizontalAlignment(SwingConstants.CENTER);
        lb.setBorder(BorderFactory.createEmptyBorder());
        lb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (lb.getBorder() instanceof EmptyBorder) {
                    lb.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
                } else {
                    lb.setBorder(BorderFactory.createEmptyBorder());
                }
                checkTodasImgs.setSelected(false);
            }
        });

        return lb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnAdc = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        checkTodasImgs = new javax.swing.JCheckBox();
        btnShow = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelGaleria = new javax.swing.JPanel();

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personalizado", "Galeria" }));
        jComboBox1.setMaximumSize(new java.awt.Dimension(150, 33));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jComboBox1);

        btnAdc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addicon.png"))); // NOI18N
        btnAdc.setToolTipText("Adicionar Midia");
        btnAdc.setFocusable(false);
        btnAdc.setMaximumSize(new java.awt.Dimension(40, 50));
        btnAdc.setMinimumSize(new java.awt.Dimension(40, 50));
        btnAdc.setPreferredSize(new java.awt.Dimension(40, 50));
        btnAdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdcActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdc);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnRemover.setToolTipText("Remover Midia");
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setMaximumSize(new java.awt.Dimension(40, 50));
        btnRemover.setMinimumSize(new java.awt.Dimension(40, 50));
        btnRemover.setPreferredSize(new java.awt.Dimension(40, 50));
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);
        jToolBar1.add(jSeparator4);

        checkTodasImgs.setText("Selecionar todas");
        checkTodasImgs.setFocusable(false);
        checkTodasImgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodasImgsActionPerformed(evt);
            }
        });
        jToolBar1.add(checkTodasImgs);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png"))); // NOI18N
        btnShow.setToolTipText("Apresentação");
        btnShow.setFocusable(false);
        btnShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShow.setMaximumSize(new java.awt.Dimension(40, 50));
        btnShow.setMinimumSize(new java.awt.Dimension(40, 50));
        btnShow.setPreferredSize(new java.awt.Dimension(40, 50));
        btnShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShow);

        panelGaleria.setBackground(new java.awt.Color(255, 255, 255));
        panelGaleria.setLayout(new java.awt.GridLayout(0, 6, 2, 2));
        jScrollPane2.setViewportView(panelGaleria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdcActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        String[] ext = {"jpeg", "jpg", "png", "bmp"};
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Imagem", ext);
        busca.setFileFilter(filtro);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);
        busca.setMultiSelectionEnabled(true);

        if (busca.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File[] arquivos = busca.getSelectedFiles();
            for (File f : arquivos) {
                panelGaleria.add(getLabelIcon(f));
            }
        }

        repaint();

    }//GEN-LAST:event_btnAdcActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < panelGaleria.getComponentCount(); i++) {
            Component component = panelGaleria.getComponent(i);
            if (component instanceof JLabel) {
                JLabel lb = (JLabel) panelGaleria.getComponent(i);
                if (lb.getBorder() instanceof LineBorder) {
                    panelGaleria.remove(component);
                }
            }
        }

        repaint();

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        if (panelGaleria.getComponentCount() > 0) {

            ArrayList<File> files = new ArrayList<>();
            for (int i = 0; i < panelGaleria.getComponentCount(); i++) {
                if (panelGaleria.getComponent(i) instanceof JLabel) {
                    JLabel lb = (JLabel) panelGaleria.getComponent(i);
                    if (lb.getBorder() instanceof LineBorder) {
                        files.add(new File(lb.getToolTipText()));
                    }
                }
            }
            dialog = new DialogImagens(new JFrame(), true, files);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ADICIONE ALGUMA IMAGEM A GALERIA!");
        }


    }//GEN-LAST:event_btnShowActionPerformed

    private void checkTodasImgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodasImgsActionPerformed
        // TODO add your handling code here:

        Border border;

        if (checkTodasImgs.isSelected()) {
            border = BorderFactory.createLineBorder(Color.BLUE, 3);
        } else {
            border = BorderFactory.createEmptyBorder();
        }

        if (panelGaleria.getComponentCount() > 0) {
            for (int i = 0; i < panelGaleria.getComponentCount(); i++) {
                if (panelGaleria.getComponent(i) instanceof JLabel) {
                    JLabel lb = (JLabel) panelGaleria.getComponent(i);
                    lb.setBorder(border);
                }
            }
        }

    }//GEN-LAST:event_checkTodasImgsActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() > 0) {
            File[] pasta = new File(path + "/imagens").listFiles();
            for (File f : pasta) {
                panelGaleria.add(getLabelIcon(f));
            }
        } else {
            panelGaleria.removeAll();
            repaint();
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdc;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnShow;
    private javax.swing.JCheckBox checkTodasImgs;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelGaleria;
    // End of variables declaration//GEN-END:variables
}
