package Labs;

public class Fred extends NPC{

    private boolean gaveMoney;
    private int convoNumber;

    public Fred(){
        super("FRED");
        gaveMoney = false;
        convoNumber = 0;
    }

    @Override
    public void talk(){
        switch(convoNumber){
            case 0:
                convo0();
                break;
        }
    }

    public int convo0(){
        say("What do you want, loser?");
        
        return convoNumber;
    }
}
