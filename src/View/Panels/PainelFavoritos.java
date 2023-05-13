package View.Panels;

import Controller.DAOLivro;
import Controller.DAOVersiculo;
import Modell.Livro;
import Modell.Renderer.LinhaTableTextArea;
import Modell.Versiculo;
import Util.ControleArquivos;
import View.Dialogs.DialogApresentador;
import View.FrmBiblia;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class PainelFavoritos extends javax.swing.JPanel {

    private final String path = System.getProperty("user.dir");

    private final DAOVersiculo daoVers;
    private final DAOLivro daoLivro;
    private ArrayList<Versiculo> versos;
    private final ControleArquivos controle;

    private final FrmBiblia frm;

    /**
     * Creates new form PainelFavoritos
     *
     * @param frm
     */
    public PainelFavoritos(FrmBiblia frm) {
        initComponents();
        this.frm = frm;
        daoVers = new DAOVersiculo();
        daoLivro = new DAOLivro();
        controle = new ControleArquivos();

        listFavoritas();
        listMusicas();

    }

    private void listFavoritas() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modelo.addColumn("Versiculos");

        String sql = "SELECT * FROM Versiculos WHERE Favorito = True";
        versos = daoVers.listVersiculos(sql);

        if (!versos.isEmpty()) {
            versos.stream().forEach((v) -> {
                modelo.addRow(new Object[]{daoLivro.getLivro(v.getLivro()).getNome_livro() + ", "
                    + v.getCapitulo() + " : " + v.getVersiculo() + " - " + v.getTexto()});
            });

            tblaFavs.setModel(modelo);
            LinhaTableTextArea linha = new LinhaTableTextArea();
            linha.setFonte(tblaFavs.getFont());
            tblaFavs.getColumnModel().getColumn(0).setCellRenderer(linha);

        }

    }

    private void listMusicas() {

        File file = new File(path + "/canticos/favoritos.txt");
        String list = controle.lerArquivo(file);

        if (!list.equals("")) {

            String[] split = list.split("\n");
            DefaultListModel modelo = new DefaultListModel();

            for (String s : split) {
                modelo.addElement(s);
            }

            listCanticos.setModel(modelo);

        }

    }

    private void removerVersoFavorito(int index) {

        Versiculo v = versos.get(index);

        String mensagem = "Remover dos Favoritos\n "
                + new DAOLivro().getLivro(v.getLivro()).getNome_livro()
                + " - " + v.getCapitulo() + ":" + v.getVersiculo();

        Icon ico = new ImageIcon(this.getClass().getResource("/Images/favorite-icon.png"));
        int op = JOptionPane.showConfirmDialog(null, mensagem, "Favorito", JOptionPane.YES_NO_OPTION, 1, ico);

        if (op == JOptionPane.YES_OPTION) {
            daoVers.setFavorito(v.getCodigo(), false);
        }

    }

    private void removerCanticoFavorito(String cantico) {

        File file = new File(path + "/canticos/favoritos.txt");
        String lista = controle.lerArquivo(file);
        String saida = lista.replace(cantico + "\n", "");

        if (controle.gravarArquivo(file.getAbsolutePath(), saida, false)) {
            listMusicas();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnExcluir = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaFavs = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCanticos = new javax.swing.JList<>();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator2);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnExcluir.setToolTipText("Remover Favorito");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setMaximumSize(new java.awt.Dimension(40, 31));
        btnExcluir.setMinimumSize(new java.awt.Dimension(40, 31));
        btnExcluir.setPreferredSize(new java.awt.Dimension(40, 31));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monitor.png"))); // NOI18N
        btnShow.setToolTipText("Apresentar Versiculos");
        btnShow.setFocusable(false);
        btnShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnShow.setMaximumSize(new java.awt.Dimension(40, 31));
        btnShow.setMinimumSize(new java.awt.Dimension(40, 31));
        btnShow.setPreferredSize(new java.awt.Dimension(40, 31));
        btnShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShow);
        jToolBar1.add(jSeparator1);

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setDividerSize(10);

        tblaFavs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblaFavs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblaFavs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaFavsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaFavs);

        jSplitPane1.setRightComponent(jScrollPane1);

        listCanticos.setBorder(javax.swing.BorderFactory.createTitledBorder("Cânticos"));
        listCanticos.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        listCanticos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCanticos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCanticosMouseClicked(evt);
            }
        });
        listCanticos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCanticosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listCanticos);

        jSplitPane1.setLeftComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblaFavsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaFavsMouseClicked
        // TODO add your handling code here:       

        listCanticos.clearSelection();
        
        if (evt.getClickCount() > 1) {
            int index = tblaFavs.getSelectedRow();
            Livro liv = daoLivro.getLivro(versos.get(index).getLivro());
            PainelCapitulo capitulo = new PainelCapitulo(liv);
            capitulo.selectVersoFavorito(versos.get(index));
            frm.addTabPane(liv.getNome_livro(), capitulo);
        }

    }//GEN-LAST:event_tblaFavsMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        if (tblaFavs.getSelectedRowCount() > 0) {

            int[] index = tblaFavs.getSelectedRows();
            for (int i = 0; i < index.length; i++) {
                removerVersoFavorito(index[i]);
            }
            listFavoritas();

        } else if (listCanticos.getSelectedIndex() > -1) {
            String cantico = listCanticos.getSelectedValue();
            removerCanticoFavorito(cantico);
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM CANTICO OU VERSICULO");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        if (tblaFavs.getSelectedRowCount() > 0) {
            String select = "";
            
            for (int i : tblaFavs.getSelectedRows()) {
                select += tblaFavs.getValueAt(i, 0) + "\n\n";
            }

            DialogApresentador dialog = new DialogApresentador(new JFrame(), true, select, 2);
            dialog.setVisible(true);

        } else if (listCanticos.getSelectedIndex() > -1) {

            File select = new File(path + "/canticos/" + listCanticos.getSelectedValue());
            String texto = controle.lerArquivo(select);
            DialogApresentador dialog = new DialogApresentador(new JFrame(), true, texto, 1);
            dialog.arquivoSelecionado = path + "/canticos/" + listCanticos.getSelectedValue();
            dialog.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM CANTICO OU VERSICULO");
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void listCanticosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCanticosValueChanged
        // TODO add your handling code here:

        tblaFavs.getSelectionModel().clearSelection();

    }//GEN-LAST:event_listCanticosValueChanged

    private void listCanticosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCanticosMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() > 1 && listCanticos.getModel().getSize() > 0) {
            PainelCanticos canticos = new PainelCanticos();
            canticos.selectCanticoFavorito(listCanticos.getSelectedValue());
            frm.addTabPane("Cantico", canticos);
        }

    }//GEN-LAST:event_listCanticosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> listCanticos;
    private javax.swing.JTable tblaFavs;
    // End of variables declaration//GEN-END:variables

}
