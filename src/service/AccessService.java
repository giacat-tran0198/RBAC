package service;

import model.*;
import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class AccessService implements AccessServiceInterface{

    private final List<TripUserMonitor> tripUserMonitorList = new ArrayList<>();

    @Override
    public String accessResource(User user, Monitor monitor, Action action, Resource resource) {
        // check
        TripUserMonitor tmpTripUserMonitor = tripUserMonitorList
                .stream()
                .filter(tripUserMonitor -> tripUserMonitor.checkUserAccessMonitor(user, monitor))
                .findFirst()
                .orElse(null);

        if (tmpTripUserMonitor == null){
            tmpTripUserMonitor = new TripUserMonitor(user, monitor);
            tripUserMonitorList.add(tmpTripUserMonitor);
        }

        if (monitor.canAccess(user, action, resource)){
            return Utils.ACCESS_GRANTED;
        }

        if (tmpTripUserMonitor.checkNoTime()){

            tmpTripUserMonitor.getUser().setBlocked(true);
            monitor.getRoleList().forEach(Role::update);

            return Utils.USER_BLOCKED;
        }

        tmpTripUserMonitor.descTimeWrong();

        return Utils.ACCESS_DENIED;
    }
}
