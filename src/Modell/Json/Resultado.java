package Modell.Json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultado {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("art")
    @Expose
    private Artista artista;
    @SerializedName("mus")
    @Expose
    private List<Musica> musicas;
    @SerializedName("badwords")
    @Expose
    private Boolean badwords;

    public Resultado() {
    }

    public Resultado(String type, Artista art, List<Musica> mus, Boolean badwords) {
        this.type = type;
        this.artista = art;
        this.musicas = mus;
        this.badwords = badwords;
    }
    
    public String getType() {
        return type;
    }

    public Artista getArtista() {
        return artista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Boolean getBadwords() {
        return badwords;
    }
}
