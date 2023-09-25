public class Room {
    private String navn;
    private String beskrivelse;
    private String nord;
    private String syd;
    private String øst;
    private String vest;

    public Room (String navn, String beskrivelse, String nord, String syd, String øst, String vest){
        this.navn= navn;
        this.beskrivelse =beskrivelse;
        this.nord =nord;
        this.syd=syd;
        this.øst=øst;
        this.vest=vest;
    }
}
