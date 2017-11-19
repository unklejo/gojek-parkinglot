package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class CreateParkingLotTest {

	@Test
	public void testCreateParkingLotMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Created a parking lot with 6 slots",
				service.execute("create_parking_lot 6"));
	}

	@Test
	public void testCreateParkingLotOnlyOne() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Created a parking lot with 1 slot",
				service.execute("create_parking_lot 1"));
	}
	
	@Test
	public void testCreateParkingLotNoParams() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Variable input must be a number",
				service.execute("create_parking_lot"));
	}

	@Test
	public void testCreateParkingLotNotNumber1() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Variable input must be a number",
				service.execute("create_parking_lot aaa"));
	}

	@Test
	public void testCreateParkingLotNotNumber2() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Variable input must be a number",
				service.execute("create_parking_lot  "));
	}
	
	@Test
	public void testCreateParkingLotMoreThanOneParameters() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Variable input must be a number",
				service.execute("create_parking_lot 3 3"));
	}

	@Test
	public void testCreateParkingLotAlreadyCreatedOnlyOneSlot() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		Assert.assertEquals("Parking lot is already created with 1 slot",
				service.execute("create_parking_lot 3"));
	}
	
	@Test
	public void testCreateParkingLotAlreadyCreatedMoreThanOneSlots() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 2");
		Assert.assertEquals("Parking lot is already created with 2 slots",
				service.execute("create_parking_lot 3"));
	}

}
