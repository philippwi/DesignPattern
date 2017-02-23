package team05.task13.main;

import java.util.ArrayList;

public class ControlCenter implements IReadingDeviceListener{

    public void reportViolation(ArrayList<Passenger> ps, Passenger p){
        notifySecurity(ps, p);
    }

    public void notifySecurity(ArrayList<Passenger> ps, Passenger p){
        new Security().arrestPassenger(ps, p);
    }

}