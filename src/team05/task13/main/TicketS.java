package team05.task13.main;

public class TicketS implements ITicket{

    int credits = 10;

    int pins = 2;

    ITicketState state = new Activated();

    public void bookRide(){
        this.credits -= 2;
    }

    public void loadCredits(int credits){
        this.credits += credits;
    }

    public void setState(ITicketState state){
        this.state = state;
    }


}