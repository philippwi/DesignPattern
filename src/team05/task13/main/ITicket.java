package team05.task13.main;

public interface ITicket {

    int credits;

    int pins;

    ITicketState state;

    void bookRide();

    void loadCredits(int credits);

    void setState(ITicketState state);


}