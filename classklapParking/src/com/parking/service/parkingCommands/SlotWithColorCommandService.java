package com.parking.service.parkingCommands;

import com.parking.dao.ResourceManagerSingleton;

public class SlotWithColorCommandService implements ParkingCommandService {
    private ResourceManagerSingleton resourceManagerSingleton = ResourceManagerSingleton.getInstance();
    @Override
    public void executeCommand(String command) {
        String str[] = command.trim().split(" ");
        String color = str[1].trim();
        resourceManagerSingleton.getSlotsWithColor(color);
    }
}
