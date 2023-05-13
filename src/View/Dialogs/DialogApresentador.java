package View.Dialogs;

import Modell.Renderer.CustomHightlines;
import Modell.Renderer.ItemListTextArea;
import Util.ControleArquivos;
import Util.IconeAplication;
import Util.Propriedades;
import View.FrmVisualizador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AYU7-WN
 */
public class DialogApresentador extends javax.swing.JDialog {

    private final FrmVisualizador frm;
    private Color corFonte, corFundo;
    private final GraphicsEnvironment ge;

    private final String textoOriginal;
    public String arquivoSelecionado;

    private final CustomHightlines custom;

    /**
     * Creates new form FrmDialogCapitulo
     *
     * @param parent
     * @param modal
     * @param texto
     * @param tipo
     *
     */
    public DialogApresentador(Frame parent, boolean modal, String texto, int tipo) {
        super(parent, modal);
        initComponents();
        setAcessibilidade();
        this.frm = new FrmVisualizador();
        this.custom = new CustomHightlines(Color.YELLOW);

        this.textoOriginal = texto;
        txtLetra.setText(texto);
        txtLetra.setCaretPosition(0);

        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        getPadroes(tipo);
        splitSlides(0);
        setTelas();

        setIconImage(IconeAplication.getIcone());

    }

    private void setTelas() {

        GraphicsDevice[] telas = ge.getScreenDevices();

        if (telas.length > 1) {
            for (GraphicsDevice g : telas) {
                g.setFullScreenWindow(frm);
            }
        } else {
            frm.setVisible(true);
        }

    }

