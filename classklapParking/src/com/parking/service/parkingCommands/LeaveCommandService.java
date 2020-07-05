package com.parking.service.parkingCommands;

import com.parking.dao.ResourceManagerSingleton;

public class LeaveCommandService implements ParkingCommandService {

    private ResourceManagerSingleton resourceManagerSingleton = ResourceManagerSingleton.getInstance();
    @Override
    public void executeCommand(String command) {
        String str[] = command.trim().split(" ");
        int slot_no = Integer.parseInt(str[1].trim());
        resourceManagerSingleton.unParkVehicle(slot_no);
    }
}
