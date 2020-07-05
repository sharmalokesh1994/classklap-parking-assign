package com.parking.service.parkingCommands;

public class HelpCommandService implements ParkingCommandService {
    @Override
    public void executeCommand(String command) {
        System.out.println("park <reg_no> color");
        System.out.println("leave <slot_no>");
        System.out.println("status");
        System.out.println("registration_numbers_for_cars_with_colour <color>");
        System.out.println("slot_numbers_for_cars_with_colour <color>");
        System.out.println("slot_number_for_registration_number <reg_no>");
        System.out.println("exit");
        System.out.println("help");
    }
}
