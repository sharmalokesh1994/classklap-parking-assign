package com.parking.service;

import com.parking.dao.ResourceManagerSingleton;

public class InitializeParkingSlotService {

    private static ResourceManagerSingleton resourceManagerSingleton = ResourceManagerSingleton.getInstance();
    public static void initializeParking(int number){
        for(int i=0;i<number;i++){
            resourceManagerSingleton.addParkingSlot();
        }

        System.out.println("Created a parking lot with "+ number +" slots");
    }

}
