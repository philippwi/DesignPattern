package team05.task13.main;

public interface ITicket {

    void bookRide();

    void loadCredits(int credits);

    void setState(ITicketState state);

    ITicketState getState();

}