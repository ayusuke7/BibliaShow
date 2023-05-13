package View;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author AYU7-WN
 */
public class FrmReprodutor extends javax.swing.JFrame {

    public final EmbeddedMediaPlayerComponent player;
    
    private final File file;    
    private boolean band = true;
    private int time;
       

    public FrmReprodutor(File arquivo, String vlc) {
        initComponents();
        
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlc);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        this.player = new EmbeddedMediaPlayerComponent();
        painelPlayer.add(player);
        player.setSize(painelPlayer.getSize());
        player.setVisible(true);

        this.file = arquivo;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setFocusableWindowState(false);

    }

    public void play() {

        if (file != null) {
            player.getMediaPlayer().playMedia(file.getAbsolutePath());
        }

    }

    public void pauseResume() {
        player.getMediaPlayer().setPause(player.getMediaPlayer().isPlaying());
    }

    public void stop() {
        player.getMediaPlayer().stop();
    }

    public void mute(boolean op) {
        player.getMediaPlayer().mute(op);
    }

    public void changeVolume(int value) {
        player.getMediaPlayer().setVolume(value);
    }

    public void changeTime(float value) {
        
        if (!isBand()) {
            player.getMediaPlayer().setPosition(value);
        }
    }

    public void exit(){
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPlayer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setUndecorated(true);

        painelPlayer.setLayout(new javax.swing.BoxLayout(painelPlayer, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(painelPlayer, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel painelPlayer;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the band
     */
    public boolean isBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(boolean band) {
        this.band = band;
    }
}
