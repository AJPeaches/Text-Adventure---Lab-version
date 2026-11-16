package Labs;

public class Notebook extends ItemTest{
    
    private boolean readNotebook;//Has read the notebook, used to prevent making multiple password objects.

    public Notebook(){
        super("NOTEBOOK", false);
        readNotebook = false;
    }

    @Override 
    public void read(){
        if (readNotebook == false)
            if (GameTest.findInventoryItem("NOTEBOOK") != null){
                    GameTest.print("You open the notebook. On its pages is a password, to what you are unsure. You commit it to memory regardless.");
                    GameTest.addToInventory(new ItemTest("PASSWORD", false));
                    readNotebook = true;
            }
            else {
                GameTest.print("What notebook do you have to read? Unlike playing paper mario in your mind, you cannot read a notebook you've never read before. That's what they call 'Thinking'.");
            }
        else if (readNotebook == true){
            GameTest.print("You page through the notebook, but find nothing else of note.");
        }
    }

}