    private void getPadroes(int fundo) {

        String fonts[] = ge.getAvailableFontFamilyNames();

        //Lista Fontes
        for (String f : fonts) {
            cbFonte.addItem(f);
        }

        Properties props = new Propriedades().loadProperties();

        cbFonte.setSelectedItem(props.getProperty("props.font"));
        cbEstilo.setSelectedIndex(Integer.parseInt(props.getProperty("props.style")));
        spnTamanho.setValue(Integer.parseInt(props.getProperty("props.size")));
        corFonte = new Color(Integer.parseInt(props.getProperty("props.corfonte")));
        corFundo = new Color(Integer.parseInt(props.getProperty("props.corfundo")));

        cbAlignHor.setSelectedItem(props.getProperty("props.alignHor"));
        cbAlignVer.setSelectedItem(props.getProperty("props.alignVer"));

        frm.setBackground(corFundo);
        frm.lbTexto.setForeground(corFonte);

        txtLetra.setBackground(corFundo);
        txtLetra.setForeground(corFonte);
        txtLetra.setCaretColor(corFonte);

        String img;

        switch (fundo) {
            case 1:
                img = props.getProperty("props.imgcanticos");
                break;
            case 2:
                img = props.getProperty("props.imgbiblia");
                break;
            default:
                img = props.getProperty("props.imgavisos");
                break;
        }

        if (!img.equals("")) {
            try {
                String path = System.getProperty("user.dir");
                frm.setBackground(ImageIO.read(new File(path + "/imagens/" + img)));
            } catch (IOException ex) {
                Logger.getLogger(DialogConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        setAlinhamentos();
        setFonte();

    }

    private void splitSlides(int select) {

        String[] split = txtLetra.getText().split("\n\n");
        DefaultListModel model = new DefaultListModel();

        for (String s : split) {
            model.addElement(s);
        }

        listSlide.setModel(model);
        listSlide.setCellRenderer(new ItemListTextArea());
        listSlide.setSelectedIndex(select);

    }

    private void setAlinhamentos() {
        switch (cbAlignHor.getSelectedItem().toString()) {
            case "ESQUERDA":
                frm.lbTexto.setHorizontalAlignment(JLabel.LEFT);
                break;
            case "CENTRO":
                frm.lbTexto.setHorizontalAlignment(JLabel.CENTER);
                break;
            case "DIREITA":
                frm.lbTexto.setHorizontalAlignment(JLabel.RIGHT);
                break;
        }

        switch (cbAlignVer.getSelectedItem().toString()) {
            case "TOPO":
                frm.lbTexto.setVerticalAlignment(JLabel.TOP);
                break;
            case "CENTRO":
                frm.lbTexto.setVerticalAlignment(JLabel.CENTER);
                break;
            case "BAIXO":
                frm.lbTexto.setVerticalAlignment(JLabel.BOTTOM);
                break;
        }
    }

    private void setFonte() {

        String font = cbFonte.getSelectedItem().toString();
        int style = cbEstilo.getSelectedIndex();

        txtLetra.setFont(new Font(font, style, 18));
        frm.lbTexto.setFont(new Font(font, style, (int) spnTamanho.getValue()));

    }

    private void finalizar() {

        if (!txtLetra.getText().equals(textoOriginal)) {

            int op = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "SALVAR",
                    JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                if (arquivoSelecionado != null) {
                    ControleArquivos control = new ControleArquivos();
                    control.gravarArquivo(arquivoSelecionado, txtLetra.getText(), false);
                }
            }
        }

        frm.dispose();
        dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarPadroes = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSearch = new javax.swing.JButton();
        btnGaleria = new javax.swing.JButton();
        btnRemoveBack = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btCorFonte = new javax.swing.JButton();
        btCorFundo = new javax.swing.JButton();
        cbFonte = new javax.swing.JComboBox<>();
        cbEstilo = new javax.swing.JComboBox<>();
        cbAlignHor = new javax.swing.JComboBox<>();
        cbAlignVer = new javax.swing.JComboBox<>();
        spnTamanho = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnFinalizar = new javax.swing.JButton();
        splitVert = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSlide = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLetra = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Apresentador");
        setMinimumSize(new java.awt.Dimension(730, 80));

        toolbarPadroes.setFloatable(false);
        toolbarPadroes.setRollover(true);
        toolbarPadroes.setMaximumSize(new java.awt.Dimension(2147483647, 33));
        toolbarPadroes.setPreferredSize(new java.awt.Dimension(100, 33));
        toolbarPadroes.add(jSeparator1);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search24.png"))); // NOI18N
        btnSearch.setToolTipText("Carregar Galeria");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btnSearch);

        btnGaleria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Image-icon.png"))); // NOI18N
        btnGaleria.setToolTipText("Carregar Galeria");
        btnGaleria.setFocusable(false);
        btnGaleria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGaleria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGaleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaleriaActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btnGaleria);

        btnRemoveBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Imageremove.png"))); // NOI18N
        btnRemoveBack.setToolTipText("Remover Background");
        btnRemoveBack.setFocusable(false);
        btnRemoveBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemoveBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemoveBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBackActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btnRemoveBack);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/first-icon.png"))); // NOI18N
        jButton2.setToolTipText("Primeiro Slide");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        toolbarPadroes.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prev-icon.png"))); // NOI18N
        jButton3.setToolTipText("Slide Anterior");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        toolbarPadroes.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        jButton4.setToolTipText("Proximo Slide");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        toolbarPadroes.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/last-icon.png"))); // NOI18N
        jButton5.setToolTipText("Ultimo Slide");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        toolbarPadroes.add(jButton5);
        toolbarPadroes.add(jSeparator3);

