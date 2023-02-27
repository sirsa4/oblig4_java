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

    //get single specific episode from a given season
    public void getSingleEpisode(Context context){
        //data that is pulled from pathPram() is similar to the method above this.
        //TVSerie name from browser url
        String serie = context.pathParam("tvserie-id");

        //season number from url too
        int seasonNumber = Integer.parseInt(context.pathParam("sesong-nr"));

        //episode number from url
        int episodeNumber = Integer.parseInt(context.pathParam("episode-nr"));

        //use the method in TVSerieDataRepository class to get a single episode
        Episode singleEpisode = episodeRepo.getEpisodeInSeason(serie,seasonNumber,episodeNumber);

        //send JSON response to user which is matches the browser url
        context.json(singleEpisode);

    }

}//end of class
