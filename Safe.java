package Labs;

public class Safe extends ItemTest{

    private boolean safeOpen;

    public Safe(){
        super("SAFE", true);//Heavy, cannot be picked up
        safeOpen = false;
    }

    @Override 
    public void open(){
        if (GameTest.location.getName().equals("Attic")){
            if (safeOpen == false){
                GameTest.print("Using the combintation, you open the safe. Inside is a notebook!");
                GameTest.location.addItem("NOTEBOOK", new Notebook());
                safeOpen = true;
            }
        }
    }


    @Override 
    public void close(){
        GameTest.print("You shut the safe and it locks without your input. Dangit.");
        safeOpen = false;
    }

}
