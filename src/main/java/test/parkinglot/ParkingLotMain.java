package test.parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParkingLotMain {

	public static void main(String[] args) {
		if (args.length > 0) {
			File file = new File(args[0]);
			try {
				new ParkingLotMain(new Scanner(file), false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			new ParkingLotMain(new Scanner(System.in), true);
		}
	}

	public ParkingLotMain(Scanner scanner, boolean isCommandLine) {
		boolean stop = false;
		ParkingLotService service = new ParkingLotService();
		System.out.print("\n\n");
		while (!stop) {
			if (isCommandLine)
				System.out.println("Input:");
			String scannedInput = scanner.nextLine();
			String response = service.execute(scannedInput);
			if (isCommandLine) {
				System.out.println("Output:\n" + response);
				if (scannedInput.equals("exit") || scannedInput.equals("quit"))
					stop = true;
			} else {
				System.out.println(response);
				if (!scanner.hasNext())
					stop = true;
			}
		}

		if (scanner != null)
			scanner.close();
	}

}