package View.Panels;

import Modell.Renderer.ItemListTextArea;
import Util.ControleArquivos;
import Util.Propriedades;
import View.Dialogs.DialogApresentador;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class PainelAvisos extends javax.swing.JPanel {

    private final String path = System.getProperty("user.dir");
    private final ControleArquivos control;

    /**
     * Creates new form PainelAvisos
     */
    public PainelAvisos() {
        initComponents();
        this.control = new ControleArquivos();
        listaAvisos();
        getPadroes();
    }

    private void getPadroes() {

        Properties props = new Propriedades().loadProperties();

        String fonte = props.getProperty("props.font");
        int estilo = Integer.parseInt(props.getProperty("props.style"));
        Color corFonte = new Color(Integer.parseInt(props.getProperty("props.corfonte")));
        Color corFundo = new Color(Integer.parseInt(props.getProperty("props.corfundo")));

        txtLetra.setFont(new Font(fonte, estilo, 18));
        txtLetra.setBackground(corFundo);
        txtLetra.setForeground(corFonte);
        txtLetra.setCaretColor(corFonte);

    }

    private void listaAvisos() {

        File[] avisos = new File(path + "/avisos").listFiles();

        cbAvisos.removeAllItems();

        for (File f : avisos) {
            cbAvisos.addItem(f.getName());
        }

    }

    private void splitSlides(int index) {

        String txt = txtLetra.getText();
        String[] split = txt.split("\n\n");
        DefaultListModel model = new DefaultListModel();

        for (String s : split) {
            model.addElement(s);
        }

        if (!txt.equals("")) {
            listSlide.setModel(model);
            listSlide.setCellRenderer(new ItemListTextArea());
            listSlide.setSelectedIndex(index);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSalvar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        cbAvisos = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnShow = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLetra = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSlide = new javax.swing.JList<>();

        setPreferredSize(new java.awt.Dimension(680, 340));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator2);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-icon.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar Edição");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addicon.png"))); // NOI18N
        btnAdicionar.setFocusable(false);
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdicionar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);
        jToolBar1.add(jSeparator3);

        cbAvisos.setMaximumSize(new java.awt.Dimension(200, 50));
        cbAvisos.setMinimumSize(new java.awt.Dimension(200, 20));
        cbAvisos.setPreferredSize(new java.awt.Dimension(200, 20));
        cbAvisos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAvisosItemStateChanged(evt);
            }
        });
        jToolBar1.add(cbAvisos);
        jToolBar1.add(jSeparator1);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png"))); // NOI18N
        btnShow.setToolTipText("Abrir Apresentação");
        btnShow.setFocusable(false);
        btnShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShow);

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOneTouchExpandable(true);

        txtLetra.setColumns(20);
        txtLetra.setLineWrap(true);
        txtLetra.setWrapStyleWord(true);
        txtLetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLetraKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtLetra);

        jSplitPane1.setRightComponent(jScrollPane1);

        listSlide.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSlideValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listSlide);

        jSplitPane1.setLeftComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        if (cbAvisos.getModel().getSize() > 0) {
            int op = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER ESSE AVISO?",
                    "REMOVER", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                File source = new File(path + "/avisos/" + cbAvisos.getSelectedItem());
                if (source.delete()) {
                    listaAvisos();
                }
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        int[] selects = listSlide.getSelectedIndices();

        if (selects.length > 0) {

            String texto = "";

            for (Integer i : selects) {
                texto += listSlide.getModel().getElementAt(i) + "\n\n";
            }

            DialogApresentador dialog = new DialogApresentador(new JFrame(), true, texto, 3);
            dialog.setVisible(true);

        }

    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:

        Icon ico = new ImageIcon(this.getClass().getResource("/Images/warning-icon.png"));
        String nome = (String) JOptionPane.showInputDialog(null, "DESCRIÇÃO OU TÍTULO DO AVISO",
                "NOME DO AVISO", JOptionPane.OK_CANCEL_OPTION, ico, null, null);

        if (!nome.equals("")) {
            String source = path + "/avisos/" + nome + ".txt";
            if (control.gravarArquivo(source, "", false)) {
                btnSalvar.setEnabled(true);
                txtLetra.setCaretPosition(0);
                listaAvisos();
                cbAvisos.setSelectedItem(nome + ".txt");
            }
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        String source = path + "/avisos/" + cbAvisos.getSelectedItem();

        if (!txtLetra.getText().equals("")) {
            if (control.gravarArquivo(source, txtLetra.getText(), false)) {
                JOptionPane.showMessageDialog(null, "GRAVADO COM SUCESSO");
                btnSalvar.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbAvisosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAvisosItemStateChanged
        // TODO add your handling code here:

        String saida = control.lerArquivo(new File(path + "/avisos/" + cbAvisos.getSelectedItem()));
        txtLetra.setText(saida);

        splitSlides(listSlide.getSelectedIndex());

    }//GEN-LAST:event_cbAvisosItemStateChanged

    private void listSlideValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSlideValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listSlideValueChanged

    private void txtLetraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetraKeyReleased
        // TODO add your handling code here:
        btnSalvar.setEnabled(true);
        splitSlides(listSlide.getSelectedIndex());
    }//GEN-LAST:event_txtLetraKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox<String> cbAvisos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> listSlide;
    private javax.swing.JTextArea txtLetra;
    // End of variables declaration//GEN-END:variables
}
