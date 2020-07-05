package com.parking.entity;

//considering only one type of Vehicle(Car)
public class Car {

	private String regNumber;
	private String color;

	public Car(String regNumber, String color) {
	     // we can call setter method here to make one more validation layer
	     this.regNumber = regNumber;
	     this.color = color;
	 }
	
	 public String getRegNumber() {
	     return regNumber;
	 }
	 
	 private void setRegNumber(String regNumber) {
	     this.regNumber = regNumber;
	 }
	
	 public String getColor() {
	     return color;
	 }
	
	public void setColor(String color) {
	     this.color = color;
	}
 
}
