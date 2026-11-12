package Labs;

import java.io.Serializable;

public class ItemTest implements Serializable{
    //variables
    private String itemName;
    private boolean isHeavy = true;
    //constructor 
    public ItemTest(String n, boolean weight){
        itemName = n;
        isHeavy = weight;
    }

    public String getItemName(){
        return itemName;
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