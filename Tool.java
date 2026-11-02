package Labs;

public class Tool extends ItemTest{
    private boolean usedTool;
    
    public Tool(String n){
        super(n, false);
    }

    @Override
    public void useItem(){
        if (GameTest.location.getName().equals("Bedroom"))
        GameTest.print("You used the tool!");
    }
    
}
