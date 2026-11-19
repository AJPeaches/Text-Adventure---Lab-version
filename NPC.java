package Labs;

import javax.swing.JOptionPane;

public class NPC {
    
    private String npcName;

    public NPC(String n){
        npcName = n;
    }

    public String getNPCName(){
        return npcName;
    }

    public void setNPCName(String n){
        npcName = n;
    }

    public void say(String dialogue){
        String say = npcName.toUpperCase() + "\n" + dialogue;
        GameTest.print(say);
    }

    public void talk(){//player command
        GameTest.print("You cannot talk to " + npcName);
    }

    public int getResponse(String[] response){
        String responseList = "";
        for (int i = 0; i < response.length; i++){
            responseList += response[i] + "\n";
        }
        String input = JOptionPane.showInputDialog(null, "Choose your response:\n" + responseList);
        return Integer.parseInt(input);
    }

}
