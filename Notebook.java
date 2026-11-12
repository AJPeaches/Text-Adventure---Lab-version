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
            for (int i = 0; i < GameTest.inventory.size(); i++){
                if (GameTest.getInventory().contains("NOTEBOOK")){
                        GameTest.print("You open the notebook. On its pages is a password, to what you are unsure. You commit it to memory regardless.");
                        GameTest.addToInventory(new ItemTest("PASSWORD", false));
                        readNotebook = true;
                        break;
                    }
        }
        else if (readNotebook == true){
            GameTest.print("You page through the notebook, but find nothing else of note.");
        }
    }

}
