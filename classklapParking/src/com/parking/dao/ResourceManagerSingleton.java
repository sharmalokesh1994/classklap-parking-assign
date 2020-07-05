package com.parking.dao;

import com.parking.entity.Car;
import com.parking.entity.ParkingSlot;
import com.parking.entity.Ticket;

import java.util.HashMap;

public class ResourceManagerSingleton {

    private static volatile ResourceManagerSingleton instance;
    private HashMap<Integer, ParkingSlot> parkingSlots;
    private HashMap<String, Car> cars;
    private HashMap<Integer, Ticket> tickets;
    private HashMap<Integer, Integer> parkingSlotTicket;
    private HashMap<String, Integer> carTicket;

    private ResourceManagerSingleton(){
        parkingSlots = new HashMap<>();
        cars = new HashMap<>();
        tickets = new HashMap<>();
        parkingSlotTicket = new HashMap<>();
        carTicket = new HashMap<>();
    }

    public void addParkingSlot(){
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlots.put(parkingSlot.getId(),parkingSlot);
    }

    public void parkVehicle(String regNo, String color){

        int n = parkingSlots.size();
        int availPark = n+1;
        for(int i=1;i<=n;i++){
            if( parkingSlots.get(i).getStatus().equals("empty") ){
                availPark = i;

                break;
            }
        }

        if(availPark == n+1){
            System.out.println("Sorry, parking lot is full");
        }else{

            System.out.println("Allocated slot number: "+availPark);
            Car car = new Car(regNo,color);
            cars.put(regNo,car);
            Ticket ticket = new Ticket(car,parkingSlots.get(availPark));
            parkingSlots.get(availPark).setStatus("full");
            tickets.put(ticket.getId(),ticket);
            parkingSlotTicket.put(availPark,ticket.getId());
            carTicket.put(regNo,ticket.getId());

        }

    }

    public void unParkVehicle(int id){
        // if id is not Valid
        if(id<0 && id>parkingSlots.size()){
            // throw custom Exception
            System.out.println("Give Valid id");
            return;
        }

        ParkingSlot parkingSlot = parkingSlots.get(id);
        if(parkingSlot.getStatus().toLowerCase().equals("empty")){
            // throw custom Exception
            System.out.println(id+" : is already empty");
            return;
        }
        Ticket ticket = tickets.get(parkingSlotTicket.get(id));
        Car car = ticket.getCar();
        ticket.setStatus("invalid");
        parkingSlot.setStatus("empty");
        cars.remove(car.getRegNumber());
        parkingSlotTicket.remove(id);
        carTicket.remove(car.getRegNumber());
        System.out.println("Slot number "+ parkingSlot.getId() +" is free");

    }

    public void getStatus(){

        int n = parkingSlots.size();
        System.out.printf("%-20s%-20s%-20s","Slot No.","Registration No","Color");
        System.out.println();
        for(int i=1;i<=n;i++){
            if( parkingSlots.get(i).getStatus().equals("full") ){
                System.out.printf("%-20s%-20s%-20s",i+"",tickets.get(parkingSlotTicket.get(i)).getCar().getRegNumber(),
                                                            tickets.get(parkingSlotTicket.get(i)).getCar().getColor());
                System.out.println();
            }
        }

    }

    public void getCarsWithColor(String color){
        for( String regNo : cars.keySet() ){
            if( cars.get(regNo).getColor().trim().toLowerCase().equals(color.trim().toLowerCase()) ){
                System.out.println(regNo);
            }
        }
    }

    public void getSlotsWithColor(String color){
        int n = parkingSlots.size();
        for(int i=1;i<=n;i++){
            if( parkingSlots.get(i).getStatus().trim().equals("full")
                    && tickets.get(parkingSlotTicket.get(i)).getCar().getColor().trim().toLowerCase().equals(color.trim().toLowerCase()) ){
                System.out.println(i);
            }
        }
    }

    public void getSlotWithRegNo(String regNo){
        if(cars.containsKey(regNo)){
            System.out.println(tickets.get(carTicket.get(regNo)).getParkingSlot().getId());
        }else {
            System.out.println("Not found");
        }
    }

    public static ResourceManagerSingleton getInstance(){
        if(instance==null){
            synchronized (ResourceManagerSingleton.class){
                if(instance==null){
                    instance = new ResourceManagerSingleton();
                }
            }
        }
        return instance;
    }

}
