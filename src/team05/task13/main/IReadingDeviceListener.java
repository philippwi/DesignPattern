package team05.task13.main;

import java.util.ArrayList;

public interface IReadingDeviceListener {

    void reportViolation(ArrayList<Passenger> ps, Passenger p);

}