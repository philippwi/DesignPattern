package team05.task13.main;

public class Locked implements ITicketState {

    public void changeState(ITicket ticket, ITicketState state){
        ticket.setState(state);
    }

    @Override
    public String toString(){ return "Locked";}
}