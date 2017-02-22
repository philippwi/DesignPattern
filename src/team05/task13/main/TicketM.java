package team05.task13.main;

public class TicketM implements ITicket{

    int credits = 10;

    int pins = 3;

    ITicketState state = new Activated();

    public void bookRide() {
        System.out.println("3 pin ticket not compatible to reader. Use adapter!");
    }

    public void bookRide3Pin(){
        this.credits -= 2;
    }

    public void loadCredits(int credits){
        this.credits += credits;
    }

    public void setState(ITicketState state){
        this.state = state;
    }


}