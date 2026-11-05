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
    
    public void useItem(){
        GameTest.print("You cannot use that item here!");
    }

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