import java.util.ArrayList;

public class Item {
    private String itemName;
    private String itemDescription;

    public Item (String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    //TODO get og set for ItemName
    public String getItemName() {
        return itemName;
    }
    //TODO get
    // og set for ItemDescription
    public String getItemDescription(){
        return itemDescription;
    }
}
