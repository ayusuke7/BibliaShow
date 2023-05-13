package Modell.Json;

/**
 *
 * @author AYU7-WN
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translate {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lang")
    @Expose
    private Integer lang;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;

    public String getId() {
        return id;
    }

    public Integer getLang() {
        return lang;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

}
