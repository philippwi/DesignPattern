package team05.task13.main;

public class TicketS implements ITicket{

    int credits = 10;

    int pins = 2;

    public ITicketState state = new Activated();

    public void bookRide() {
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