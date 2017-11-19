package test.parkinglot;

import java.util.Scanner;

public class ParkingLotMain {

	public static void main(String[] args) {
		new ParkingLotMain();
	}

	public ParkingLotMain() {
		Scanner scanner = null;
		boolean stop = false;
		ParkingLotService service = new ParkingLotService();
		while (!stop) {
			System.out.println("Input:");
			scanner = new Scanner(System.in);
			String scannedInput = scanner.nextLine();

			String question;
			String response = "";

			if (scannedInput.startsWith("create_parking_lot")) {
				question = "create_parking_lot";
				response = service.createParkingLot(service.getVarInput(
						scannedInput, question));
			} else if (scannedInput.startsWith("park")) {
				// park KA-01-HH-1234 White
				question = "park";
				response = service.registerCar(service.getVarInput(
						scannedInput, question));
			} else if (scannedInput.startsWith("leave")) {
				// leave 4
				question = "leave";
				response = service.removeCar(service.getVarInput(scannedInput,
						question));
				// else
			} else if (scannedInput.startsWith("Status")) {
				// Status
				response = service.checkStatus();
			} else if (scannedInput
					.startsWith("registration_numbers_for_cars_with_colour")) {
				// registration_numbers_for_cars_with_colour White
				question = "registration_numbers_for_cars_with_colour";
				response = service.getRegistrationNumbersByColor(service
						.getVarInput(scannedInput, question));
			} else if (scannedInput
					.startsWith("slot_numbers_for_cars_with_colour")) {
				// slot_numbers_for_cars_with_colour White
				question = "slot_numbers_for_cars_with_colour";
				response = service.getSlotNumbersByColor(service.getVarInput(
						scannedInput, question));
			} else if (scannedInput
					.startsWith("slot_number_for_registration_number")) {
				// slot_number_for_registration_number KA-01-HH-3141
				question = "slot_number_for_registration_number";
				response = service.getSlotNumbersByRegistrationNumber(service
						.getVarInput(scannedInput, question));
			} else if (scannedInput.equals("exit")
					|| scannedInput.equals("quit")) {
				stop = true;
				response = "Quitting application. See you later.";
			} else {
				response = "Command not recognized. Try again.";
			}

			System.out.println("Output:");
			System.out.println(response);
			System.out.println("");
		}

		if (scanner != null)
			scanner.close();
	}

}