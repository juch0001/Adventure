import java.util.ArrayList;

public class Item {
    private static String itemName;
    private static String itemDescription;

    public Item (String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }



    //TODO get og set for ItemName
    public static String getItemName() {
     return itemName;
    }
    //TODO get
    // og set for ItemDescription
    public static String getItemDescription(){
        return itemDescription;
    }

}

