package data;

import model.Episode;
import model.TVSerie;

import java.util.ArrayList;

//oppgave 2.5
public interface TvSerieRepository {
    //method to get a single TVSerie object
    TVSerie getSingleTVSerie(String tvSerie);

    //method to get all TVSerie objects
    ArrayList<TVSerie> getAllTVSerie();

    ArrayList<Episode> getEpisodesInSeason(String tvserie,int season);
}
