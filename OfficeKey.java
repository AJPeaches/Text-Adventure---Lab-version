package Labs;

public class OfficeKey extends ItemTest{


    public OfficeKey(){
        super("OFFICEKEY", false);
    }

    @Override 
    public void useItem(){
        if (GameTest.location.getName().equals("Living Room")){
            if (GameTest.location.getExit(2).checkIsLocked() == true){
                GameTest.print("You used the office key to unlock the office!");
                GameTest.location.setIsLocked(false);
            }
            else {
                GameTest.print("You already unlocked the office!");
            }
        }
        else{
            GameTest.print("You check every keyhole you find. Unforturnately, no dice.");
        }
    }

}
