package client;

import com.parking.customException.NotFoundException;
import com.parking.service.InitializeParkingSlotService;
import com.parking.service.parkingCommands.ParkingCommandService;
import com.parking.service.parkingCommands.ParkingCommandServiceSingletonFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

    private static ParkingCommandServiceSingletonFactory parkingCommandSingletonFactory = ParkingCommandServiceSingletonFactory.getInstance();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Welcome...");
            System.out.println("Create the Parking (give the Parking slot number)");

            int slot_no = Integer.parseInt(br.readLine().trim());
            InitializeParkingSlotService.initializeParking(slot_no);

            ParkingCommandService parkingCommand;
            while (true){

                try{
                    String input = br.readLine().trim();
                    if(input.toLowerCase().equals("exit")){
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    parkingCommand = parkingCommandSingletonFactory.getParkingCommand(input);
                    parkingCommand.executeCommand(input);
                }catch (NotFoundException ex){
                    System.out.println(ex.getMessage());
                }catch (Exception ex){
                    System.out.println("Please give valid command");
                }

            }

        }
        catch (Exception ex){
            System.out.println("Please give valid number");
            System.out.println("Exiting");
            System.exit(0);
        }

    }

}

