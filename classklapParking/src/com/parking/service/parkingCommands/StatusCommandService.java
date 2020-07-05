package com.parking.service.parkingCommands;

import com.parking.dao.ResourceManagerSingleton;

public class StatusCommandService implements ParkingCommandService {

    private ResourceManagerSingleton resourceManagerSingleton = ResourceManagerSingleton.getInstance();
    @Override
    public void executeCommand(String command) {
        resourceManagerSingleton.getStatus();
    }
}
