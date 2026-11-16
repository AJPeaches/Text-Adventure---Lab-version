package Labs;

import java.io.Serializable;
import java.util.HashMap;

public class ItemTest implements Serializable{
    //variables
    private String itemName;
    private boolean isHeavy = true;
    public static HashMap <String, ItemTest> ItemList = new HashMap<>();
    //constructor 
    public ItemTest(String n, boolean weight){
        itemName = n;
        isHeavy = weight;
        ItemList.put(n, this);
    }

    public String getItemName(){
        return itemName;
    }

    public static ItemTest getItem(String name){
        return ItemList.get(name);
    }

    public void setItemName(String whatName){
        itemName = whatName;
    }
    //Class Methods to override
    public void useItem(){
        GameTest.print("You cannot use that item here!");
    }

    public void open(){
        GameTest.print("You can't open that!");
    }

    public void close(){
        GameTest.print("You can't close that!");
    }

    public void read(){
        GameTest.print("There is nothing to read!");
    }
    //Can be or cannot be picked up by weight
    public boolean isHeavy(){
        return isHeavy;
    }

    public void setWeight(boolean weight){
        isHeavy = weight;
    }
    
    public String toString(){
        return itemName;
    }



}