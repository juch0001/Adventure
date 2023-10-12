import java.util.ArrayList;

public class Item {
    private String itemName;
    private String itemDescription;

    public Item (String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    //TODO GET og SET
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription(){
        return itemDescription;
    }
}
