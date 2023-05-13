/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dialogs;

import View.FrmReprodutor;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

/**
 *
 * @author AYU7-WN
 */
public class DialogMediaPlayer extends javax.swing.JDialog {

    private final FrmReprodutor frm;
    private final File arquivo;

    public DialogMediaPlayer(java.awt.Frame parent, boolean modal, File arquivo, String vlc) {
        super(parent, modal);
        initComponents();
        setAcessibilidade();

        this.arquivo = arquivo;

        frm = new FrmReprodutor(this.arquivo, vlc);
        //frm.setVisible(true);
        setTelas();
        lbFilename.setText(arquivo.getName());
        frm.player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void positionChanged(MediaPlayer mp, float pos) {
                if (frm.isBand()) {
                    int value = Math.min(100, Math.round(pos * 100.0f));
                    slidTime.setValue(value);
                }
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {

            }

        });

    }

    private void setTelas() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] telas = ge.getScreenDevices();

        if (telas.length > 1) {
            for (GraphicsDevice g : telas) {
                g.setFullScreenWindow(frm);
            }
        } else {
            frm.setVisible(true);
        }

    }

    private void setAcessibilidade() {

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        getRootPane().getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.stop();
                frm.exit();
                dispose();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        toolbarControle = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        slidTime = new javax.swing.JSlider();
        lbVolume = new javax.swing.JLabel();
        slidVolume = new javax.swing.JSlider();
        lbFilename = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Player Biblia Show");
        setResizable(false);

        toolbarControle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolbarControle.setFloatable(false);
        toolbarControle.setRollover(true);
        toolbarControle.add(jSeparator1);

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play.png"))); // NOI18N
        btnPlay.setToolTipText("Play (Inicio)");
        btnPlay.setMaximumSize(new java.awt.Dimension(30, 50));
        btnPlay.setMinimumSize(new java.awt.Dimension(30, 50));
        btnPlay.setPreferredSize(new java.awt.Dimension(30, 50));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        toolbarControle.add(btnPlay);

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pasue.png"))); // NOI18N
        btnPause.setToolTipText("Pause / Continue");
        btnPause.setFocusable(false);
        btnPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPause.setMaximumSize(new java.awt.Dimension(40, 50));
        btnPause.setMinimumSize(new java.awt.Dimension(40, 50));
        btnPause.setPreferredSize(new java.awt.Dimension(40, 50));
        btnPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        toolbarControle.add(btnPause);

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stop.png"))); // NOI18N
        btnStop.setToolTipText("Parar / Sair (ESC)");
        btnStop.setFocusable(false);
        btnStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStop.setMaximumSize(new java.awt.Dimension(40, 50));
        btnStop.setMinimumSize(new java.awt.Dimension(40, 50));
        btnStop.setPreferredSize(new java.awt.Dimension(40, 50));
        btnStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        toolbarControle.add(btnStop);
        toolbarControle.add(jSeparator2);

        slidTime.setPaintTicks(true);
        slidTime.setValue(0);
        slidTime.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidTimeStateChanged(evt);
            }
        });
        slidTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                slidTimeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                slidTimeMouseReleased(evt);
            }
        });
        toolbarControle.add(slidTime);

        lbVolume.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVolume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVolume.setText("Vol. 100%");
        lbVolume.setMaximumSize(new java.awt.Dimension(80, 30));
        lbVolume.setMinimumSize(new java.awt.Dimension(80, 30));
        lbVolume.setPreferredSize(new java.awt.Dimension(80, 30));
        toolbarControle.add(lbVolume);

        slidVolume.setPaintTicks(true);
        slidVolume.setValue(100);
        slidVolume.setMaximumSize(new java.awt.Dimension(100, 26));
        slidVolume.setMinimumSize(new java.awt.Dimension(100, 26));
        slidVolume.setPreferredSize(new java.awt.Dimension(100, 26));
        slidVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidVolumeStateChanged(evt);
            }
        });
        toolbarControle.add(slidVolume);

        lbFilename.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFilename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarControle, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addComponent(lbFilename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolbarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        frm.play();
        this.setTitle("Reproduzindo...");
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        frm.pauseResume();

        if (this.getTitle().equals("Reproduzindo...")) {
            this.setTitle("Pausado...");
        } else {
            this.setTitle("Reproduzindo...");
        }

    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        frm.stop();
        frm.exit();
        this.dispose();
    }//GEN-LAST:event_btnStopActionPerformed

    private void slidVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidVolumeStateChanged
        // TODO add your handling code here:

        int value = slidVolume.getValue();
        lbVolume.setText("Vol. " + value);
        frm.changeVolume(value);

    }//GEN-LAST:event_slidVolumeStateChanged

    private void slidTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidTimeStateChanged
        // TODO add your handling code here:
        float np = slidTime.getValue() / 100f;
        frm.changeTime(np);
    }//GEN-LAST:event_slidTimeStateChanged

    private void slidTimeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slidTimeMousePressed
        // TODO add your handling code here:
        frm.setBand(false);
    }//GEN-LAST:event_slidTimeMousePressed

    private void slidTimeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slidTimeMouseReleased
        // TODO add your handling code here:
        frm.setBand(true);
    }//GEN-LAST:event_slidTimeMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lbFilename;
    private javax.swing.JLabel lbVolume;
    private javax.swing.JSlider slidTime;
    private javax.swing.JSlider slidVolume;
    private javax.swing.JToolBar toolbarControle;
    // End of variables declaration//GEN-END:variables
}
