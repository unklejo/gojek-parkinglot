package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class RegisterCarTest {

	@Test
	public void testRegisterCarParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.test("park aaa White"));
	}

	@Test
	public void testRegisterOneCarOnOneParkingLot() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.test("park aaa White"));
	}

	@Test
	public void testRegisterTwoCarOnOneParkingLot1() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.test("park aaa White"));
		Assert.assertNotSame("Allocated slot number: 2",
				service.test("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnOneParkingLot2() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.test("park aaa White"));
		Assert.assertEquals("Sorry, parking lot is full",
				service.test("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnTwoParkingLot1() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 2"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.test("park aaa White"));
		Assert.assertEquals("Allocated slot number: 2",
				service.test("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnTwoParkingLot2() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 2");
		Assert.assertEquals("Allocated slot number: 1",
				service.test("park aaa White"));
		Assert.assertNotSame("Sorry, parking lot is full",
				service.test("park bbb Black"));
	}
	
	@Test
	public void testRegisterCarMoreThanTwoParameters() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertNotSame("Allocated slot number: 1",
				service.test("park bbb Black Red"));
		Assert.assertEquals("Variable input must contains exact 2 premises",
				service.test("park aaa White Black"));
	}

}
