package team05.task13.main;

public class TicketM implements ITicket{

    int credits = 10;

    int pins = 3;

    public ITicketState state = new Activated();

    public void bookRide() {
        System.out.println("3 pin ticket not compatible to reader. Use adapter!");
    }

    public void bookRide3Pin(){
        if(state.toString()=="Deactivated"){
            System.out.println("Ticket is deactivated - ride not possible");
            return;
        }
        if(this.credits<2 && state.toString()=="Activated") loadCredits(10);   //credits aufladen wenn nicht ausreichend für fahrt
        if(this.credits<2 && state.toString()=="Locked"){
            System.out.println("Not enough credits to book ride");
            return;
        }
        this.credits -= 2;
        System.out.println("Ride booked");
    }

    public void loadCredits(int credits){
        if(state.toString()=="Activated"){
            this.credits += credits;
            System.out.println(credits + " credits added");
        }
        else System.out.println("Adding credits failed");
    }

    public void setState(ITicketState state){
        this.state = state;
        System.out.println("State changed to " + state);
    }

    public ITicketState getState(){return state;}

}