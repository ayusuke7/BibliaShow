package Modell.Renderer;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author AYU7-WN
 */
public class CustomHightlines extends DefaultHighlighter.DefaultHighlightPainter {

    public CustomHightlines(Color c) {
        super(c);
    }

    public void addHigthlight(JTextComponent component, String text) {

        removeHigthlight(component);

        try {

            Highlighter hig = component.getHighlighter();
            Document doc = component.getDocument();
            String textPrint = doc.getText(0, doc.getLength());

            int pos = 0;

            while ((pos = textPrint.toUpperCase().indexOf(text.toUpperCase(), pos)) >= 0) {
                hig.addHighlight(pos, pos + text.length(), this);
                pos += text.length();
            }

        } catch (BadLocationException ex) {
            Logger.getLogger(CustomHightlines.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeHigthlight(JTextComponent component) {

        Highlighter hig = component.getHighlighter();
        Highlighter.Highlight[] higs = hig.getHighlights();

        for (Highlighter.Highlight h : higs) {
            if (h.getPainter() instanceof CustomHightlines) {
                hig.removeHighlight(h);
            }
        }

    }
}
