package team05.task13.main;

import java.util.ArrayList;
import java.util.Random;

public class Application {

    public static Passenger getRandomPassenger(ArrayList<Passenger> passengers) {
        int index = (new Random()).nextInt(passengers.size());
        return passengers.get(index);
    }

    public static void setRandomState(ArrayList<Passenger> passengers){
        ArrayList<ITicketState> states = new ArrayList<>();
        states.add(new Activated());
        states.add(new Deactivated());
        states.add(new Locked());
        Passenger p = getRandomPassenger(passengers);
        ITicket t = p.ticket;
        int index = new Random().nextInt(states.size());
        t.getState().changeState(t, states.get(index));
    }

    public static void main(String... args) throws InterruptedException {

        //initialisierung
        TicketM ticketM = new TicketM();
        TicketS ticketS = new TicketS();
        TicketAdapter adapter = new TicketAdapter();

        ITicketState activated = new Activated();
        ITicketState deactivated = new Deactivated();
        ITicketState locked = new Locked();

        Security security = new Security();

        IReadingDeviceListener controlCenter = new ControlCenter();

        ReadingDevice readingDevice = new ReadingDevice();
        readingDevice.addListener(controlCenter);

        Passenger passengerS1 = new Passenger('S'); Passenger passengerS2 = new Passenger('S');
        Passenger passengerS3 = new Passenger('S'); Passenger passengerS4 = new Passenger('S');
        Passenger passengerS5 = new Passenger('S'); Passenger passengerS6 = new Passenger('S');
        Passenger passengerM1 = new Passenger('M'); Passenger passengerM2 = new Passenger('M');
        Passenger passengerM3 = new Passenger('M'); Passenger passengerM4 = new Passenger('M');

        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerS1); passengers.add(passengerS2); passengers.add(passengerS3);
        passengers.add(passengerS4); passengers.add(passengerS5); passengers.add(passengerS6);
        passengers.add(passengerM1); passengers.add(passengerM2); passengers.add(passengerM3);
        passengers.add(passengerM4);



        //ausführung
            while (!passengers.isEmpty()) {
                getRandomPassenger(passengers).ticket.bookRide();   //lässt zufälligen passenger eine fahrt buchen
                if (new Random().nextInt(10) == 1)
                    setRandomState(passengers);   //ändert ticket state eines zufälligen passengers mit wahrscheinlichkeit 0.1
                Thread.sleep(1000); //1 sekunde pause
                if (getRandomPassenger(passengers).ticket.getState().toString() == "Deactivated") {
                    readingDevice.detectViolation(controlCenter, passengers, getRandomPassenger(passengers));
                }
            }
            System.out.println("All passengers arrested");
        }
    }
