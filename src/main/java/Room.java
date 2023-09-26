public class Room {
    //Todo objekt og variabler
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;



    public Room (String name, String description){
        this.name = name;
        this.description =description;

    }
    //Todo get og set for navn
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    //Todo get og set for beskrivelse
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }


    //Todo get og set for nord
    public Room getNorth() {
        return north;
    }
    public void setNorth(Room north){
        this.north=north;
    }


    //Todo get og set for syd
    public Room getSouth() {
        return south;
    }
    public void setSouth(Room south){
        this.south=south;
    }


    //Todo get og set for øst
    public Room getEast() {
        return east;
    }
    public void setEast(Room east){
        this.east=east;
    }



    //Todo get og set for vest
    public Room getWest() {
        return west;
    }
    public void setWest(Room west){
        this.west=west;
    }
}