        btCorFonte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/font-icon.png"))); // NOI18N
        btCorFonte.setToolTipText("Cor da Fonte");
        btCorFonte.setFocusable(false);
        btCorFonte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCorFonte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCorFonte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCorFonteActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btCorFonte);

        btCorFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fundo-icon.png"))); // NOI18N
        btCorFundo.setToolTipText("Cor de fundo");
        btCorFundo.setFocusable(false);
        btCorFundo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCorFundo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCorFundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCorFundoActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btCorFundo);

        cbFonte.setMaximumRowCount(20);
        cbFonte.setToolTipText("Fontes");
        cbFonte.setMaximumSize(new java.awt.Dimension(100, 30));
        cbFonte.setMinimumSize(new java.awt.Dimension(100, 30));
        cbFonte.setPreferredSize(new java.awt.Dimension(100, 30));
        cbFonte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFonteItemStateChanged(evt);
            }
        });
        toolbarPadroes.add(cbFonte);

        cbEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Negrito", "Itálico" }));
        cbEstilo.setToolTipText("Tipos");
        cbEstilo.setMaximumSize(new java.awt.Dimension(100, 30));
        cbEstilo.setMinimumSize(new java.awt.Dimension(100, 30));
        cbEstilo.setPreferredSize(new java.awt.Dimension(100, 30));
        cbEstilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstiloItemStateChanged(evt);
            }
        });
        toolbarPadroes.add(cbEstilo);

        cbAlignHor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESQUERDA", "CENTRO", "DIREITA" }));
        cbAlignHor.setToolTipText("Alinhamento Horizontal");
        cbAlignHor.setMaximumSize(new java.awt.Dimension(100, 30));
        cbAlignHor.setMinimumSize(new java.awt.Dimension(100, 30));
        cbAlignHor.setPreferredSize(new java.awt.Dimension(100, 30));
        cbAlignHor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAlignHorItemStateChanged(evt);
            }
        });
        toolbarPadroes.add(cbAlignHor);

        cbAlignVer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TOPO", "CENTRO", "BAIXO" }));
        cbAlignVer.setToolTipText("Aliinhamento Vertical");
        cbAlignVer.setMaximumSize(new java.awt.Dimension(100, 30));
        cbAlignVer.setMinimumSize(new java.awt.Dimension(100, 30));
        cbAlignVer.setPreferredSize(new java.awt.Dimension(100, 30));
        cbAlignVer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAlignVerItemStateChanged(evt);
            }
        });
        toolbarPadroes.add(cbAlignVer);

        spnTamanho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spnTamanho.setModel(new javax.swing.SpinnerNumberModel(8, 8, 100, 2));
        spnTamanho.setToolTipText("Tamanho da Fonte");
        spnTamanho.setMaximumSize(new java.awt.Dimension(60, 30));
        spnTamanho.setMinimumSize(new java.awt.Dimension(60, 30));
        spnTamanho.setPreferredSize(new java.awt.Dimension(60, 30));
        spnTamanho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTamanhoStateChanged(evt);
            }
        });
        toolbarPadroes.add(spnTamanho);
        toolbarPadroes.add(jSeparator4);

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close-icon.png"))); // NOI18N
        btnFinalizar.setToolTipText("Fechar Apresentação");
        btnFinalizar.setFocusable(false);
        btnFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        toolbarPadroes.add(btnFinalizar);

        splitVert.setDividerLocation(400);
        splitVert.setDividerSize(10);
        splitVert.setOneTouchExpandable(true);

        listSlide.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSlide.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSlideValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listSlide);

        splitVert.setLeftComponent(jScrollPane1);

        txtLetra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLetraFocusLost(evt);
            }
        });
        txtLetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLetraKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtLetra);

        splitVert.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarPadroes, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(splitVert, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolbarPadroes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitVert, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCorFundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCorFundoActionPerformed
        // TODO add your handling code here:
        corFundo = JColorChooser.showDialog(null, "Cor de Fundo", Color.WHITE);
        frm.setBackground(corFundo);
        txtLetra.setBackground(corFundo);
    }//GEN-LAST:event_btCorFundoActionPerformed

    private void btCorFonteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCorFonteActionPerformed
        // TODO add your handling code here:
        corFonte = JColorChooser.showDialog(null, "Cor da Fonte", Color.BLACK);
        frm.lbTexto.setForeground(corFonte);
        txtLetra.setForeground(corFonte);
        txtLetra.setCaretColor(corFonte);

    }//GEN-LAST:event_btCorFonteActionPerformed

    private void cbFonteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFonteItemStateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_cbFonteItemStateChanged

    private void cbEstiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstiloItemStateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_cbEstiloItemStateChanged

    private void spnTamanhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTamanhoStateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_spnTamanhoStateChanged

    private void listSlideValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSlideValueChanged
        // TODO add your handling code here:

        String formater = listSlide.getSelectedValue();

        if (formater != null) {
            String html = "<html>" + formater.replace("\n", "<br/>") + "</html>";
            frm.lbTexto.setText(html);
            custom.addHigthlight(txtLetra, formater);

            if (listSlide.getSelectedIndex() == 0) {
                txtLetra.setCaretPosition(0);
            } else {
                txtLetra.setCaretPosition(txtLetra.getText().indexOf(formater) + formater.length());
            }

        }

    }//GEN-LAST:event_listSlideValueChanged

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        finalizar();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        listSlide.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int index = listSlide.getSelectedIndex();

        if (index > 0) {
            listSlide.setSelectedIndex(index - 1);
        } else {
            listSlide.setSelectedIndex(listSlide.getModel().getSize() - 1);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        int index = listSlide.getSelectedIndex();

        if (index < listSlide.getModel().getSize() - 1) {
            listSlide.setSelectedIndex(index + 1);
        } else {
            listSlide.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        listSlide.setSelectedIndex(listSlide.getModel().getSize() - 1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnGaleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaleriaActionPerformed
        // TODO add your handling code here:

        DialogImagens diag = new DialogImagens(new JFrame(), true);
        diag.setVisible(true);

        if (diag.isConfirma()) {
            frm.setBackground(diag.getBuffImage());
        }

    }//GEN-LAST:event_btnGaleriaActionPerformed

    private void txtLetraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetraKeyReleased
        // TODO add your handling code here:
        //splitSlides(listSlide.getSelectedIndex());
    }//GEN-LAST:event_txtLetraKeyReleased

    private void btnRemoveBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBackActionPerformed
        // TODO add your handling code here:
        frm.removeBackground();
    }//GEN-LAST:event_btnRemoveBackActionPerformed

    private void cbAlignHorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAlignHorItemStateChanged
        // TODO add your handling code here:

        setAlinhamentos();
    }//GEN-LAST:event_cbAlignHorItemStateChanged

    private void cbAlignVerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAlignVerItemStateChanged
        // TODO add your handling code here:

        setAlinhamentos();
    }//GEN-LAST:event_cbAlignVerItemStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        String[] extensions = {"jpeg", "png", "jpg", "gif"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Imagem", extensions);
        busca.setFileFilter(filter);
        busca.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int op = busca.showOpenDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            File file = busca.getSelectedFile();
            try {
                BufferedImage buff = ImageIO.read(file);
                frm.setBackground(buff);
            } catch (IOException ex) {
                Logger.getLogger(DialogApresentador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtLetraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLetraFocusLost
        // TODO add your handling code here:
        splitSlides(listSlide.getSelectedIndex());
    }//GEN-LAST:event_txtLetraFocusLost

    private void setAcessibilidade() {

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        getRootPane().getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizar();
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCorFonte;
    private javax.swing.JButton btCorFundo;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGaleria;
    private javax.swing.JButton btnRemoveBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbAlignHor;
    private javax.swing.JComboBox<String> cbAlignVer;
    private javax.swing.JComboBox<String> cbEstilo;
    private javax.swing.JComboBox<String> cbFonte;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JList<String> listSlide;
    private javax.swing.JSplitPane splitVert;
    private javax.swing.JSpinner spnTamanho;
    private javax.swing.JToolBar toolbarPadroes;
    private javax.swing.JTextPane txtLetra;
    // End of variables declaration//GEN-END:variables

}
