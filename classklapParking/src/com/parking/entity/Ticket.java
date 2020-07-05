package com.parking.entity;

public class Ticket {
	
	private int id;
    private static int UID = 1;

    private Car car;
    private ParkingSlot parkingSlot;
    private String status;

    public Ticket(Car car, ParkingSlot parkingSlot) {
        this.car = car;
        this.parkingSlot = parkingSlot;
        status = "valid";
        setId();
    }

    private void setId() {
        this.id = UID;
        UID++;
    }
    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
