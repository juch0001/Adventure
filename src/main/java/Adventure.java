import javax.sound.midi.Soundbank;

public class Adventure {

    private Map map = new Map();
    private Player player;

    public Adventure(){
        player = new Player(map.getCurrentRoom());
    }

    public void buildMap() {
        map.buildMap();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void directions(String menu) {
        player.directions(menu);
    }


}