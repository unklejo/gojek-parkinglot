package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class RemoveCarTest {

	@Test
	public void testRemoveCarParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.test("leave 1"));
	}

	@Test
	public void testRemoveOneCarOnOneParkingLot() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Slot number 1 is free",
				service.test("leave 1"));
	}

	@Test
	public void testRemoveCarOnOneParkingLotMoreThanOnce() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Slot number 1 is free",
				service.test("leave 1"));
		Assert.assertEquals("Slot number 1 is free",
				service.test("leave 1"));
	}

	@Test
	public void testRemoveTwoCarsOnOneParkingLot() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Slot number 1 is free",
				service.test("leave 1"));
		Assert.assertEquals("Variable input is higher than maximum occupancy / has 0 / has negative value",
				service.test("leave 2"));
		Assert.assertNotSame("Slot number 2 is free",
				service.test("leave 2"));
	}

	@Test
	public void testRemoveCarInvalidParameters() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Variable input must be a number",
				service.test("leave 1 1"));
		Assert.assertEquals("Variable input must be a number",
				service.test("leave aa"));
	}

}
