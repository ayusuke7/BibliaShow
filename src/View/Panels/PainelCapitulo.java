package View.Panels;

import Controller.DAOLivro;
import Controller.DAONota;
import Controller.DAOVersiculo;
import Modell.Informacao;
import Modell.Nota;
import Modell.Livro;
import Modell.Renderer.LinhaTableTextArea;
import Modell.Versiculo;
import View.Dialogs.DialogAnotacao;
import View.Dialogs.DialogApresentador;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YU7
 */
public class PainelCapitulo extends javax.swing.JPanel {

    private final DAOVersiculo daoVerso;
    private final Livro livro;
    private ArrayList<Versiculo> versos;

    /**
     * Creates new form PainelVersiculos
     *
     * @param livro
     */
    public PainelCapitulo(Livro livro) {
        initComponents();
        this.livro = livro;
        this.daoVerso = new DAOVersiculo();
        preencherTabela();
        getInfoLivro();

    }

    private void preencherTabela() {

        int capitulo = (int) spnCap.getValue();
        String nome = livro.getNome_livro();
        txtTitulo.setText(nome + " " + capitulo);

        String sql = "SELECT * FROM Versiculos INNER JOIN Livros\n"
                + "ON Versiculos.Livro = Livros.Livro\n"
                + "WHERE Livros.Nome = '" + nome + "' "
                + "AND Versiculos.Capitulo = " + capitulo + "\n"
                + "ORDER BY Versiculos.Versiculo";

        versos = daoVerso.listVersiculos(sql);

        if (!versos.isEmpty()) {

            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };

            modelo.addColumn("Versiculos");
            ArrayList<Integer> rows = new ArrayList<>();

            for (int i = 0; i < versos.size(); i++) {
                Versiculo v = versos.get(i);
                modelo.addRow(new Object[]{v.getVersiculo() + " - " + v.getTexto()});
                if (v.isFavorito()) {
                    rows.add(i);
                }
            }

            tblaVersos.setModel(modelo);
            LinhaTableTextArea linha = new LinhaTableTextArea();
            linha.setFonte(tblaVersos.getFont());
            linha.setRowColor(rows);

            tblaVersos.getColumnModel().getColumn(0).setCellRenderer(linha);

        } else {
            spnCap.setValue(1);
        }

