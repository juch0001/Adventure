import javax.sound.midi.Soundbank;

public class Adventure {
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)


    private Map map = new Map();
    private Player player;

    public Adventure(){
        player = new Player();
    }

    public void buildMap() {
        map.buildMap();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
}