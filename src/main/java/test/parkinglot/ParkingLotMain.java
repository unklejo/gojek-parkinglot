package test.parkinglot;

import java.util.List;

import test.parkinglot.domain.Car;
import test.parkinglot.domain.Color;

public class ParkingLotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Car> getOccupiedParkingSlots() {
		return null;
	}

	public void createParkingLot(int parkingLotQuantity) {
		System.out.println("Created a parking lot with "
				+ parkingLotQuantity
				+ " slots");
	}
	
	public int registerCar(String registrationNumber, String color) {
		Car car = new Car();
		car.setRegistrationNumber(registrationNumber);
		car.setColor(Color.getColor(color));
		
		int parkingLotNumber = 0; 
		System.out.println("Allocated slot number: " + parkingLotNumber);
		System.out.println("Sorry, parking lot is full");
		return 1;
	}
	
	public void removeCar(int parkingLotNumber) {
		System.out.println("Slot number " + parkingLotNumber + " is free");
	}
	
	public List<Car> checkStatus() {
		return null;
	}
	
	public List<String> getRegistrationNumbersByColor(Color color) {
		return null;
	}
	
	public List<Integer> getSlotNumbersByColor(Color color) {
		return null;
	}

	public int getSlotNumbersByRegistrationNumber(String registrationNumber) {
		return 0;
		/*
		Input: 
		slot_number_for_registration_number MH-04-AY-1111
		Output: 
		Not found
		 */
	}

}
