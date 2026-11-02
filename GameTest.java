package Labs;

import java.util.Scanner;
import java.util.stream.Gatherer.Downstream;

import javax.swing.SwingUtilities;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;


public class GameTest{
        //Instance variables
        public static String error = "ERROR";
        public static RoomTest location = WorldTest.buildWorld();
        public static ArrayList <ItemTest> inventory = new ArrayList<ItemTest>();//player inventory list
        private static TextAdventureGUITEST gui;
        //Scanner(s)
        static Scanner input = new Scanner(System.in);
        //Main: runs game
        public static void main(String[] args){
            addRoomDesc();
            gui = new TextAdventureGUITEST();
            gui.createAndShowGUI();
            print("");
        }

        public static void addRoomDesc(){
            File RoomTestDescriptions = new File("RoomTestDesc.txt");
            if (RoomTestDescriptions.exists()){
                try {
                    String name = "";//room name
                    String desc = "";//room desc
                    String line = "";//current line, there to prevent skipping lines
                    Scanner roomReader = new Scanner(RoomTestDescriptions);
                    while (roomReader.hasNextLine()){
                        name = roomReader.nextLine();
                        desc = "";
                        while (!line.equals("#")){
                            desc += line;
                            line = roomReader.nextLine();
                        }
                        RoomTest.RoomTestMap.put(name, desc);
                    }
                    roomReader.close();
                }
                catch(FileNotFoundException exeception){
                    print(error);
                    exeception.printStackTrace();
                }
            }
        }

        public static void saveGame(){
            try {
                File saveFile = new File("save0.sav");
                saveFile.createNewFile();
                ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
                outStream.writeObject(location);
                outStream.writeObject(inventory);
                outStream.writeObject(RoomTest.WorldExplored);
                outStream.close();
            }
            catch(IOException execept){
                print(error);
                execept.printStackTrace();
            }
        }

        public static void loadGame(){
            try {
                File saveFile = new File("save0.sav");
                ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(saveFile));
                location = (RoomTest) inStream.readObject();
                inventory = (ArrayList <ItemTest>) inStream.readObject();
                RoomTest.WorldExplored = (HashMap <String, RoomTest>) inStream.readObject();
                inStream.close();
            }
            catch(Exception exeception){
                print(error);
                exeception.printStackTrace();
            }
        }

        public static void addRoomDialogue(){
            File RoomTestDialogue = new File("RoomTestDialogue.txt");
            if (RoomTestDialogue.exists()){
                try {
                    String name = "";//room name
                    String dialogue = "";//room desc
                    String line = "";//current line, there to prevent skipping lines
                    Scanner roomListener = new Scanner(RoomTestDialogue);
                    while (roomListener.hasNextLine()){
                        name = roomListener.nextLine();
                        line = name;
                        while (!line.equals("#")){
                            line = roomListener.nextLine();
                            dialogue += line;
                        }
                        RoomTest.DialogueMap.put(name, dialogue);
                    }
                    roomListener.close();
                }
                catch(FileNotFoundException exeception){
                    print(error);
                    exeception.printStackTrace();
                }
            }
        }

        public static void print(Object obj){
            gui.updateGameText(obj.toString());
        }

        public static void takeItem(String name){
        if (location.hasItem(name) == true){//Checks if location has item with inputted name
            if (location.getItem(name).isHeavy() == false){
                inventory.add(location.getItem(name));
                print("You take the "+location.getItem(name)+"!");//
                location.removeItem(name);
            }
            else if (location.getItem(name).isHeavy() == true){
                print("You cannot lift the "+location.getItem(name)+"!");
            }
        }
        else {
            print("There is nothing by that name to take!");
        }
        }//end Take Item

        public static RoomTest getLocation(){
            return location;
        }

        public static void move(String d){//d = direction
            int way = -1; //placeholder array int
                switch(d.toUpperCase()){
                    case "EAST":
                        way = 0;
                        break;//Ends case statement at correct case, increases run speed.
                    case "WEST":
                        way = 1;
                        break;
                    case "NORTH":
                        way = 2;
                        break;
                    case "SOUTH":
                        way = 3;
                        break;
                    case "UP":
                        way = 4;
                        break;
                    case "DOWN":
                        way = 5;
                        break;
                    default:
                        print("Please input a valid direction.");
                        return;
                }//End Switch case
                if (location.getExit(way) != null){
                    if (location.getExit(way).checkIsLocked() == true){
                        print("The door is locked!");
                        return;
                    }
                    else {
                        print("You move "+ d.toLowerCase()+".");
                    }
                }
                else {
                    print("You cannot go that way!");
                    return;
                }
                location = location.getExit(way);
                   print("");
                   //gui.updateGameText(location.toString());
        }//end Move method
        
        public static void runGame(String c){
            // String choice = "n/a";
            //location description
            //gui.updateGameText(location.toString());
            String[] fullCommand;
            fullCommand = c
                .toUpperCase()
                .replaceAll("\\b(THE|TO)\\b", " ")
                .split(" ");
            String command = fullCommand[0];
            String itemName;
            // //player input
            // while (!choice.equals("exit")){
            //     gui.updateGameText("Command:");
            //     choice = input.nextLine().toUpperCase();
            //     String [] splitChoice = choice.split(" ");
                //movement check
                switch(command){
                    case "GO", "MOVE":
                        if (fullCommand.length < 2){
                            print("Please input a direction to move.");
                        }
                        else {
                            move(fullCommand[1]);
                        }
                        move(fullCommand [1]);
                        break;
                    case "EAST", "WEST", "NORTH", "SOUTH", "UP", "DOWN":
                        move(command);
                        break;//end movement
                    case "I": //Inventory open
                        print(inventory.toString());
                        break;
                    case "TAKE"://take item
                        if (fullCommand.length < 2){
                            print("Please input an item to take.");
                            break;
                        }
                        itemName = " ";
                        for (int i = 1; i < fullCommand.length; i++){
                            itemName += fullCommand[i] + " ";
                        }
                        takeItem(itemName);
                        break;
                    case "SAVE":
                        saveGame();
                        break;
                    case "LOAD":
                        loadGame();
                        break;
                    case "EXIT":
                        print("Farewell, see you next time!");
                        break;
                    default:
                        print(location.toString());
                        break;
                }//end input
            }//end while
        }//end runGame()
    //end program