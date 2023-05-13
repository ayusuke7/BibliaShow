package View;

import View.Dialogs.DialogConfiguracoes;
import View.Panels.PainelCapitulo;
import View.Panels.PainelPesquisa;
import View.Panels.PainelFavoritos;
import View.Panels.PainelMedia;
import View.Panels.PainelCanticos;
import View.Panels.PainelGaleria;
import View.Panels.PainelAvisos;
import Controller.DAOLivro;
import Modell.Livro;
import Modell.Renderer.ButtonTabComponent;
import Util.AplicarLookAndFeel;
import Util.IconeAplication;
import Util.Propriedades;
import View.Dialogs.DialogCarregamento;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Alexandre
 */
public class FrmBiblia extends javax.swing.JFrame {

    private final DAOLivro daoLivro;
    private ArrayList<Livro> livros;
    private final Propriedades padroes;
    private String temaSystem, temaSelect;

    private int cont = 0;

    public FrmBiblia(String tema) {
        initComponents();
        daoLivro = new DAOLivro();
        padroes = new Propriedades();
        listLivrosDB();
        selectTema(tema);
        setIconImage(IconeAplication.getIcone());
        cbLivros.setSelectedIndex(1);

        getDataHora();
    }

    private void getDataHora() {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = df.format(new Date());
        txtVersiculos.setText("Iniciado às " + data);

        Timer time = new Timer(1000, (ActionEvent e) -> {

            int segundo = cont % 60;            
            int minuto = (cont / 60) % 60;
            int hora = (cont / 60) / 60;

            tfTime.setText(String.format("Tempo de execução %02d:%02d:%02d", hora, minuto, segundo));
            cont++;

        });

        time.start();

    }

    public void addTabPane(String titulo, Component comp) {

        painelAbas.addTab(titulo, comp);
        painelAbas.setSelectedComponent(comp);
        int index = painelAbas.getSelectedIndex();
        painelAbas.setTabComponentAt(index, new ButtonTabComponent(painelAbas));

    }

    private void selectTema(String tema) {

        temaSystem = tema;

        if (rbMenuAcryl.getText().equals(tema)) {
            rbMenuAcryl.setSelected(true);
            temaSelect = rbMenuAcryl.getText();
        }

        if (rbMenuAluminium.getText().equals(tema)) {
            rbMenuAluminium.setSelected(true);
            temaSelect = rbMenuAluminium.getText();
        }
        if (rbMenuLuna.getText().equals(tema)) {
            rbMenuLuna.setSelected(true);
            temaSelect = rbMenuLuna.getText();
        }
        if (rbMenuMint.getText().equals(tema)) {
            rbMenuMint.setSelected(true);
            temaSelect = rbMenuMint.getText();
        }
        if (rbMenuSmart.getText().equals(tema)) {
            rbMenuSmart.setSelected(true);
            temaSelect = rbMenuSmart.getText();
        }
        if (rbMenuWindows.getText().equals(tema)) {
            rbMenuWindows.setSelected(true);
            temaSelect = rbMenuWindows.getText();
        }
        if (rbMenuNimbus.getText().equals(tema)) {
            rbMenuNimbus.setSelected(true);
            temaSelect = rbMenuNimbus.getText();
        }

    }

    private void listLivrosDB() {

        String sql;

        if (jCheckBox1.isSelected()) {
            sql = "SELECT * FROM Livros ORDER By Nome";
        } else {
            sql = "SELECT * FROM Livros";
        }

        livros = daoLivro.listLivros(sql);

        cbLivros.removeAllItems();
        cbLivros.addItem("Selecione um Livro...");

        livros.stream().forEach((l) -> {
            cbLivros.addItem(l.getNome_livro() + " - " + l.getAbrev());
        });

    }

