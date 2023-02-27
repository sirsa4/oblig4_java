package controller;

import data.TvSerieRepository;
import io.javalin.http.Context;
import model.Episode;

import java.util.ArrayList;

public class EpisodeController {
    //oppgave 2.7
    private TvSerieRepository episodeRepo;

    public EpisodeController(TvSerieRepository episodeRepo) {
        this.episodeRepo = episodeRepo;
    }

    //get all episodes in a given season
    public void getEpisodes(Context context){
        //get TVSerie name from browser url
        String serie = context.pathParam("tvserie-id");

        //get season number from browser url too
        //this needs casted into int datatype since everything browser url is by default a string datatype.
        int seasonNumber = Integer.parseInt(context.pathParam("sesong-id"));

        //get the correct TVSerie and correct season number using the method defined in the datarepository
        ArrayList<Episode> episodesInSeason = episodeRepo.getEpisodesInSeason(serie,seasonNumber);

        //send json reponse to user
        context.json(episodesInSeason);

    }

}//end of class
