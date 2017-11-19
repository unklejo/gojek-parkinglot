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
				response = removeCar(getVarInput(scannedInput, question));
				// else
			} else if (scannedInput.startsWith("Status")) {
//				Status
				response = checkStatus();
			} else if (scannedInput.startsWith("registration_numbers_for_cars_with_colour")) {
//				registration_numbers_for_cars_with_colour White
				question = "registration_numbers_for_cars_with_colour";
				getRegistrationNumbersByColor(Color.getColor(getVarInput(scannedInput, question)));
			} else if (scannedInput.startsWith("slot_numbers_for_cars_with_colour")) {
//				slot_numbers_for_cars_with_colour White
				question = "slot_numbers_for_cars_with_colour";
				getSlotNumbersByColor(Color.getColor(getVarInput(scannedInput, question)));
			} else if (scannedInput.startsWith("slot_number_for_registration_number")) {
//				slot_number_for_registration_number KA-01-HH-3141
				question = "slot_number_for_registration_number";
				getSlotNumbersByRegistrationNumber(getVarInput(scannedInput, question));
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
				for (int i = 0; i < parkingLots.length; i ++) {
					if (parkingLots[i].getCar() == null) {
						parkingLots[i].setCar(new Car(inputs[0], Color.getColor(inputs[1])));
						return "Allocated slot number: " + parkingLots[i].getSlotNumber();
					}
				}
				return "Sorry, parking lot is full";
		} else {
			return "Variable input must contains exact 2 premises";
		}
	}

	public String removeCar(String varInput) {
		if (varInput.matches(pattern)) {
			int toBeRemovedSlotNumber = Integer.parseInt(varInput);
			if (toBeRemovedSlotNumber > 0 
					&& toBeRemovedSlotNumber <= parkingLots.length) {
				for (int i = 0; i < parkingLots.length; i ++) {
					if (parkingLots[i].getSlotNumber() == toBeRemovedSlotNumber) {
						parkingLots[i].setCar(null);
						return "Slot number " + toBeRemovedSlotNumber + " is free";
					}
				}
			} else {
				return "Variable input is higher than maximum occupancy "
						+ "/ has 0 / has negative value";
			}
		} else {
			return "Variable input must be a number";
		}
		return null;
	}

	public String checkStatus() {
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