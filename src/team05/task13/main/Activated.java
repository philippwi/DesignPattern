package team05.task13.main;

public class Activated implements ITicketState {

    public void changeState(ITicket ticket, ITicketState state){
        ticket.setState(new Locked());
    }

    @Override
    public String toString(){ return "Activated";}
}