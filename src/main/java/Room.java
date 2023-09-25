public class Room {
    private String name;
    private String description;
    private String north;
    private String south;
    private String east;
    private String west;


    public Room (String navn, String beskrivelse, String nord, String syd, String øst, String vest){
        this.navn= navn;
        this.beskrivelse =beskrivelse;
        this.nord =nord;
        this.syd=syd;
        this.øst=øst;
        this.vest=vest;
    }
}
