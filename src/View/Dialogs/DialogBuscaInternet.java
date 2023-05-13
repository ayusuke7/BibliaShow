package View.Dialogs;

import Modell.Json.Artista;
import Modell.Json.Musica;
import Modell.Json.Resultado;
import Util.ControleArquivos;
import Util.HttpRequest;
import com.google.gson.Gson;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author AYU7-WN
 */
public class DialogBuscaInternet extends javax.swing.JDialog {

    private final String path = System.getProperty("user.dir");

    /**
     * Creates new form DialogBuscaInternet
     *
     * @param parent
     * @param modal
     */
    public DialogBuscaInternet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        File pasta = new File(path + "/canticos");

        if (pasta.exists() && pasta.isDirectory()) {
            for (File f : pasta.listFiles()) {
                if (f.isDirectory()) {
                    jComboBox1.addItem(f.getName());
                }
            }
        }
    }

    private void buscaMusica(String artista, String musica) {

        jProgressBar1.setIndeterminate(true);

        new Thread() {
            @Override
            public void run() {
                try {

                    String url = "https://api.vagalume.com.br/search.php?art=" + artista + "&mus=" + musica + "&apikey={key}";
                    String json = HttpRequest.sendGet(url);

                    Gson gson = new Gson();
                    Resultado resultado = gson.fromJson(json, Resultado.class);

                    List<Musica> listMusica = resultado.getMusicas();
                    String saida = "";

                    for (Musica m : listMusica) {
                        Artista art = resultado.getArtista();
                        saida += "Artista: " + art.getName() + "\n"
                                + "Musica: " + m.getName() + "\n"
                                + "Link: " + m.getUrl() + "\n\n"
                                + "" + m.getText();
                    }

                    txtLetra.setText(saida);

                } catch (Exception ex) {
                    txtLetra.setText("ERRO HTTP: " + ex.getMessage());
                }
                
                jProgressBar1.setIndeterminate(false);
                
            }

        }.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfArtista = new javax.swing.JTextField();
        tfMusica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLetra = new javax.swing.JTextArea();
        btnBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar letras em http://www.vagalume.com");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtLetra.setColumns(20);
        txtLetra.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtLetra.setRows(5);
        txtLetra.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtLetra);

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search24.png"))); // NOI18N
        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Musica:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Artista:");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vagalume.png"))); // NOI18N
        jLabel3.setText("<html>O môdulo de busca, utiliza a API do site Vagalume para busca de letras na internet. Para o sistema foi implementado apenas o modelo de busca ARTMUS [Artista/Musica], ou é preciso especifica o mais fiel possivel o artista e o nome da música, para recuperação da letra</html>");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setIconTextGap(10);

        jProgressBar1.setMaximumSize(new java.awt.Dimension(180, 15));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(180, 15));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(180, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfMusica, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(tfArtista))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-icon.png"))); // NOI18N
        jButton3.setText("Salvar em...");
        jButton3.setToolTipText("");
        jButton3.setFocusable(false);
        jButton3.setMaximumSize(new java.awt.Dimension(110, 31));
        jButton3.setMinimumSize(new java.awt.Dimension(110, 31));
        jButton3.setPreferredSize(new java.awt.Dimension(110, 31));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jComboBox1.setMaximumSize(new java.awt.Dimension(200, 25));
        jComboBox1.setMinimumSize(new java.awt.Dimension(200, 25));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 25));
        jToolBar1.add(jComboBox1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:

        if (!tfArtista.getText().equals("") && !tfMusica.getText().equals("")) {
            buscaMusica(tfArtista.getText(), tfMusica.getText());
        } else {
            txtLetra.setText("Forneça os nomes de Artista & Musica para efetuar a busca!");
        }

    }//GEN-LAST:event_btnBuscaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if (!txtLetra.getText().equals("")) {
            ControleArquivos controle = new ControleArquivos();
            String source = path + "/canticos/" + jComboBox1.getSelectedItem();
            File file = new File(source);
            if (file.exists()) {
                String arquivo = source + "/" 
                        + StringUtils.capitalize(tfMusica.getText()) 
                        + " (" + StringUtils.capitalize(tfArtista.getText()) + ").txt";
                if (controle.gravarArquivo(arquivo, txtLetra.getText(), false)) {
                    JOptionPane.showMessageDialog(null, "CÂNTICO ADICIONADO");
                    this.dispose();
                }
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField tfArtista;
    private javax.swing.JTextField tfMusica;
    private javax.swing.JTextArea txtLetra;
    // End of variables declaration//GEN-END:variables
}
