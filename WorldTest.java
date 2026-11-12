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
        LivingRoom.addExit(Bedroom, 2);//2 = north
        LivingRoom.addExit(Office, 3);//3 = south
        LivingRoom.addExit(Kitchen, 1);//1 = west
        LivingRoom.addItem("TOOL", new Tool());
        //Office
        Office.addExit(LivingRoom, 2);//north
        Office.setIsLocked(true);
        //Kitchen
        Kitchen.addExit(LivingRoom, 0);//0 = east
        Kitchen.addExit(Garage, 1);// west
        //Bedroom
        Bedroom.addExit(Attic, 4);//4 = up
        Bedroom.addExit(LivingRoom, 3);
        Bedroom.addItem("OFFICEKEY", new OfficeKey());
        //Garage
        Garage.addExit(Kitchen, 0);
        Garage.setIsLocked(true);
        //Attic
        Attic.addExit(Bedroom, 5);//5 = down
        Attic.setIsLocked(true);
        Attic.addItem("SAFE", new Safe());
        
        
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
