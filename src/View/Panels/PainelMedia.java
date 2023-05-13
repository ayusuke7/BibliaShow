package View.Panels;

import View.Dialogs.DialogMediaPlayer;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AYU7-WN
 */
public class PainelMedia extends javax.swing.JPanel {

    private final DefaultListModel model;

    /**
     * Creates new form PainelMedia
     */
    public PainelMedia() {
        initComponents();
        model = new DefaultListModel();
        jList1.setModel(model);
        
        String os = System.getProperty("os.name");
        String arc = System.getProperty("os.arch");

        if (os.contains("Windows")) {
            if (arc.contains("64")) {
                localizaVLC("C:/Program Files/VideoLAN/VLC/");
            } else {
                localizaVLC("C:/Program Files (x86)/VideoLAN/VLC/");
            }
        } else {
            tfPathVLC.setText("Localize a Instalação do VLC");
        }

    }

    private void localizaVLC(String path) {

        File file = new File(path);

        if (file.exists() && registraDLL(file, "libvlc.dll") && registraDLL(file, "libvlccore.dll")) {
            tfPathVLC.setText(path);
            btnShow.setEnabled(true);
        } else {
            String url = "https://www.videolan.org/vlc/index.pt-BR.html";
            tfPathVLC.setText("Dll's do VLC não encontradas! faça o download em " + url);
            btnShow.setEnabled(false);
        }
    }

    private boolean registraDLL(File file, String dll) {

        File[] files = file.listFiles();

        for (File f : files) {
            if (f.getName().equals(dll)) {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAdc = new javax.swing.JButton();
        btnAdc1 = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        tfPathVLC = new javax.swing.JTextField();

        jList1.setBackground(new java.awt.Color(240, 240, 240));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("*********** Player Biblia Show *************\n\n* O Reprodutor utiliza uma Biblioteca baseada no software de reprodução de Audio/Video, VLC LAN, e necessita de algumas DLL para reprodução dos videos.\n\nLocalizados em:\nWindows x32 - C:/Program Files (x86)/VideoLAN/VLC/\nWindows x64 - C:/Program Files/VideoLAN/VLC/\nLinux - ?????\n\n* Localize a pasta de Instalação do seu VLC ou instale a versão compativel com seu S.O e aponte o caminho para a mesma! No caso de Sistemas como Linux e Mac, o processo de localização da biblioteca é manual e irá depender do tipo da distriuição.\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(jTextArea1);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

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

        btnAdc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnAdc1.setToolTipText("Remover Midia");
        btnAdc1.setFocusable(false);
        btnAdc1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdc1.setMaximumSize(new java.awt.Dimension(40, 50));
        btnAdc1.setMinimumSize(new java.awt.Dimension(40, 50));
        btnAdc1.setPreferredSize(new java.awt.Dimension(40, 50));
        btnAdc1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdc1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdc1);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png"))); // NOI18N
        btnShow.setToolTipText("Apresentação");
        btnShow.setEnabled(false);
        btnShow.setFocusable(false);
        btnShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShow);
        jToolBar1.add(jSeparator4);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vlc-icon24.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(40, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(40, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(40, 50));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        tfPathVLC.setEditable(false);
        tfPathVLC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPathVLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPathVLCActionPerformed(evt);
            }
        });
        jToolBar1.add(tfPathVLC);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        busca.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int op = busca.showOpenDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            File file = busca.getSelectedFile();
            tfPathVLC.setText(file.getAbsolutePath());
            localizaVLC(tfPathVLC.getText());

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdcActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        String[] ext = {"mp4", "mpeg", "avi", "rmvb", "mkv"};
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Video", ext);
        busca.setFileFilter(filtro);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);
        busca.setMultiSelectionEnabled(true);

        if (busca.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            File[] files = busca.getSelectedFiles();
            for (File f : files) {
                model.addElement(f.getAbsolutePath());
            }

        }

//        jList1.setModel(model);
    }//GEN-LAST:event_btnAdcActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        if (jList1.getSelectedIndex() > -1) {
            File file = new File(jList1.getSelectedValue());
            String vlc = tfPathVLC.getText();
            DialogMediaPlayer dialog = new DialogMediaPlayer(new JFrame(), true, file, vlc);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA MIDIA");
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void tfPathVLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPathVLCActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfPathVLCActionPerformed

    private void btnAdc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdc1ActionPerformed
        // TODO add your handling code here:

        if (jList1.getSelectedIndex() > -1) {
            model.removeElementAt(jList1.getSelectedIndex());
        }


    }//GEN-LAST:event_btnAdc1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdc;
    private javax.swing.JButton btnAdc1;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField tfPathVLC;
    // End of variables declaration//GEN-END:variables
}
