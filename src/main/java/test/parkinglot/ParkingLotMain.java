package test.parkinglot;

import java.util.List;
import java.util.Scanner;

import test.parkinglot.domain.Car;
import test.parkinglot.domain.Color;
import test.parkinglot.domain.ParkingLot;

public class ParkingLotMain {
	
	private ParkingLot[] parkingLots;
	private final String pattern = "^[0-9]";

	public static void main(String[] args) {
		new ParkingLotMain();
	}
	
	private String getVarInput(String fullStringInput, String questionString) {
		if (fullStringInput.length() > questionString.length() + 1)
			return fullStringInput.substring(questionString.length() + 1);
		else
			return "";
	}

	public ParkingLotMain() {
		Scanner scanner = null;
		boolean stop = false;
		while (!stop) {
			System.out.println("Input:");
			scanner = new Scanner(System.in);
			String scannedInput = scanner.nextLine();
			
			String question;
			String response = "";
			
			if (scannedInput.startsWith("create_parking_lot")) {
				question = "create_parking_lot";
				response = createParkingLot(getVarInput(scannedInput, question));
			} else if (scannedInput.startsWith("park")) {
//				park KA-01-HH-1234 White
				question = "park";
				response = registerCar(getVarInput(scannedInput, question));
			} else if (scannedInput.startsWith("leave")) {
//				leave 4
				question = "leave";
//				varInput = getVarInput(scannedInput, question);
//				if (varInput.matches(pattern))
//					removeCar(Integer.parseInt(varInput));
				// else
			} else if (scannedInput.startsWith("Status")) {
//				Status
				checkStatus();
			} else if (scannedInput.startsWith("registration_numbers_for_cars_with_colour")) {
//				registration_numbers_for_cars_with_colour White
				question = "registration_numbers_for_cars_with_colour";
//				varInput = getVarInput(scannedInput, question);
//				getRegistrationNumbersByColor(Color.getColor(varInput));
			} else if (scannedInput.startsWith("slot_numbers_for_cars_with_colour")) {
//				slot_numbers_for_cars_with_colour White
				question = "slot_numbers_for_cars_with_colour";
//				varInput = getVarInput(scannedInput, question);
//				getSlotNumbersByColor(Color.getColor(varInput));
			} else if (scannedInput.startsWith("slot_number_for_registration_number")) {
//				slot_number_for_registration_number KA-01-HH-3141
				question = "slot_number_for_registration_number";
//				varInput = getVarInput(scannedInput, question);
//				getSlotNumbersByRegistrationNumber(varInput);
			} else if (scannedInput.equals("exit")
					|| scannedInput.equals("quit")) {
				stop = true;
				response = "Quitting application. See you later.";
			} else {
				response = "Command not recognized. Try again.";
			}
			
			System.out.println("Output:");
			System.out.println(response);
		}

		if (scanner != null)
		scanner.close();
	}
	

	public List<Car> getOccupiedParkingSlots() {
		return null;
	}

	public String createParkingLot(String varInput) {
		if (varInput.matches(pattern)) {
			int parkingLotQuantity = Integer.parseInt(varInput);
			if (parkingLots == null) {
				parkingLots = new ParkingLot[parkingLotQuantity];
				for (int i = 0; i < parkingLotQuantity; i++) {
					ParkingLot parkingLot = new ParkingLot();
					parkingLot.setSlotNumber(i+1);
					parkingLots[i] = parkingLot;
				}
				return "Created a parking lot with " + parkingLotQuantity
						+ " slots";
			} else {
				return "Parking lot is already created with "
						+ parkingLots.length + " slot" 
						+ (parkingLots.length > 1 ? "s" : "");
			}
		} else {
			return "Variable input must be a number";
		}

	}

	public String registerCar(String varInput) {
		String[] inputs = varInput.split("\\s");
		if (inputs.length == 2) {
			// set car
			Car car = new Car();
			car.setRegistrationNumber(inputs[0]);
			car.setColor(Color.getColor(inputs[1]));
			
//			ParkingLot[] usedParkingLots = checkStatus();
			for (int i = 0; i < parkingLots.length; i ++) {
				if (parkingLots[i].getCar() == null) {
					parkingLots[i].setCar(car);
					break;
				}
			}
		} else {
			return "Variable input must contains exact 2 premises";
		}

		int parkingLotNumber = 0;
		System.out.println("Allocated slot number: " + parkingLotNumber);
		System.out.println("Sorry, parking lot is full");
		return null;
	}

	public void removeCar(int parkingLotNumber) {
		System.out.println("Slot number " + parkingLotNumber + " is free");
	}

	public ParkingLot[] checkStatus() {
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