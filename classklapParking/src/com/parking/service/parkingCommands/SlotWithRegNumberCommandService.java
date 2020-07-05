package com.parking.service.parkingCommands;

import com.parking.dao.ResourceManagerSingleton;

public class SlotWithRegNumberCommandService implements ParkingCommandService {

    private ResourceManagerSingleton resourceManagerSingleton = ResourceManagerSingleton.getInstance();

    @Override
    public void executeCommand(String command) {
        String str[] = command.trim().split(" ");
        String regNo = str[1].trim();
        resourceManagerSingleton.getSlotWithRegNo(regNo);
    }

}