package data;

import model.Episode;
import model.Person;
import model.TVSerie;

import java.time.LocalDate;
import java.util.ArrayList;


public class TvSerieDataRepository implements TvSerieRepository {
    //oppgave 2.5
    //instance variable which stores TVseries.
    private ArrayList<TVSerie> series = new ArrayList<>();

    public TvSerieDataRepository(){

        //TVSerie objects
        TVSerie futurama = new TVSerie("futurama","Fry is frozen in time and wakes up 100 years into future in 2100", LocalDate.of(1999,03,28));
        TVSerie theSimpsons = new TVSerie("the simpsons"," a serie about homer simpsons and his family", LocalDate.of(1989,12,17));

        //add few episodes on each TVSerie object
        //episodes in futurama
        futurama.leggTilEpisode(new Episode("Episode 1", 1, 1, 22,"It is actually not year 2100 yet",LocalDate.of(1999,1,12)));
        futurama.leggTilEpisode(new Episode("Episode 2", 2, 1, 25,"I dont know why second episode has such a bad title name",LocalDate.of(2002,5,28)));
        futurama.leggTilEpisode(new Episode("Episode 1", 1, 2, 21,"It took 3 years for third episode to release. Imagine that.",LocalDate.of(2003,12,21)));
        futurama.leggTilEpisode(new Episode("Episode 2", 2, 2, 23,"What a wonderful day",LocalDate.of(2004,8,5)));
        //episodes in the simpons
        theSimpsons.leggTilEpisode(new Episode("Episode 1", 1, 1, 24,"This was bit long time ago",LocalDate.of(1989,12,15)));
        theSimpsons.leggTilEpisode(new Episode("Episode 2", 2, 1, 23,"Improvement with each passing episode",LocalDate.of(1991,10,1)));
        theSimpsons.leggTilEpisode(new Episode("Episode 3", 3, 1, 44,"There is an OL in Lille Hammer",LocalDate.of(1994,6,9)));
        theSimpsons.leggTilEpisode(new Episode("Episode 4", 4, 1, 23,"PlayStation is rather impressive",LocalDate.of(1996,7,25)));
        theSimpsons.leggTilEpisode(new Episode("Episode 5", 5, 1, 23,"It is not long a go",LocalDate.of(2013,4,27)));

        //Rolle for for each TVserie episode list. All futurama episode Fry regissor. All simpons episodes have homer regissor.
        Person fry = new Person("Phlipp","Fry");
        Person homer = new Person("homer","simpson");

        //ArrayList for each TVserie episode to help add regissor easier
        ArrayList<Episode> futuramaEpisodes = futurama.getEpisoder();
        ArrayList<Episode> simpsonsEpisodes = theSimpsons.getEpisoder();

        //add Person to each episode with loop
        for(Episode ep : futuramaEpisodes){
            ep.setRegissor(fry);
        }
        for(Episode ep : simpsonsEpisodes){
            ep.setRegissor(homer);
        }


        //add both TVserie objects to the empty ArrayList
        series.add(futurama);
        series.add(theSimpsons);

    }
    //oppgave 2.5
    //method which gets single TVserie objects
    @Override
    public TVSerie getSingleTVSerie(String tvSerie) {
        //to get desired TVSerie, we can loop through the ArrayList<TVSerie> series
        for(TVSerie serie : series){
            //to get correct Tvserie, we can use if-statement to compare title of TVserie object with the string parameter in this method.
            if(serie.getTitle().equals(tvSerie)){
                //TVserie title which matches user input when the method is used is returned in end.
                return serie;
            }
        }
        //if no matching TVserie title is not found, null is returned.
        return null;
    }
    //oppgave 2.5
    //This method returns a copy ArrayList<TVSerie> series.
    //we have learned to return copy instead of the original ArrayList from previous obligs.
    @Override
    public ArrayList<TVSerie> getAllTVSerie() {
        return new ArrayList<>(series);
    }

    //oppgave 2.7 - get all episodes in a given season
    @Override
    public ArrayList<Episode> getEpisodesInSeason(String tvserie,int season) {
        //first get correct TVSerie using the getSingleTVSerie() method from oppgave 2.5
        TVSerie correctSerie = getSingleTVSerie(tvserie);

        //get episodes in season from the correctSerie
        //hentEpisoderISesong() is a finished method from previous oblig which returns an ArrayList<Episodes> in a given season.
        ArrayList<Episode> episodesInSeason = correctSerie.hentEpisoderISesong(season);

        //finally return the correct TVserie and all it's episodes in correct season.
        return episodesInSeason;
    }

    //implementation of method to get specific episode from specific season nr
    //This is for Vue file epsiode-detail.vue
    @Override
    public Episode getEpisodeInSeason(String tvserie, int season, int episodeNr) {

        //first correct TVSerie
        TVSerie correctSerie = getSingleTVSerie(tvserie);

        //get correct episodes from specific season number of the series
        ArrayList<Episode> correctSeasonEpisodes = correctSerie.hentEpisoderISesong(season);

        //loop through the ArrayList<Episode> to get single specific episode which matches episodeNr from the method parameter
        for(Episode episode : correctSeasonEpisodes){

            //if-statement to get exactly episode which user requests
            if(episode.getEpisodeNr() == episodeNr){
                return episode;
            }

        }

        return null;
    }
}
