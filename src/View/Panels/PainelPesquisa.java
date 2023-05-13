package View.Panels;

import Controller.DAOLivro;
import Controller.DAOVersiculo;
import Modell.Livro;
import Modell.Renderer.LinhaTableTextArea;
import Modell.Versiculo;
import View.FrmBiblia;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYU7-WN
 */
public class PainelPesquisa extends javax.swing.JPanel {

    private final DAOLivro daoLivro;
    private final DAOVersiculo daoVers;
    private ArrayList<Livro> livros;
    private ArrayList<Versiculo> vers;

    private final FrmBiblia frm;
    
    /**
     * Creates new form PainelPesquisa
     *
     * @param frm
     */
    public PainelPesquisa(FrmBiblia frm) {
        initComponents();
        this.frm = frm;
        this.daoLivro = new DAOLivro();
        this.daoVers = new DAOVersiculo();
        listLivrosDB();
    }

    private void listLivrosDB() {

        livros = daoLivro.listLivros("SELECT * FROM Livros");

        DefaultListModel model = new DefaultListModel();

        livros.stream().forEach((l) -> {
            model.addElement(l.getNome_livro());
        });

        listLivros.setModel(model);

    }

    private void pesquisarVerso() {

        String sql;

        if (rbCompleto.isSelected()) {
            sql = "SELECT * FROM Versiculos WHERE Descricao LIKE '*" + tfPesquisa.getText() + "*';";
        } else if (rbVelhoTestamento.isSelected()) {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.testamento='Velho' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        } else if (rbNovoTestamento.isSelected()) {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.testamento='Novo' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        } else {
            sql = "SELECT * FROM Versiculos INNER JOIN Livros \n"
                    + "ON Versiculos.Livro = Livros.Livro \n"
                    + "WHERE Livros.Nome='" + listLivros.getSelectedValue() + "' \n"
                    + "AND Versiculos.Descricao \n"
                    + "LIKE '*" + tfPesquisa.getText() + "*';";
        }

        vers = daoVers.listVersiculos(sql);
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };

        modelo.addColumn("Favoritos");
        vers.stream().forEach((v) -> {
            modelo.addRow(new Object[]{daoLivro.getLivro(v.getLivro()).getNome_livro() + ", "
                + v.getCapitulo() + " : " + v.getVersiculo() + " - " + v.getTexto()});
        });

        tblaPesquisa.setModel(modelo);
        LinhaTableTextArea linha = new LinhaTableTextArea();
        linha.setFonte(tblaPesquisa.getFont());
        tblaPesquisa.getColumnModel().getColumn(0).setCellRenderer(new LinhaTableTextArea());
        tblaPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jLabel3.setText("Resultados encontrados: " + vers.size() + " versiculos");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tfPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbCompleto = new javax.swing.JRadioButton();
        rbVelhoTestamento = new javax.swing.JRadioButton();
        rbNovoTestamento = new javax.swing.JRadioButton();
        rbLivros = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listLivros = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblaPesquisa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tfPesquisa.setPreferredSize(new java.awt.Dimension(6, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Palavras-Chave ou Trecho de Versiculos.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Opções:");

        jLabel3.setText("Resultados encontrados:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rbCompleto.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbCompleto);
        rbCompleto.setSelected(true);
        rbCompleto.setText("Biblia Completa");

        rbVelhoTestamento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbVelhoTestamento);
        rbVelhoTestamento.setText("Velho Testamento");

        rbNovoTestamento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNovoTestamento);
        rbNovoTestamento.setText("Novo Testamento");

        rbLivros.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbLivros);
        rbLivros.setText("Por Livros");
        rbLivros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbLivrosItemStateChanged(evt);
            }
        });

        listLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listLivros.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        listLivros.setVisibleRowCount(22);
        listLivros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listLivrosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listLivros);

        tblaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaPesquisaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblaPesquisa);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search24.png"))); // NOI18N
        jButton1.setText("PESQUISAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(rbVelhoTestamento)
                    .addComponent(rbNovoTestamento)
                    .addComponent(rbLivros)
                    .addComponent(rbCompleto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbVelhoTestamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNovoTestamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbLivros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbLivrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbLivrosItemStateChanged
        // TODO add your handling code here:
        listLivros.setSelectedIndex(0);
    }//GEN-LAST:event_rbLivrosItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!tfPesquisa.getText().equals("")) {
            pesquisarVerso();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listLivrosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listLivrosValueChanged
        // TODO add your handling code here:

        if (!rbLivros.isSelected()) {
            rbLivros.setSelected(true);
        }
    }//GEN-LAST:event_listLivrosValueChanged

    private void tblaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaPesquisaMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() > 1) {

            int index = tblaPesquisa.getSelectedRow();

            Livro liv = daoLivro.getLivro(vers.get(index).getLivro());
            PainelCapitulo capitulo = new PainelCapitulo(liv);
            capitulo.selectVersoFavorito(vers.get(index));

            frm.addTabPane(liv.getNome_livro(), capitulo);

        }

    }//GEN-LAST:event_tblaPesquisaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listLivros;
    private javax.swing.JRadioButton rbCompleto;
    private javax.swing.JRadioButton rbLivros;
    private javax.swing.JRadioButton rbNovoTestamento;
    private javax.swing.JRadioButton rbVelhoTestamento;
    private javax.swing.JTable tblaPesquisa;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables
}
