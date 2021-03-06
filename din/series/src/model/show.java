
package model;

import java.io.Serializable;

/**
 *
 * @author amrsin
 */
public class show implements Serializable {

    private String title;
    private String scriptwriter;
    private int seasons;
    private String genere;
    private int views;
    private String platform;

    public show() {

        this.title = "";
        this.scriptwriter = "";
        this.seasons = 0;
        this.genere = "";
        this.views = 0;
        this.platform = "";

    }

    public show(String title, String scriptwriter, int seasons, String genere, int views, String platform) {
        this.title = title;
        this.scriptwriter = scriptwriter;
        this.seasons = seasons;
        this.genere = genere;
        this.views = views;
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }  

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }  
}