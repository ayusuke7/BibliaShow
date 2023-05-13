package View.Panels;

import Util.ControleArquivos;
import Util.Propriedades;
import View.Dialogs.DialogApresentador;
import View.Dialogs.DialogBuscaInternet;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author YU7
 */
public class PainelCanticos extends javax.swing.JPanel {

    private final String path = System.getProperty("user.dir");
    private final ControleArquivos control;

    public PainelCanticos() {
        initComponents();
        this.control = new ControleArquivos();
        dataCanticos();
        getPadroes();

    }

    private void dataCanticos() {

        File diretorio = new File(path + "/canticos/");

        if (diretorio.exists()) {

            File[] data = diretorio.listFiles();

            for (File f : data) {
                if (f.isDirectory()) {
                    cbDataCanticos.addItem(f.getName());
                }
            }

        } else {
            txtLetra.setText("DIRETÓRIO [CANTICOS] NÃO ENCONTRADO");
        }
    }

    private void listarCanticos(String nome) {

        DefaultListModel model = new DefaultListModel();

        File[] files = new File(path + "/canticos/" + cbDataCanticos.getSelectedItem()).listFiles();

        for (File f : files) {

            String name = f.getName();

            if (nome.equals("")) {
                model.addElement(name);
            } else if (name.toUpperCase().contains(nome.toUpperCase())) {
                model.addElement(name);
            }

        }

        lbResult.setText(files.length + " Canticos");
        listCanticos.setModel(model);
        listCanticos.setSelectedIndex(0);

    }