    private void sairSistema() {

        if (!temaSystem.equals(temaSelect)) {
            int op = JOptionPane.showConfirmDialog(null, "HOUVE UMA ALTERAÇÃO NO TEMA, SALVAR?",
                    "ALTERAR TEMA?", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                Properties prop = padroes.loadProperties();
                prop.setProperty("props.theme", temaSelect);
                padroes.setProperties(prop);
            }
        }

        System.exit(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        toolBarBotoes = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jCheckBox1 = new javax.swing.JCheckBox();
        cbLivros = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSearch = new javax.swing.JButton();
        btnCanticos = new javax.swing.JButton();
        btnGaleria = new javax.swing.JButton();
        btnVideos = new javax.swing.JButton();
        btnFavorite = new javax.swing.JButton();
        btnAvisos = new javax.swing.JButton();
        btnPadroes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        painelAbas = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        txtVersiculos = new javax.swing.JTextField();
        tfTime = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        rbMenuAcryl = new javax.swing.JRadioButtonMenuItem();
        rbMenuAluminium = new javax.swing.JRadioButtonMenuItem();
        rbMenuLuna = new javax.swing.JRadioButtonMenuItem();
        rbMenuMint = new javax.swing.JRadioButtonMenuItem();
        rbMenuSmart = new javax.swing.JRadioButtonMenuItem();
        rbMenuWindows = new javax.swing.JRadioButtonMenuItem();
        rbMenuNimbus = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Biblia Show");
        setMinimumSize(new java.awt.Dimension(800, 600));

        toolBarBotoes.setFloatable(false);
        toolBarBotoes.setRollover(true);
        toolBarBotoes.add(jSeparator3);

        jCheckBox1.setText("Ordem");
        jCheckBox1.setToolTipText("Ordenar Livros");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setMaximumSize(new java.awt.Dimension(50, 40));
        jCheckBox1.setMinimumSize(new java.awt.Dimension(50, 40));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(50, 40));
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        toolBarBotoes.add(jCheckBox1);

        cbLivros.setMaximumRowCount(20);
        cbLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbLivros.setMaximumSize(new java.awt.Dimension(200, 40));
        cbLivros.setMinimumSize(new java.awt.Dimension(200, 40));
        cbLivros.setPreferredSize(new java.awt.Dimension(200, 40));
        cbLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLivrosActionPerformed(evt);
            }
        });
        toolBarBotoes.add(cbLivros);

        jSeparator2.setMaximumSize(new java.awt.Dimension(16, 32767));
        jSeparator2.setMinimumSize(new java.awt.Dimension(16, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(16, 0));
        jSeparator2.setRequestFocusEnabled(false);
        toolBarBotoes.add(jSeparator2);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-icon.png"))); // NOI18N
        btnSearch.setToolTipText("Pesquisar na Biblia");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnSearch);

        btnCanticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/music.png"))); // NOI18N
        btnCanticos.setToolTipText("Cânticos");
        btnCanticos.setFocusable(false);
        btnCanticos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCanticos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCanticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanticosActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnCanticos);

        btnGaleria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pictures-icon.png"))); // NOI18N
        btnGaleria.setToolTipText("Imagens");
        btnGaleria.setFocusable(false);
        btnGaleria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGaleria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGaleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaleriaActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnGaleria);

        btnVideos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vlc-icon.png"))); // NOI18N
        btnVideos.setToolTipText("Media Player");
        btnVideos.setFocusable(false);
        btnVideos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVideos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideosActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnVideos);

        btnFavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/favorite-icon.png"))); // NOI18N
        btnFavorite.setToolTipText("Favoritos");
        btnFavorite.setFocusable(false);
        btnFavorite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFavorite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoriteActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnFavorite);

        btnAvisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warning-icon.png"))); // NOI18N
        btnAvisos.setToolTipText("Avisos");
        btnAvisos.setFocusable(false);
        btnAvisos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAvisos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAvisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvisosActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnAvisos);

        btnPadroes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gear-icon.png"))); // NOI18N
        btnPadroes.setToolTipText("Configurações");
        btnPadroes.setFocusable(false);
        btnPadroes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPadroes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPadroes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadroesActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnPadroes);

        jSeparator1.setMaximumSize(new java.awt.Dimension(16, 32767));
        jSeparator1.setMinimumSize(new java.awt.Dimension(16, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(16, 0));
        toolBarBotoes.add(jSeparator1);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Off-icon.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        toolBarBotoes.add(btnSair);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        txtVersiculos.setEditable(false);
        txtVersiculos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jToolBar1.add(txtVersiculos);

        tfTime.setEditable(false);
        tfTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jToolBar1.add(tfTime);

        jMenu1.setText("Atalhos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Cânticos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Videos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Imagens");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Favoritas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Avisos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem6.setText("Pesquisa");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Skins");

        buttonGroup1.add(rbMenuAcryl);
        rbMenuAcryl.setSelected(true);
        rbMenuAcryl.setText("Acryl");
        rbMenuAcryl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuAcrylActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuAcryl);

        buttonGroup1.add(rbMenuAluminium);
        rbMenuAluminium.setText("Aluminium");
        rbMenuAluminium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuAluminiumActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuAluminium);

        buttonGroup1.add(rbMenuLuna);
        rbMenuLuna.setText("Luna");
        rbMenuLuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuLunaActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuLuna);

        buttonGroup1.add(rbMenuMint);
        rbMenuMint.setText("Mint");
        rbMenuMint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuMintActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuMint);

        buttonGroup1.add(rbMenuSmart);
        rbMenuSmart.setText("Smart");
        rbMenuSmart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuSmartActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuSmart);

        buttonGroup1.add(rbMenuWindows);
        rbMenuWindows.setText("Windows");
        rbMenuWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuWindowsActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuWindows);

        buttonGroup1.add(rbMenuNimbus);
        rbMenuNimbus.setText("Nimbus");
        rbMenuNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMenuNimbusActionPerformed(evt);
            }
        });
        jMenu3.add(rbMenuNimbus);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Sobre");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBarBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelAbas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolBarBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(916, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:

        sairSistema();

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPadroesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadroesActionPerformed
        // TODO add your handling code here:

        DialogConfiguracoes frm = new DialogConfiguracoes(new JFrame(), true);
        frm.setVisible(true);

    }//GEN-LAST:event_btnPadroesActionPerformed

    private void btnCanticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanticosActionPerformed
        // TODO add your handling code here:

        PainelCanticos canticos = new PainelCanticos();
        addTabPane("Canticos", canticos);

    }//GEN-LAST:event_btnCanticosActionPerformed

    private void btnFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoriteActionPerformed
        // TODO add your handling code here:

        PainelFavoritos canticos = new PainelFavoritos(this);
        addTabPane("Favoritos", canticos);


    }//GEN-LAST:event_btnFavoriteActionPerformed

    private void cbLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLivrosActionPerformed
        // TODO add your handling code here:

        int index = cbLivros.getSelectedIndex();

        if (index > 0) {
            Livro livro = livros.get(index - 1);
            PainelCapitulo painel = new PainelCapitulo(livro);
            addTabPane(cbLivros.getSelectedItem().toString(), painel);
            cbLivros.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbLivrosActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        PainelPesquisa painel = new PainelPesquisa(this);
        addTabPane("Pesquisa", painel);


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAvisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvisosActionPerformed
        // TODO add your handling code here:

        PainelAvisos painel = new PainelAvisos();
        addTabPane("Avisos", painel);

    }//GEN-LAST:event_btnAvisosActionPerformed

    private void btnVideosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideosActionPerformed
        // TODO add your handling code here:

        PainelMedia painel = new PainelMedia();
        addTabPane("Media Player", painel);

    }//GEN-LAST:event_btnVideosActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:

        DialogCarregamento frm = new DialogCarregamento(this, true, true);
        frm.setVisible(true);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

        listLivrosDB();


    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnGaleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaleriaActionPerformed
        // TODO add your handling code here:

        PainelGaleria galeria = new PainelGaleria();
        addTabPane("Galeria", galeria);

    }//GEN-LAST:event_btnGaleriaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        PainelCanticos canticos = new PainelCanticos();
        addTabPane("Canticos", canticos);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:        

        PainelMedia painel = new PainelMedia();
        addTabPane("Media Player", painel);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        PainelGaleria galeria = new PainelGaleria();
        addTabPane("Galeria", galeria);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        PainelFavoritos canticos = new PainelFavoritos(this);
        addTabPane("Favoritos", canticos);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        PainelAvisos painel = new PainelAvisos();
        addTabPane("Avisos", painel);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        PainelPesquisa painel = new PainelPesquisa(this);
        addTabPane("Pesquisa", painel);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void rbMenuAcrylActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuAcrylActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuAcryl.getText());
        temaSelect = rbMenuAcryl.getText();
    }//GEN-LAST:event_rbMenuAcrylActionPerformed

    private void rbMenuAluminiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuAluminiumActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuAluminium.getText());
        temaSelect = rbMenuAluminium.getText();
    }//GEN-LAST:event_rbMenuAluminiumActionPerformed

    private void rbMenuLunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuLunaActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuLuna.getText());
        temaSelect = rbMenuLuna.getText();
    }//GEN-LAST:event_rbMenuLunaActionPerformed

    private void rbMenuMintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuMintActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuMint.getText());
        temaSelect = rbMenuMint.getText();
    }//GEN-LAST:event_rbMenuMintActionPerformed

    private void rbMenuSmartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuSmartActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuSmart.getText());
        temaSelect = rbMenuSmart.getText();
    }//GEN-LAST:event_rbMenuSmartActionPerformed

    private void rbMenuWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuWindowsActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuWindows.getText());
        temaSelect = rbMenuWindows.getText();
    }//GEN-LAST:event_rbMenuWindowsActionPerformed

    private void rbMenuNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMenuNimbusActionPerformed
        // TODO add your handling code here:
        new AplicarLookAndFeel(this).aplicar(rbMenuNimbus.getText());
        temaSelect = rbMenuNimbus.getText();
    }//GEN-LAST:event_rbMenuNimbusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvisos;
    private javax.swing.JButton btnCanticos;
    private javax.swing.JButton btnFavorite;
    private javax.swing.JButton btnGaleria;
    private javax.swing.JButton btnPadroes;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnVideos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbLivros;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTabbedPane painelAbas;
    private javax.swing.JRadioButtonMenuItem rbMenuAcryl;
    private javax.swing.JRadioButtonMenuItem rbMenuAluminium;
    private javax.swing.JRadioButtonMenuItem rbMenuLuna;
    private javax.swing.JRadioButtonMenuItem rbMenuMint;
    private javax.swing.JRadioButtonMenuItem rbMenuNimbus;
    private javax.swing.JRadioButtonMenuItem rbMenuSmart;
    private javax.swing.JRadioButtonMenuItem rbMenuWindows;
    private javax.swing.JTextField tfTime;
    private javax.swing.JToolBar toolBarBotoes;
    private javax.swing.JTextField txtVersiculos;
    // End of variables declaration//GEN-END:variables
}
