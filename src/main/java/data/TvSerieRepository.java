package data;

import model.TVSerie;

import java.util.ArrayList;

//oppgave 2.5
public interface TvSerieRepository {
    //method to get a single TVSerie object
    TVSerie getSingleTVSerie(String tvSerie);

    //method to get all TVSerie objects
    ArrayList<TVSerie> getAllTVSerie();
}
