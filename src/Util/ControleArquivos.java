package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AYU7-WN
 */
public class ControleArquivos {

    private final String _CODIFE = "ISO-8859-1";

    public String lerArquivo(File arquivo) {

        String saida = "";

        try {
            FileInputStream file = new FileInputStream(arquivo);
            BufferedReader in = new BufferedReader(new InputStreamReader(file, _CODIFE));

            while (in.ready()) {
                saida += in.readLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            saida = "ERRO FileNotFoundException: " + ex;
        } catch (IOException ex) {
            saida = "ERRO IOException: " + ex;
        }

        return saida;
    }

    public boolean gravarArquivo(String source, String texto, boolean append) {

        File file = new File(source);
        try {
            FileOutputStream output = new FileOutputStream(file, append);
            //Salva como ANSI windows-1252
            try (OutputStreamWriter print = new OutputStreamWriter(output, _CODIFE)) {
                print.append(texto);
                print.flush();
            }
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO IOException funcao gravarArquivo:\n" + ex);
        }

        return false;
    }

    public boolean removerArquivo(String source) {

        File arquivo = new File(source);

        if (arquivo.exists()) {
            int op = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER ESSE ARQUIVO?",
                    "REMOVER", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                return arquivo.delete();
            }

        }

        return false;
    }

    public ArrayList<String> buscaTextoEmArquivo(String arquivo, String texto) {

        ArrayList<String> letras = new ArrayList<>();
        File[] files = new File(arquivo).listFiles();

        for (File f : files) {

            String saida = lerArquivo(f);

            if (saida.toUpperCase().contains(texto.toUpperCase())) {
                letras.add(f.getName());
            }

        }

        return letras;

    }

}
