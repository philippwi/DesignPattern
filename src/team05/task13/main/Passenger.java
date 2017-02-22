package team05.task13.main;


public class Passenger {

    ITicket ticket;

    public Passenger(char ticketVersion){
        try {
            if (ticketVersion == 's' || ticketVersion ==  'S') this.ticket = new TicketS();
            else if (ticketVersion == 'm' || ticketVersion ==  'M') this.ticket = new TicketM();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Ticket version specified does not exist");
        }
    }

}