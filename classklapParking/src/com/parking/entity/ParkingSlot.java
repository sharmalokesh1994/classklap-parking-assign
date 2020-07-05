package com.parking.entity;

//considering only one type of Parking slots
public class ParkingSlot {

	 private int id;
	 private static int UID = 1;
	
	 // we can use enum also for status
	 private String status;
	 // if car is parked
	 //private Ticket ticket;
	 public ParkingSlot() {
	     setId();
	     status = "empty";
	 }
	
	 // id can be set only once
	 private void setId() {
	     this.id = UID;
	     UID++;
	 }
	
	 public int getId() {
	     return id;
	 }
	
	 public String getStatus() {
	     return status;
	 }
	
	 public void setStatus(String status) {
	     this.status = status;
	 }
 
}