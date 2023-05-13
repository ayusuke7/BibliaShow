package View.Dialogs;

import View.FrmVisualizador;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AYU7-WN
 */
public class DialogImagens extends javax.swing.JDialog {

    private BufferedImage buffImage;
    private boolean confirma;
    private String path;
    private FrmVisualizador frm;

    public DialogImagens(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarImagensDiretorio();
    }

    public DialogImagens(Frame parent, boolean modal, ArrayList<File> imagens) {
        super(parent, modal);
        initComponents();

        imagens.stream().forEach((f) -> {
            panelGaleria.add(getLabelIcon(f));
        });

        this.frm = new FrmVisualizador();
        GraphicsDevice[] telas = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        if (telas.length > 1) {
            for (GraphicsDevice g : telas) {
                g.setFullScreenWindow(frm);
            }
        }else{
            frm.setVisible(true);
        }
    }

    private JLabel getLabelIcon(File f) {

        JLabel lb = new JLabel();
        ImageIcon image = new ImageIcon(f.getAbsolutePath());
        lb.setIcon(new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
        lb.setToolTipText(f.getName());
        lb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    BufferedImage image = ImageIO.read(f.getAbsoluteFile());
                    if (frm != null) {
                        frm.setBackground(image);
                    } else {
                        setBuffImage(image);
                        setPath(f.getName());
                        setConfirma(true);
                        dispose();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DialogApresentador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        return lb;
    }

    private void carregarImagensDiretorio() {
        
        File data = new File(System.getProperty("user.dir") + "/imagens");

        if (data.exists()) {
            File[] arquivos = data.listFiles();
            for (File f : arquivos) {
                if (f.getName().contains(".png") || f.getName().contains(".jpg") || f.getName().contains(".bmp")) {
                    panelGaleria.add(getLabelIcon(f));                    
                } else {
                    JOptionPane.showMessageDialog(null, "SEM IMAGENS PARA LISTAR!\nVERIFIQUE O DIRETÓRIO",
                            "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "DIRETÓRIO IMAGENS NÃO ENCONTRADO",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        panelGaleria = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSearch = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Galeria");
        setMaximumSize(new java.awt.Dimension(2147483647, 250));
        setMinimumSize(new java.awt.Dimension(750, 250));
        setPreferredSize(new java.awt.Dimension(750, 250));

        panelGaleria.setBackground(new java.awt.Color(255, 255, 255));
        panelGaleria.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane4.setViewportView(panelGaleria);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addicon.png"))); // NOI18N
        btnSearch.setToolTipText("Carregar Galeria");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setMaximumSize(new java.awt.Dimension(40, 31));
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSearch);

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close-icon.png"))); // NOI18N
        btnFinalizar.setToolTipText("Fechar Apresentação");
        btnFinalizar.setFocusable(false);
        btnFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizar.setMaximumSize(new java.awt.Dimension(40, 31));
        btnFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFinalizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        if(frm != null){
            frm.dispose();
        }
        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        String[]extensions = {"png", "jpg", "bmp"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagem", extensions);
        busca.setFileFilter(filter);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int op = busca.showOpenDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            File file = busca.getSelectedFile();
            panelGaleria.add(getLabelIcon(file));
            panelGaleria.repaint();
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelGaleria;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the buffImage
     */
    public BufferedImage getBuffImage() {
        return buffImage;
    }

    /**
     * @param buffImage the buffImage to set
     */
    public void setBuffImage(BufferedImage buffImage) {
        this.buffImage = buffImage;
    }

    /**
     * @return the confirma
     */
    public boolean isConfirma() {
        return confirma;
    }

    /**
     * @param confirma the confirma to set
     */
    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    
}
