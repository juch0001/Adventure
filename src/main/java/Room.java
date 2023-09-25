public class Room {
    private String name;
    private String description;
    private String north;
    private String south;
    private String east;
    private String west;


    public Room (String name, String description, String north, String south, String east, String west){
        this.name= name;
        this.description =description;
        this.north =north;
        this.south=south;
        this.east=east;
        this.west=west;
    }
}