    private void pesquisaNaLista(String nome) {

        if (rbTitulo.isSelected()) {
            listarCanticos(nome);
        } else {
            DefaultListModel model = new DefaultListModel();
            String data = path + "/canticos/" + cbDataCanticos.getSelectedItem();
            ArrayList<String> letras = control.buscaTextoEmArquivo(data, nome);
            letras.stream().forEach((s) -> {
                model.addElement(s);
            });

            lbResult.setText(model.getSize() + " Canticos");
            listCanticos.setModel(model);
            listCanticos.setSelectedIndex(0);

        }

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

    public void selectCanticoFavorito(String caminho) {

        String pasta = caminho.substring(0, caminho.indexOf("/"));
        cbDataCanticos.setSelectedItem(pasta);

        String hino = caminho.substring(caminho.indexOf("/") + 1);
        pesquisaNaLista(hino);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        splitDivisor = new javax.swing.JSplitPane();
        painelCanticos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCanticos = new javax.swing.JList<>();
        tfPesquisa = new javax.swing.JTextField();
        toolbarOpcoes = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        cbDataCanticos = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        rbTitulo = new javax.swing.JRadioButton();
        rbTecho = new javax.swing.JRadioButton();
        lbResult = new javax.swing.JLabel();
        painelLetra = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnBuscar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnFavoritar = new javax.swing.JButton();
        btnRemover1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        lbPrevia = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnShow = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLetra = new javax.swing.JTextPane();

        splitDivisor.setDividerLocation(350);

        listCanticos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCanticos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listCanticos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCanticosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listCanticos);

        tfPesquisa.setMinimumSize(new java.awt.Dimension(6, 30));
        tfPesquisa.setPreferredSize(new java.awt.Dimension(6, 30));
        tfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaActionPerformed(evt);
            }
        });

        toolbarOpcoes.setFloatable(false);
        toolbarOpcoes.setRollover(true);
        toolbarOpcoes.add(jSeparator2);

        cbDataCanticos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDataCanticosItemStateChanged(evt);
            }
        });
        toolbarOpcoes.add(cbDataCanticos);
        toolbarOpcoes.add(jSeparator1);

        buttonGroup1.add(rbTitulo);
        rbTitulo.setSelected(true);
        rbTitulo.setText("Titulo");

        buttonGroup1.add(rbTecho);
        rbTecho.setText("Techo");

        lbResult.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbResult.setText(" ");

        javax.swing.GroupLayout painelCanticosLayout = new javax.swing.GroupLayout(painelCanticos);
        painelCanticos.setLayout(painelCanticosLayout);
        painelCanticosLayout.setHorizontalGroup(
            painelCanticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelCanticosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCanticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCanticosLayout.createSequentialGroup()
                        .addComponent(rbTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTecho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelCanticosLayout.setVerticalGroup(
            painelCanticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCanticosLayout.createSequentialGroup()
                .addComponent(toolbarOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCanticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTitulo)
                    .addComponent(rbTecho)
                    .addComponent(lbResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        splitDivisor.setLeftComponent(painelCanticos);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search24.png"))); // NOI18N
        btnBuscar.setText("Internet");
        btnBuscar.setToolTipText("Buscar na Internet");
        btnBuscar.setFocusable(false);
        btnBuscar.setIconTextGap(8);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);
        jToolBar1.add(jSeparator3);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addicon.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar Cantico");
        btnAdicionar.setFocusable(false);
        btnAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdicionar);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnRemover.setToolTipText("Remover Cantico");
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);

        btnFavoritar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/star.png"))); // NOI18N
        btnFavoritar.setToolTipText("Favoritar Cânticos");
        btnFavoritar.setFocusable(false);
        btnFavoritar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFavoritar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFavoritar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFavoritar);

        btnRemover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/font-icon.png"))); // NOI18N
        btnRemover1.setToolTipText("Texto em Maisculo");
        btnRemover1.setFocusable(false);
        btnRemover1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover1);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-icon.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar Edição");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);
        jToolBar1.add(jSeparator5);

        lbPrevia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPrevia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrevia.setText("Previa");
        lbPrevia.setPreferredSize(new java.awt.Dimension(0, 30));
        jToolBar1.add(lbPrevia);
        jToolBar1.add(jSeparator4);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png"))); // NOI18N
        btnShow.setToolTipText("Apresentação");
        btnShow.setFocusable(false);
        btnShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShow);

        txtLetra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLetra.setToolTipText("Letra: (Dica - Utilize duas quebra de linha, onde cada paragrafo indica quais serão os slides)");
        txtLetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLetraKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txtLetra);

        javax.swing.GroupLayout painelLetraLayout = new javax.swing.GroupLayout(painelLetra);
        painelLetra.setLayout(painelLetraLayout);
        painelLetraLayout.setHorizontalGroup(
            painelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        painelLetraLayout.setVerticalGroup(
            painelLetraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLetraLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        splitDivisor.setRightComponent(painelLetra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitDivisor, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listCanticosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCanticosValueChanged
        // TODO add your handling code here:

        if (listCanticos.getSelectedIndex() > -1) {

            String select = listCanticos.getSelectedValue();
            File file = new File(path + "/canticos/" + cbDataCanticos.getSelectedItem() + "/" + select);
            String saida = control.lerArquivo(file);
            txtLetra.setText(saida);
            txtLetra.setCaretPosition(0);
            btnSalvar.setEnabled(false);

            lbPrevia.setText("Prévia: " + txtLetra.getText().split("\n\n").length + " slides");

            if (control.lerArquivo(new File(path + "/canticos/favoritos.txt")).contains(select)) {
                btnFavoritar.setEnabled(false);
            } else {
                btnFavoritar.setEnabled(true);
            }

        }

    }//GEN-LAST:event_listCanticosValueChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        String source = path + "/canticos/" + cbDataCanticos.getSelectedItem() + "/" + listCanticos.getSelectedValue();

        if (!txtLetra.getText().equals("")) {
            if (control.gravarArquivo(source, txtLetra.getText(), false)) {
                btnSalvar.setEnabled(false);
            }
        } else if (control.removerArquivo(source)) {
            listarCanticos("");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaActionPerformed
        // TODO add your handling code here:

        String pesquisa = tfPesquisa.getText();
        pesquisaNaLista(pesquisa);

    }//GEN-LAST:event_tfPesquisaActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        String text = txtLetra.getText();
        DialogApresentador dialog = new DialogApresentador(new JFrame(), true, text, 1);
        String select = listCanticos.getSelectedValue();
        dialog.arquivoSelecionado = path + "/canticos/" + cbDataCanticos.getSelectedItem() + "/" + select;
        dialog.setVisible(true);
      
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:

        String pasta = path + "/canticos/" + cbDataCanticos.getSelectedItem();

        Icon ico = new ImageIcon(this.getClass().getResource("/Images/music.png"));

        String nome = (String) JOptionPane.showInputDialog(null,
                "(Dica - Colocar o cantor ou trecho do cântico no titulo)",
                "NOME DO CÂNTICO", JOptionPane.OK_CANCEL_OPTION, ico, null, null);

        if (!nome.equals("")) {
            String source = pasta + "/" + nome + ".txt";
            if (control.gravarArquivo(source, "", false)) {
                btnSalvar.setEnabled(true);
                txtLetra.setCaretPosition(0);
                listarCanticos("");
                pesquisaNaLista(nome);
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cbDataCanticosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDataCanticosItemStateChanged
        // TODO add your handling code here:

        if (cbDataCanticos.getItemCount() > 0) {
            listarCanticos("");
        }


    }//GEN-LAST:event_cbDataCanticosItemStateChanged

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:

        if (!listCanticos.isSelectionEmpty()) {
            String source = path + "/canticos/" + cbDataCanticos.getSelectedItem() + "/" + listCanticos.getSelectedValue();
            if (control.removerArquivo(source)) {
                listarCanticos("");
            }

        }

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtLetraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetraKeyReleased
        // TODO add your handling code here:

        btnSalvar.setEnabled(true);
        lbPrevia.setText("Prévia: " + txtLetra.getText().split("\n\n").length + " slides");

    }//GEN-LAST:event_txtLetraKeyReleased

    private void btnFavoritarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritarActionPerformed
        // TODO add your handling code here:

        File favoritos = new File(path + "/canticos/favoritos.txt");
        String fav = cbDataCanticos.getSelectedItem() + "/" + listCanticos.getSelectedValue() + "\n";
        
        if (control.gravarArquivo(favoritos.getAbsolutePath(), fav, true)) {
            JOptionPane.showMessageDialog(null, "Cantico adicionado aos Favoritos");
            btnFavoritar.setEnabled(false);
        }

    }//GEN-LAST:event_btnFavoritarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        DialogBuscaInternet busca = new DialogBuscaInternet(new JFrame(), true);
        busca.setVisible(true);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover1ActionPerformed
        // TODO add your handling code here:
        txtLetra.setText(txtLetra.getText().toUpperCase());
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnRemover1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFavoritar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnRemover1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnShow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDataCanticos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbPrevia;
    private javax.swing.JLabel lbResult;
    private javax.swing.JList<String> listCanticos;
    private javax.swing.JPanel painelCanticos;
    private javax.swing.JPanel painelLetra;
    private javax.swing.JRadioButton rbTecho;
    private javax.swing.JRadioButton rbTitulo;
    private javax.swing.JSplitPane splitDivisor;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JToolBar toolbarOpcoes;
    private javax.swing.JTextPane txtLetra;
    // End of variables declaration//GEN-END:variables

}
