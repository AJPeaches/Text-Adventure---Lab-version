package Labs;

public class Bobo extends NPC{

    private int convoNumber;

    public Bobo (){
        super("BOBO");
        convoNumber = 0;
    }

    @Override 
    public void talk(){
        switch (convoNumber){
            case 0:
                convo0();
                break;
            case 1:
                convo1();
                break;
            case 2:
                convo2();
                break;
            case 3:
                convo3();
                break;
            case 4:
                convo4();
                break;
            case 5:
                convo5();
        }
    }

        public int convo0(){
        say("Hello! How may I help you today?");
        String[] responses = {
        "Got any gum?", 
        "You can't help me. I'm here to help you.", 
        "Can I have 50 cents?"
        };
        int option = getResponse(responses);
        switch(option) {
            case 1:
                say("All we have left is pineapple-flavored gum. Oh, wait. Never mind. I'm chewing the last piece.");
                convoNumber = 1;//gum line
                break;
            case 2:
                say("Ooh! Nobody's ever helped me before. Thanks!");
                convoNumber = 2;//help line
                break;
            case 3:
                say("No.");
                convoNumber = 3;//starting minus 50 cents
                break;
            default:
                say("Uhhh…what?");
        }
        return convoNumber;
    }

    public int convo1(){//gum line
        say ("Sorry I ate the last of the gum. I didn't know anyone on the plant ate gum. I mean house.");
        String[] responses = {
            "It's okay, I forgive you.",
            "You're from another planet?",
            "You monster!"
        };
        int option = getResponse(responses);
        switch(option) {
            case 1:
                say("You are... So kind!!!");
                convoNumber = 4;//starting convo minus gum line
                break;
            case 2:
                say("I am from a house called SR-388. It is a house full of humans and NOT Gleepglups.");
                convoNumber = 5;//alien line
                break;
            case 3:
                say("AHHHH!!!!!!");
                convoNumber = 4;
        }
        return convoNumber;
    }

    public int convo2(){//help line
        say("Ooh! Nobody's ever helped me before. Thanks!");
        String[] responses = {
            "I'm going to teach you Spanish: Me llamo Bobo.", 
            "I'm giving you a new name: Peaches.",
            "No. I was kidding before. You're beyond help."
        };
        return convoNumber;
    }
}
