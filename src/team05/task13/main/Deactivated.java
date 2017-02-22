package team05.task13.main;

public class Deactivated implements ITicketState {

    public void changeState(ITicket ticket, ITicketState state){
        ticket.setState(new Locked());
    }

    @Override
    public String toString(){ return "Deactivated";}
}