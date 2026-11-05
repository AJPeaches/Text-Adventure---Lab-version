package Labs;

public class Tool extends ItemTest{
    private boolean usedTool;
    
    public Tool(){
        super("TOOL", false);
    }

    @Override
    public void useItem(){
        if (GameTest.location.getName().equals("Bedroom")){ 
            if (GameTest.location.checkIsLocked(4) == true){
                if (usedTool == true) {
                GameTest.print("You already brought down the ladder!");
                }
                else {
                GameTest.print("You used the tool to open the attic door, and the ladder drops down.");
                GameTest.location.setIsLocked(5, false);
                usedTool = true;
                }
            }
            else
                GameTest.print("Something went wrong :(");
        }
        else{
            GameTest.print("You try to find a place to use the tool... Unfortunately, you find nothing useful out of reach.");
        }
    }
    
}
