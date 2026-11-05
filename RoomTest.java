package Labs;

import java.io.Serializable;
import java.util.HashMap;


public class RoomTest implements Serializable{
    private String name;//room name
    private RoomTest directions [];
    private boolean isLocked;
    public static HashMap <String, ItemTest> ItemList = new HashMap<>();
    public static HashMap <String, String> RoomTestMap = new HashMap <>();//key is room name, room desc
    public static HashMap <String, RoomTest> WorldExplored = new HashMap<>();
    
    public RoomTest (String n) {
    name = n;
    directions = new RoomTest[6];//array name = neww object array[index #]
    WorldExplored.put(n,this);
    isLocked = false;
    //index = east, west, north, south, up, down. Null is default
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return RoomTestMap.get(name);
    }

    public RoomTest getExit (int d){
        return directions[d];
    }

    public void addItem(String name, ItemTest i){//i = item
        ItemList.put(name, i);
    }

    public ItemTest getItem (String itemName){
       return ItemList.get(itemName); 
    }

    public boolean hasItem(String name){
        return ItemList.containsKey(name);
    }

    public void removeItem(String name){
        ItemList.remove(name);
    }

    public void addExit(RoomTest destination, int d){//d = direction, destination is room gone to with direction
        directions [d] = destination;//destination = directions [direction from index]
    }

    public boolean checkIsLocked(int doorIndex){
        if (directions[doorIndex] == null){
            return false;
        }
        else
            return isLocked;
    }
    
    public void setIsLocked(int doorIndex, boolean lock){
        isLocked = lock;
    }

    public void setName(String whatName){
        name = whatName;
    }

    public String toString(){
        return name + getDesc();
    }
}