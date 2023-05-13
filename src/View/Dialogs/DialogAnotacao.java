package View.Dialogs;

import Controller.DAOLivro;
import Controller.DAONota;
import Modell.Nota;

/**
 *
 * @author YU7
 */
public class DialogAnotacao extends javax.swing.JDialog {

    private final Nota nota;
    private final DAONota dao;

    /**
     * Creates new form FrmDialogNota
     *
     * @param parent
     * @param modal
     * @param nota
     */
    public DialogAnotacao(java.awt.Frame parent, boolean modal, Nota nota) {
        super(parent, modal);
        initComponents();
        this.nota = nota;
        this.dao = new DAONota();

        setTitle("Nota em: " + new DAOLivro().getLivro(nota.getLivro()).getNome_livro()
                + " Capitulo " + nota.getCapitulo());

        if (nota.getCodigo() > 0) {
            txtAnotacao.setText(nota.getNota());
            btnRemove.setEnabled(true);
            btnSalvar.setText("Atualizar");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSalvar = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAnotacao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anotação");
        setMinimumSize(new java.awt.Dimension(400, 200));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-icon.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setIconTextGap(8);
        btnSalvar.setMargin(new java.awt.Insets(2, 10, 2, 14));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-icon.png"))); // NOI18N
        btnRemove.setText("Remover");
        btnRemove.setEnabled(false);
        btnRemove.setIconTextGap(6);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemove);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.add(jTextField1);

        btnSair.setBackground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shut32.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setIconTextGap(6);
        btnSair.setPreferredSize(new java.awt.Dimension(70, 39));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);

        txtAnotacao.setBackground(new java.awt.Color(255, 255, 204));
        txtAnotacao.setColumns(20);
        txtAnotacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAnotacao.setLineWrap(true);
        txtAnotacao.setRows(5);
        txtAnotacao.setToolTipText("Anotação para o Livro");
        txtAnotacao.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAnotacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (!txtAnotacao.getText().equals("")) {

            nota.setNota(txtAnotacao.getText());

            if (btnSalvar.getText().equals("Salvar")) {
                dao.addNota(nota);
            } else {
                dao.updateNota(nota);
            }

            this.dispose();

        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:

        if (dao.deleteNota(nota.getCodigo())) {
            this.dispose();
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea txtAnotacao;
    // End of variables declaration//GEN-END:variables
}
