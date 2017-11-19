package test.parkinglot;

import test.parkinglot.domain.Car;
import test.parkinglot.domain.Color;
import test.parkinglot.domain.ParkingLot;

public class ParkingLotService {

	private ParkingLot[] parkingLots;
	private final String pattern = "^[0-9]";

	public String createParkingLot(String varInput) {
		if (varInput.matches(pattern)) {
			int parkingLotQuantity = Integer.parseInt(varInput);
			if (parkingLots == null) {
				parkingLots = new ParkingLot[parkingLotQuantity];
				for (int i = 0; i < parkingLotQuantity; i++) {
					ParkingLot parkingLot = new ParkingLot();
					parkingLot.setSlotNumber(i + 1);
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
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i].getCar() == null) {
					parkingLots[i].setCar(new Car(inputs[0], Color
							.getColor(inputs[1])));
					return "Allocated slot number: "
							+ parkingLots[i].getSlotNumber();
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
				for (int i = 0; i < parkingLots.length; i++) {
					if (parkingLots[i].getSlotNumber() == toBeRemovedSlotNumber) {
						parkingLots[i].setCar(null);
						return "Slot number " + toBeRemovedSlotNumber
								+ " is free";
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
		String temp = "No | Registration Slot No. | Color\n";
		if (parkingLots != null) {
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i].getCar() != null) {
					temp += parkingLots[i].getSlotNumber() + " | ";
					temp += parkingLots[i].getCar().getRegistrationNumber()
							+ " | ";
					temp += parkingLots[i].getCar().getColor().getStringVal()
							+ "\n";
				}
			}
		}
		return temp;
	}

	public String getRegistrationNumbersByColor(String varInput) {
		Color color = Color.getColor(varInput);
		String temp = "";
		if (parkingLots != null) {
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i].getCar() != null
						&& parkingLots[i].getCar().getColor().equals(color)) {
					temp += parkingLots[i].getCar().getRegistrationNumber()
							+ ", ";
				}
			}
		}
		return temp.length() > 0 ? (temp.endsWith(", ") ? temp.substring(0,
				temp.length() - 2) : temp)
				: ("Registration number of car with color: " + varInput + " not found");
	}

	public String getSlotNumbersByColor(String varInput) {
		Color color = Color.getColor(varInput);
		String temp = "";
		if (parkingLots != null) {
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i].getCar() != null
						&& parkingLots[i].getCar().getColor().equals(color)) {
					temp += parkingLots[i].getSlotNumber() + ", ";
				}
			}
		}
		return temp.length() > 0 ? (temp.endsWith(", ") ? temp.substring(0,
				temp.length() - 2) : temp) : ("Slot number of car with color: "
				+ varInput + " not found");
	}

	public String getSlotNumbersByRegistrationNumber(String varInput) {
		if (parkingLots != null) {
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i].getCar() != null
						&& parkingLots[i].getCar().getRegistrationNumber()
								.equals(varInput)) {
					return String.valueOf(parkingLots[i].getSlotNumber());
				}
			}
		}
		return "Slot number of car with registration number: " + varInput
				+ " not found";
	}

	public String test(String scannedInput) {
		if (scannedInput.startsWith("create_parking_lot")) {
			return createParkingLot(getVarInput(scannedInput, "create_parking_lot"));
		} else if (scannedInput.startsWith("park")) {
			return registerCar(getVarInput(scannedInput, "park"));
		} else if (scannedInput.startsWith("leave")) {
			return removeCar(getVarInput(scannedInput, "leave"));
		} else if (scannedInput.startsWith("Status")) {
			return checkStatus();
		} else if (scannedInput
				.startsWith("registration_numbers_for_cars_with_colour")) {
			return getRegistrationNumbersByColor(getVarInput(scannedInput, "registration_numbers_for_cars_with_colour"));
		} else if (scannedInput.startsWith("slot_numbers_for_cars_with_colour")) {
			return getSlotNumbersByColor(getVarInput(scannedInput, "slot_numbers_for_cars_with_colour"));
		} else if (scannedInput
				.startsWith("slot_number_for_registration_number")) {
			return getSlotNumbersByRegistrationNumber(getVarInput(scannedInput, "slot_number_for_registration_number"));
		} else if (scannedInput.equals("exit") || scannedInput.equals("quit")) {
			return "Quitting application. See you later.";
		} else {
			return "Command not recognized. Try again.";
		}
	}
	
	public String getVarInput(String fullStringInput, String questionString) {
		if (fullStringInput.length() > questionString.length() + 1)
			return fullStringInput.substring(questionString.length() + 1);
		else
			return "";
	}

}
