package model;

import util.Utils;

public class TripUserMonitor {
    private final User user;
    private final Monitor monitor;
    private int attempt;

    public TripUserMonitor(User user, Monitor monitor) {
        this.user = user;
        this.monitor = monitor;
        this.attempt = Utils.ATTEMPT;
    }

    public void resetTimes(){
        this.attempt = Utils.ATTEMPT;
    }

    public boolean checkNoTime(){
        return attempt == 0;
    }

    public void descTimeWrong(){
        attempt--;
    }

    public User getUser() {
        return user;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public boolean checkUserAccessMonitor(User user, Monitor monitor){
        return this.user.equals(user) && this.monitor.equals(monitor);
    }
}
