package Labs;

public class BlorboBleebus extends NPC {
    public BlorboBleebus(){
        super("BLORBOBLEEBUS");
    }

    @Override 
    public void talk(){
        say("I AM BLORBO BLEEBUS OF PLANET SR-388, I HAVE COME FAR TO PASS ONTO THIS MESSAGE!!!");
        String [] responses = {
            "1. What is your message, Blorbo Bleebus?",
            "2. What's it like on SR-388? I hear the weather is good this time of year.",
            "3. Sorry, I don't speak alien. Good day to you, Sir."
        };
        int option = getResponse(responses);
        switch (option){
            case 1:
                say("THANK YOU. I COME IN SEARCH OF MY TRAITOROUS BROTHER, BOBO. I HAVE PICKED UP READINGS THAT HE HIDES HERE ON YOUR PLANET: DIRT.");
                break;
            case 2:
                say("THE WEATHER IS VERY NICE FOR US GLEEPGLUPS. I HAVE GATHERED, HOWEVER, THAT RAIN SO ACIDIC IS NOT GOOD FOR HUMANS.");
                break;
            case 3:
                say("THAT IS UNFORTUNATE, AS MY MESSAGE IS OF GREAT IMPORTANCE. PLEASE COME BACK ONCE YOU CAN SPEAK ALIEN.");
                break;
            default:
                say("I AM SORRY, MY DIRT-SPEAK TRANSLATOR IS IMPERFECT. I DO NOT UDNERSTAND YOUR WORDS.");
        }   
    }
}
