package model;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author amrsin
 */
public class listShow implements Serializable {

    private ArrayList<show> seriesList;

    public listShow(ArrayList<show> seriesList) {
        this.seriesList = seriesList;
    }

    public listShow() {

        seriesList = new ArrayList<>();
    }

    public show getShow(int p) {

        return seriesList.get(p);
    }

    public void setShow(show s) {

        seriesList.add(s);
    }

    public int longitud() {
        return seriesList.size();
    }

    public void delete(show s) {

        seriesList.remove(s);
    }

    public void modify(show s, String title,
            String screenwriter, int season, String genre, int seen_season, String platform) {

        s.setTitle(title);
        s.setScriptwriter(screenwriter);
        s.setSeasons(season);
        s.setGenere(genre);
        s.setViews(seen_season);
        s.setPlatform(platform);
    }
}
