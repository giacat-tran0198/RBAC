package model;

import util.Utils;

public class TripUserMonitor {
    private final User user;
    private final Monitor monitor;
    private int timesWrong;

    public TripUserMonitor(User user, Monitor monitor) {
        this.user = user;
        this.monitor = monitor;
        this.timesWrong = Utils.TIME_WRONG;
    }

    public void resetTimes(){
        this.timesWrong = Utils.TIME_WRONG;
    }

    public boolean checkNoTime(){
        return timesWrong == 0;
    }

    public void descTimeWrong(){
        timesWrong--;
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
