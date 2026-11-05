package Labs;

public class OfficeKey extends ItemTest{


    public OfficeKey(){
        super("OFFICEKEY", false);
    }

    @Override 
    public void useItem(){
        if (GameTest.location.getName().equals("Living Room")){
            if (GameTest.location.checkIsLocked(3) == true){
                GameTest.print("You used the office key to unlock the office!");
                GameTest.location.setIsLocked(2, false);
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
