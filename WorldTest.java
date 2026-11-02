package Labs;

public class WorldTest {

    public static RoomTest buildWorld() {
        RoomTest LivingRoom = new RoomTest ("Living Room");
        RoomTest Office = new RoomTest ("Office");
        RoomTest Bedroom = new RoomTest ("Bedroom");
        RoomTest Kitchen = new RoomTest ("Kitchen");
        RoomTest Garage = new RoomTest ("Garage");
        RoomTest Attic = new RoomTest ("Attic");
        //LivingRoom
        LivingRoom.addExit(Bedroom, 3);//3 = south
        LivingRoom.addExit(Office, 2);//2 = north
        LivingRoom.addExit(Kitchen, 1);//1 = west
        LivingRoom.addItem("Tool", new ItemTest("Tool", false));
        //Office
        Office.addExit(LivingRoom, 3);
        Office.setIsLocked(true);
        //Kitchen
        Kitchen.addExit(LivingRoom, 0);//0 = east
        Kitchen.addExit(Garage, 1);
        //Bedroom
        Bedroom.addExit(Attic, 4);//4 = up
        Bedroom.addExit(LivingRoom, 2);
        Bedroom.addItem("OfficeKey", new ItemTest("OfficeKey", false));
        Bedroom.setIsLocked(true);
        //Garage
        Garage.addExit(Kitchen, 0);
        //Attic
        Attic.addExit(Bedroom, 5);//5 = down
        
        
        return LivingRoom;//Sets LivingRoom as "currentRoom" for main
    }
    // public static void main(String[] args){
    //     RoomTest currentRoom;
    //     currentRoom = buildWorld();
    //     System.out.println(currentRoom); // living room
    //     currentRoom = currentRoom.getExit(0); // 0=east
    //     System.out.println(currentRoom); // kitchen
    //     currentRoom = currentRoom.getExit(3); // 3=south
    //     System.out.println(currentRoom); // garage
    //     currentRoom = currentRoom.getExit(2); // 2=north
    //     System.out.println(currentRoom); // kitchen again
    //     currentRoom = currentRoom.getExit(1); // 1=west
    //     System.out.println(currentRoom); // living room again
    //     currentRoom = currentRoom.getExit(2); // 2=north
    //     System.out.println(currentRoom); // bedroom
    //     currentRoom = currentRoom.getExit(4); // 4=up
    //     System.out.println(currentRoom); // attic
    // }
}