        menuCopiar.setEnabled(false);
        menuFavorita.setEnabled(false);
        menuShow.setEnabled(false);
        
    }

    private void getInfoLivro() {

        Informacao info = new DAOLivro().getInfomacao(livro.getId_livro());

        String builder = "<b>LIVRO: </b>" + livro.getNome_livro()
                + "<p><b>CHAVE: </b>" + info.getChave() + "</p>"
                + "<p align='justify'><b>COMENTARIO: </b>" + info.getInfo() + "</p>"
                + "<p><b>FONTE: </b>" + info.getFonte() + "</p>";
        txtPaneInfo.setText(builder);
        txtPaneInfo.setCaretPosition(0);
    }

    private void favoritarVers(int index) {

        Versiculo v = versos.get(index);

        Icon ico = new ImageIcon(this.getClass().getResource("/Images/favorite-icon.png"));
        int op = JOptionPane.showConfirmDialog(null, "Adicionar aos Favoritos\n"
                + txtTitulo.getText() + " : " + v.getVersiculo(), "Favorito",
                JOptionPane.YES_NO_OPTION, 1, ico);

        if (op == JOptionPane.YES_OPTION) {

            if (daoVerso.setFavorito(v.getCodigo(), true)) {
                preencherTabela();
            }
        }

    }

    private void iniciarDialogShow() {

        if (tblaVersos.getSelectedRowCount() > 0) {
            String select = "";
            for (int i : tblaVersos.getSelectedRows()) {
                select += txtTitulo.getText() + ":" + tblaVersos.getValueAt(i, 0) + "\n\n";
            }
            DialogApresentador dialog = new DialogApresentador(new JFrame(), true, select, 2);
            dialog.setVisible(true);
        } else {
            Icon ico = new ImageIcon(this.getClass().getResource("/Images/bookopen.png"));
            JOptionPane.showMessageDialog(null,"SELECIONE ALGUM VERSICULO PARA\n"
                    + "EXIBIR NA APRESENTAÇÃO", "AVISO", JOptionPane.INFORMATION_MESSAGE, ico);
        }
    }

    public void selectVersoFavorito(Versiculo v) {
        spnCap.setValue(v.getCapitulo());
        tblaVersos.changeSelection(v.getVersiculo() - 1, 0, false, false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuCopiar = new javax.swing.JMenuItem();
        menuFavorita = new javax.swing.JMenuItem();
        menuShow = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnNotas = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        spnCap = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        txtTitulo = new javax.swing.JTextField();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPaneInfo = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaVersos = new javax.swing.JTable();

        menuCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCopiar.setText("Copiar");
        menuCopiar.setEnabled(false);
        menuCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCopiarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuCopiar);

        menuFavorita.setText("Favoritar");
        menuFavorita.setEnabled(false);
        menuFavorita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFavoritaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuFavorita);

        menuShow.setText("Apresentar Texto");
        menuShow.setEnabled(false);
        menuShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuShowActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuShow);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator2);

        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/note.png"))); // NOI18N
        btnNotas.setFocusable(false);
        btnNotas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNotas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNotas);

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
        jToolBar1.add(jSeparator1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CAPÍTULO");
        jLabel3.setMaximumSize(new java.awt.Dimension(70, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(65, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 0));
        jToolBar1.add(jLabel3);

        spnCap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnCap.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnCap.setMaximumSize(new java.awt.Dimension(60, 33));
        spnCap.setMinimumSize(new java.awt.Dimension(60, 24));
        spnCap.setPreferredSize(new java.awt.Dimension(60, 24));
        spnCap.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCapStateChanged(evt);
            }
        });
        jToolBar1.add(spnCap);
        jToolBar1.add(jSeparator3);

        txtTitulo.setEditable(false);
        txtTitulo.setBackground(new java.awt.Color(0, 0, 102));
        txtTitulo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setText("TITULO");

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setDividerSize(10);
        jSplitPane2.setOneTouchExpandable(true);

        txtPaneInfo.setEditable(false);
        txtPaneInfo.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(txtPaneInfo);

        jSplitPane2.setLeftComponent(jScrollPane2);

        tblaVersos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblaVersos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblaVersos.setGridColor(new java.awt.Color(255, 255, 255));
        tblaVersos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaVersosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblaVersosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblaVersos);

        jSplitPane2.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTitulo)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spnCapStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCapStateChanged
        // TODO add your handling code here:
        preencherTabela();
    }//GEN-LAST:event_spnCapStateChanged

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        iniciarDialogShow();
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        // TODO add your handling code here:

        DAONota dao = new DAONota();
        Nota nota = dao.getNota(livro.getId_livro(), (int) spnCap.getValue());

        if (nota.getCodigo() == 0) {
            nota.setLivro(livro.getId_livro());
            nota.setCapitulo((int) spnCap.getValue());
        }

        DialogAnotacao dialog = new DialogAnotacao(new JFrame(), true, nota);
        dialog.setVisible(true);

    }//GEN-LAST:event_btnNotasActionPerformed

    private void tblaVersosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaVersosMouseClicked
        // TODO add your handling code here:

        int index = tblaVersos.getSelectedRow();

        if (evt.getClickCount() > 1) {
            favoritarVers(index);
        }

    }//GEN-LAST:event_tblaVersosMouseClicked

    private void tblaVersosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaVersosMouseReleased
        // TODO add your handling code here:
        
        if (evt.isPopupTrigger() && evt.getButton() == 3) {
            jPopupMenu1.show(tblaVersos, evt.getX(), evt.getY());
            if(tblaVersos.getSelectedRows().length > 0){
                menuCopiar.setEnabled(true);
                menuFavorita.setEnabled(true);
                menuShow.setEnabled(true);
            }
        }


    }//GEN-LAST:event_tblaVersosMouseReleased

    private void menuCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCopiarActionPerformed
        // TODO add your handling code here:

        String copiar = "";

        for (Integer i : tblaVersos.getSelectedRows()) {
            copiar += tblaVersos.getValueAt(i, 0) + "\n";
        }

        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(new StringSelection(copiar), null);
           
    }//GEN-LAST:event_menuCopiarActionPerformed

    private void menuFavoritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFavoritaActionPerformed
        // TODO add your handling code here:
        int index = tblaVersos.getSelectedRow();
        favoritarVers(index);
    }//GEN-LAST:event_menuFavoritaActionPerformed

    private void menuShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuShowActionPerformed
        // TODO add your handling code here:
        iniciarDialogShow();
    }//GEN-LAST:event_menuShowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuCopiar;
    private javax.swing.JMenuItem menuFavorita;
    private javax.swing.JMenuItem menuShow;
    private javax.swing.JSpinner spnCap;
    private javax.swing.JTable tblaVersos;
    private javax.swing.JTextPane txtPaneInfo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
