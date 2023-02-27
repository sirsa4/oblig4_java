package model;

/*
* samarbeidet med Mostafa Ali Haider
--Resources:
1: class in class,ArrayList: hiof: https://www.youtube.com/watch?v=E2OBcAOG4J0&list=PLEvoVHoL8DxNUskHuf1YnOctQBLnO_F_F&index=9
2: ArrayList: https://www.youtube.com/watch?v=pTAda7qU4LY&t=2s
3: LocalDate: https://www.youtube.com/watch?v=dOvYkzKfsdg
4: toString method: https://www.youtube.com/watch?v=GvbdMwfjB98
 */

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class    Episode extends Produksjon implements Comparable<Episode>{
    //instance variables
    private int episodeNr;
    private int sesongNr;

    //made spilletid a double datatype. Episodes dont end in full numbers always. 2 hours 20min and 45sec for example.


    //contructor with all instance variables
    public Episode(String title,int episodeNr, int sesongNr,double spilletid){
        //oppgave2.1
        //super() makes it possible to use the instance variables in the super class, Produksjon
        //super() must be at top in constructor since the super class is run first in Java. So we get information from super class first so it can be used on this subclass
        super(title,spilletid);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;


    }
    public Episode(int episodeNr, int sesongNr){
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    //Oblig3 - oppgave2.3 method overall to 2 new instance variables to constructor(beskrivelse and utgivelsesdato)
    public Episode(String title, int episodeNr, int sesongNr, double spilletid, String beskrivelse, LocalDate utgivelsesdato){
        //Oblig3 - oppgave2.3
        super(title,spilletid,beskrivelse,utgivelsesdato);
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;


    }


    //toString() is a java inbuilt method in classes that can be overridden. Objects inherit this method from classes. By default, this method shows the memory address/reference of the class or the object depending on where the method called from.
    //toString method returns a string datatype as the name implies
    public String toString(){
        return "Episode number: "+this.episodeNr + " \""+this.getTitle() + "\" is from season "+this.sesongNr+" and lasts for "+this.getSpilletid()+" min.\n";
    }

    //getter and setter methods
    public int getEpisodeNr(){
        return this.episodeNr;
    }
    public void setEpisodeNr(int episodeNr){
        this.episodeNr = episodeNr;
    }
    public int getSesongNr(){
        return this.sesongNr;
    }
    public void setSesongNr(int sesongNr){
        this.sesongNr = sesongNr;
    }

    @Override
    public int compareTo(Episode ep) {
        return (int) (this.getSpilletid() - ep.getSpilletid());
    }
}
