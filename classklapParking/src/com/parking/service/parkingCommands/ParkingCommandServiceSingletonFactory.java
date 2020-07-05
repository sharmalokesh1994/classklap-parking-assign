package com.parking.service.parkingCommands;

import com.parking.customException.NotFoundException;

import java.util.HashMap;

public class ParkingCommandServiceSingletonFactory {

    private static volatile ParkingCommandServiceSingletonFactory instance;

    HashMap<String, ParkingCommandService> parkingCommandHashMap;

    private ParkingCommandServiceSingletonFactory(){
        parkingCommandHashMap = new HashMap<>();
        parkingCommandHashMap.put("park",new ParkCommandService());
        parkingCommandHashMap.put("leave",new LeaveCommandService());
        parkingCommandHashMap.put("status",new StatusCommandService());
        parkingCommandHashMap.put("registration_numbers_for_cars_with_colour",new CarsWithColorCommandService());
        parkingCommandHashMap.put("slot_numbers_for_cars_with_colour",new SlotWithColorCommandService());
        parkingCommandHashMap.put("slot_number_for_registration_number",new SlotWithRegNumberCommandService());
        parkingCommandHashMap.put("help",new HelpCommandService());
    }

    public ParkingCommandService getParkingCommand(String command) throws NotFoundException{
        String str = command.trim().split(" ")[0];
        if(!parkingCommandHashMap.containsKey(str)){
            throw new NotFoundException("Please give valid command");
        }
        return parkingCommandHashMap.get(str);
    }

    public static ParkingCommandServiceSingletonFactory getInstance(){
        if(instance==null){
            synchronized (ParkingCommandServiceSingletonFactory.class){
                if(instance==null){
                    instance = new ParkingCommandServiceSingletonFactory();
                }
            }
        }
        return instance;
    }

}
