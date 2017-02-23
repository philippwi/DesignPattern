package team05.task13.main;

import java.util.ArrayList;

public class ReadingDevice {

    private ArrayList<IReadingDeviceListener> listeners;

    public int pins;

    public ReadingDevice(){
        this.listeners = new ArrayList<>();
        this.pins = 2;
    }

    public void addListener(IReadingDeviceListener l){
        listeners.add(l);
    }

    public void removeListener(IReadingDeviceListener l){
        listeners.remove(l);
    }

    public  void detectViolation(IReadingDeviceListener c, ArrayList<Passenger> ps, Passenger p){
        c.reportViolation(ps, p);
    }

}