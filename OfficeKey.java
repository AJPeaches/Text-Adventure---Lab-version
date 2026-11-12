package Labs;

public class OfficeKey extends ItemTest{
    
    private boolean usedOfficeKey;
    
    public OfficeKey(){
        super("OFFICEKEY", false);
        usedOfficeKey = false;
    }

    @Override 
    public void useItem(){
        if (GameTest.location.getName().equals("Living Room")){
            if (GameTest.location.getExit(3).checkIsLocked() == true){
                if (usedOfficeKey == true)
                    GameTest.print("You already unlocked the office!");
                else{
                    GameTest.print("You used the office key to unlock the office!");
                    GameTest.location.getExit(3).setIsLocked(false);
                    usedOfficeKey = true;
                }
            }
            else {
                
            }
        }
        else{
            GameTest.print("You check every keyhole you find. Unforturnately, no dice.");
        }
    }

}
