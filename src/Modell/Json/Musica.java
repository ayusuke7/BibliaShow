package Modell.Json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author AYU7-WN
 */
public class Musica {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lang")
    @Expose
    private Integer lang;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("translate")
    @Expose
    private List<Translate> translate;

    public Musica() {
    
    }

    public Musica(String id, String name, String url, Integer lang, String text, List<Translate> translate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.lang = lang;
        this.text = text;
        this.translate = translate;
    }
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getLang() {
        return lang;
    }

    public String getText() {
        return text;
    }

    public List<Translate> getTranslate() {
        return translate;
    }

}
