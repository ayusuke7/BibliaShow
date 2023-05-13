package View.Dialogs;

import View.Dialogs.DialogImagens;
import Util.Propriedades;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class DialogConfiguracoes extends javax.swing.JDialog {

    private final String path = System.getProperty("user.dir");
    private final Propriedades man;
    private BufferedImage background;

    public DialogConfiguracoes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.man = new Propriedades();
        listarFontes();
        getPadroes();

    }

    private void listarFontes() {

        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        cbFonte.removeAllItems();
        for (String f : fonts) {
            cbFonte.addItem(f);
        }
    }

    private void getPadroes() {

        Properties props = man.loadProperties();

        cbFonte.setSelectedItem(props.getProperty("props.font"));
        cbEstilo.setSelectedIndex(Integer.parseInt(props.getProperty("props.style")));
        jSpinner1.setValue(Integer.parseInt(props.getProperty("props.size")));

        tfCorFonte.setText(props.getProperty("props.corfonte"));
        Color corfonte = new Color(Integer.parseInt(tfCorFonte.getText()));
        lbTexto.setForeground(corfonte);

        tfCorFundo.setText(props.getProperty("props.corfundo"));
        Color corfundo = new Color(Integer.parseInt(tfCorFundo.getText()));
        panelFundo.setBackground(corfundo);

        cbAlignHor.setSelectedItem(props.getProperty("props.alignHor"));
        cbAlignVer.setSelectedItem(props.getProperty("props.alignVer"));

        jTextField1.setText(props.getProperty("props.imgcanticos"));
        jTextField2.setText(props.getProperty("props.imgbiblia"));
        jTextField3.setText(props.getProperty("props.imgavisos"));

        setImagemFundo();
        setAlinhamentos();
        setFonte();

    }

    private void setImagemFundo() {

        try {

            if (jRadioButton1.isSelected() && !jTextField1.getText().equals("")) {
                background = ImageIO.read(new File(path + "/imagens/" + jTextField1.getText()));
            } else if (jRadioButton2.isSelected() && !jTextField2.getText().equals("")) {
                background = ImageIO.read(new File(path + "/imagens/" + jTextField2.getText()));
            } else if (!jTextField3.getText().equals("")) {
                background = ImageIO.read(new File(path + "/imagens/" + jTextField3.getText()));
            } else {
                background = null;
            }

            repaint();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO AO APLICAR IMAGEM DE FUNDO");
        }

    }

    private void setAlinhamentos() {

        switch (cbAlignHor.getSelectedItem().toString()) {
            case "ESQUERDA":
                lbTexto.setHorizontalAlignment(JLabel.LEFT);
                break;
            case "CENTRO":
                lbTexto.setHorizontalAlignment(JLabel.CENTER);
                break;
            case "DIREITA":
                lbTexto.setHorizontalAlignment(JLabel.RIGHT);
                break;
        }

        switch (cbAlignVer.getSelectedItem().toString()) {
            case "TOPO":
                lbTexto.setVerticalAlignment(JLabel.TOP);
                break;
            case "CENTRO":
                lbTexto.setVerticalAlignment(JLabel.CENTER);
                break;
            case "BAIXO":
                lbTexto.setVerticalAlignment(JLabel.BOTTOM);
                break;
        }
    }

    private void setFonte() {

        String fonte = cbFonte.getSelectedItem().toString();
        int estilo = cbEstilo.getSelectedIndex();
        int tam = (int) jSpinner1.getValue();
        Font font = new Font(fonte, estilo, tam);
        lbTexto.setFont(font);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelFundo = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (background != null) {
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
                }else{
                    this.setBackground(new Color(Integer.parseInt(tfCorFundo.getText())));
                }
            }
        };
        lbTexto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbFonte = new javax.swing.JComboBox<>();
        cbEstilo = new javax.swing.JComboBox<>();
        tfCorFonte = new javax.swing.JTextField();
        tfCorFundo = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        cbAlignHor = new javax.swing.JComboBox<>();
        cbAlignVer = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        btnCanticos = new javax.swing.JButton();
        btnBiblia = new javax.swing.JButton();
        btnAvisos = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Padrões do Apresentador");
        setMinimumSize(new java.awt.Dimension(645, 610));
        setPreferredSize(new java.awt.Dimension(645, 610));
        setResizable(false);

        panelFundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTexto.setText("<html>Configurações <br/>do Apresentador</html>");

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTexto)
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fontes e Cores"));

        cbFonte.setMaximumRowCount(20);
        cbFonte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFonteItemStateChanged(evt);
            }
        });

        cbEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIMPLES", "NEGRITO", "ITALICO" }));
        cbEstilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstiloItemStateChanged(evt);
            }
        });

        tfCorFonte.setEditable(false);
        tfCorFonte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCorFonte.setText("0");
        tfCorFonte.setToolTipText("Cor da Fonte");
        tfCorFonte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tfCorFundo.setEditable(false);
        tfCorFundo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCorFundo.setText("-1");
        tfCorFundo.setToolTipText("Cor de Fundo");
        tfCorFundo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 8, 100, 1));
        jSpinner1.setToolTipText("Min 8 Max 100");
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        cbAlignHor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESQUERDA", "CENTRO", "DIREITA" }));
        cbAlignHor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAlignHorItemStateChanged(evt);
            }
        });

        cbAlignVer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TOPO", "CENTRO", "BAIXO" }));
        cbAlignVer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAlignVerItemStateChanged(evt);
            }
        });

        jButton1.setText("COR FUNDO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("COR FONTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfCorFundo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cbEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbAlignHor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbAlignVer, 0, 107, Short.MAX_VALUE)
                                        .addComponent(jSpinner1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCorFonte, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFonte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlignHor)
                    .addComponent(cbAlignVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstilo))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCorFonte)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tfCorFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Planos de Fundo"));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Cânticos");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Versiculos");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Avisos");
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });

        btnCanticos.setText("...");
        btnCanticos.setToolTipText("Imagem para apresentação de Cãnticos");
        btnCanticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanticosActionPerformed(evt);
            }
        });

        btnBiblia.setText("...");
        btnBiblia.setToolTipText("Imagem para apresentação de Versiculos");
        btnBiblia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBibliaActionPerformed(evt);
            }
        });

        btnAvisos.setText("...");
        btnAvisos.setToolTipText("Imagem para apresentação de Avisos");
        btnAvisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvisosActionPerformed(evt);
            }
        });

        jTextField1.setToolTipText("Imagem para apresentação de Cãnticos");

        jTextField2.setToolTipText("Imagem para apresentação de Versiculos");

        jTextField3.setToolTipText("Imagem para apresentação de Avisos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCanticos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBiblia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(btnCanticos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBiblia))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvisos)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setMaximumSize(new java.awt.Dimension(100, 30));
        jToolBar1.setMinimumSize(new java.awt.Dimension(100, 30));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 30));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-icon.png"))); // NOI18N
        btSalvar.setText("SALVAR");
        btSalvar.setMaximumSize(new java.awt.Dimension(100, 33));
        btSalvar.setPreferredSize(new java.awt.Dimension(80, 50));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        Properties props = man.loadProperties();

        props.setProperty("props.font", cbFonte.getSelectedItem().toString());
        props.setProperty("props.style", String.valueOf(cbEstilo.getSelectedIndex()));
        props.setProperty("props.size", jSpinner1.getValue().toString());
        props.setProperty("props.corfonte", tfCorFonte.getText().trim());
        props.setProperty("props.corfundo", tfCorFundo.getText().trim());
        props.setProperty("props.alignHor", cbAlignHor.getSelectedItem().toString());
        props.setProperty("props.alignVer", cbAlignVer.getSelectedItem().toString());
        props.setProperty("props.imgcanticos", jTextField1.getText());
        props.setProperty("props.imgbiblia", jTextField2.getText());
        props.setProperty("props.imgavisos", jTextField3.getText());

        if (man.setProperties(props)) {
            this.dispose();
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void cbEstiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstiloItemStateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_cbEstiloItemStateChanged

    private void cbFonteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFonteItemStateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_cbFonteItemStateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        setFonte();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void cbAlignHorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAlignHorItemStateChanged
        // TODO add your handling code here:
        setAlinhamentos();
    }//GEN-LAST:event_cbAlignHorItemStateChanged

    private void cbAlignVerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAlignVerItemStateChanged
        // TODO add your handling code here:
        setAlinhamentos();
    }//GEN-LAST:event_cbAlignVerItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Color c = JColorChooser.showDialog(null, "Alterar cor de fundo", Color.WHITE);
        tfCorFonte.setText("" + c.getRGB());
        tfCorFonte.setBackground(c);
        lbTexto.setForeground(c);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Color c = JColorChooser.showDialog(null, "Alterar cor de fundo", Color.WHITE);
        tfCorFundo.setText("" + c.getRGB());
        tfCorFundo.setBackground(c);
        panelFundo.setBackground(c);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        // TODO add your handling code here:
        setImagemFundo();
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        // TODO add your handling code here:
        setImagemFundo();
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        // TODO add your handling code here:
        setImagemFundo();
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void btnCanticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanticosActionPerformed
        // TODO add your handling code here:
        DialogImagens diag = new DialogImagens(new JFrame(), true);
        diag.setVisible(true);
        if (diag.isConfirma()) {
            jTextField1.setText(diag.getPath());            
        } else {
            jTextField1.setText("");
        }
        setImagemFundo();                      
    }//GEN-LAST:event_btnCanticosActionPerformed

    private void btnBibliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBibliaActionPerformed
        // TODO add your handling code here:
        DialogImagens diag = new DialogImagens(new JFrame(), true);
        diag.setVisible(true);
        if (diag.isConfirma()) {
            jTextField2.setText(diag.getPath());
        } else {
            jTextField2.setText("");
        }
        setImagemFundo();
    }//GEN-LAST:event_btnBibliaActionPerformed

    private void btnAvisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvisosActionPerformed
        // TODO add your handling code here:
        DialogImagens diag = new DialogImagens(new JFrame(), true);
        diag.setVisible(true);
        if (diag.isConfirma()) {
            jTextField3.setText(diag.getPath());
        } else {
            jTextField3.setText("");            
        }
        setImagemFundo();
    }//GEN-LAST:event_btnAvisosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btnAvisos;
    private javax.swing.JButton btnBiblia;
    private javax.swing.JButton btnCanticos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbAlignHor;
    private javax.swing.JComboBox<String> cbAlignVer;
    private javax.swing.JComboBox<String> cbEstilo;
    private javax.swing.JComboBox<String> cbFonte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JTextField tfCorFonte;
    private javax.swing.JTextField tfCorFundo;
    // End of variables declaration//GEN-END:variables
}
