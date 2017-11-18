package test.parkinglot;

import java.util.List;
import java.util.Scanner;

import test.parkinglot.domain.Car;
import test.parkinglot.domain.Color;

public class ParkingLotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ParkingLotMain();
	}
	
	private String getInput(String fullStringInput, String questionString) {
		if (fullStringInput.length() > questionString.length() + 1)
			return fullStringInput.substring(questionString.length() + 1);
		else
			return "";
	}

	public ParkingLotMain() {
		System.out.println("Input: ");
		Scanner q = new Scanner(System.in);
		String scannedInput = q.nextLine();
		
		String input;
		String question;
		String pattern= "^[0-9]";
		
		if (scannedInput.startsWith("create_parking_lot")) {
			question = "create_parking_lot";
			input = getInput(scannedInput, question);
			if (input.matches(pattern))
				createParkingLot(Integer.parseInt(input));
			// else
		} else if (scannedInput.startsWith("park")) {
//			park KA-01-HH-1234 White
			question = "park";
			input = getInput(scannedInput, question);
			String[] inputs = input.split("\\s");
			if (inputs.length == 2)
				registerCar(inputs[0], inputs[1]);
			// else
		} else if (scannedInput.startsWith("leave")) {
//			leave 4
			question = "leave";
			input = getInput(scannedInput, question);
			if (input.matches(pattern))
				removeCar(Integer.parseInt(input));
			// else
		} else if (scannedInput.startsWith("Status")) {
//			Status
			checkStatus();
		} else if (scannedInput.startsWith("registration_numbers_for_cars_with_colour")) {
//			registration_numbers_for_cars_with_colour White
			question = "registration_numbers_for_cars_with_colour";
			input = getInput(scannedInput, question);
			getRegistrationNumbersByColor(Color.getColor(input));
		} else if (scannedInput.startsWith("slot_numbers_for_cars_with_colour")) {
//			slot_numbers_for_cars_with_colour White
			question = "slot_numbers_for_cars_with_colour";
			input = getInput(scannedInput, question);
			getSlotNumbersByColor(Color.getColor(input));
		} else if (scannedInput.startsWith("slot_number_for_registration_number")) {
//			slot_number_for_registration_number KA-01-HH-3141
			question = "slot_number_for_registration_number";
			input = getInput(scannedInput, question);
			getSlotNumbersByRegistrationNumber(input);
		}

		q.close();
	}
	

	public List<Car> getOccupiedParkingSlots() {
		return null;
	}

	public void createParkingLot(int parkingLotQuantity) {
		System.out.println("Created a parking lot with " + parkingLotQuantity
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
		 * Input: slot_number_for_registration_number MH-04-AY-1111 Output: Not
		 * found
		 */
	}

}