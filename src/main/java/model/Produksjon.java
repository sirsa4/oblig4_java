package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Produksjon {

    //oppgave2.1 - move title and spilleTid from Episode class to abstract Produksjon class
    private String title;
    private double spilletid;

    //oppgave2.2
    private String beskrivelse;
    private LocalDate utgivelsesdato;

    //oppgave2.4 - add regissor instance variable to both Film and Episode classes
    //Adding regissor to this super class which both Film and Episode extend is a good idea
    //Reason is to avoid having to add regissor both classes manually and repeating process. Here we can do it at once.
    private Person regissor;

    //oppgave2.5 - "rolle" Arraylist for which Episode and Film can hold people with different roles in their object instances
    private ArrayList<Rolle> roller = new ArrayList<>();


    //oppgave2.1

    //constructor for this class has only two instance variables in oppgave2.1 so far
    public Produksjon(String title, double spilletid){
        this.title = title;
        this.spilletid = spilletid;
    }

    //oppgave2.3
    //method overall on constructor to make sure previous code in oppgave2.2 does not crash
    public Produksjon(String title, double spilletid,LocalDate utgivelsesdato){
        this.title = title;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
    }

    //oppgave2.3 constructor will 5 needed instance variables so far
    public Produksjon(String title, double spilletid,String beskrivelse,LocalDate utgivelsesdato){
        this.title = title;
        this.spilletid = spilletid;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
    }

    //Empty constructor is needed for the constructor in Episode class which is missing spilletid instance variable
    public Produksjon(){}

    //getter and setter for title and spilletid in oppgave2.1
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public double getSpilletid(){
        return this.spilletid;
    }
    public void setSpilletid(double spilletid){
        this.spilletid = spilletid;
    }

    //oppgave2.3
    //Setter and getter methods for instance variable "utgivelsesdato".
    //setter getter methods for utgivelsesdato is moved from Film class to here.
    public LocalDate getUtgivelsesdato(){
        return this.utgivelsesdato;
    }
    public void setUtgivelsesdato(LocalDate utgivelsesdato){
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getBeskrivelse(){
        return this.beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    //oppgave2.4 setter and getter method for regissor instance variable
    public Person getRegissor(){
        return this.regissor;
    }
    public void setRegissor(Person regissor){
        this.regissor = regissor;
    }

    //oppgave2.5 - getter and setter methods for Episode and Film classes
    //just like in oblig2, getter method for ArrayList returns copy of the original list. The reason for security so that user of this method can't manipulate the content of the original rolle ArrayList
    public ArrayList<Rolle> getRoller(){
        return new ArrayList<>(roller);
    }

    //This method adds only 1 rolle object to roller ArrayList
    public void leggTilEnRolle(Rolle enRolle){
        roller.add(enRolle);
    }

    //This method adds several items to rolle Arraylist at once
    //source for addAll(): https://www.baeldung.com/java-add-items-array-list
    /* code example from baeldung

        List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);
        list.addAll(anotherList);

     */
    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        roller.addAll(flereRoller);
    }

    //oppgave2.6 - toString

    @Override
    public String toString(){
        return  this.title +" har spilletid: "+this.spilletid+ " minutter";
    }


}//end of class
