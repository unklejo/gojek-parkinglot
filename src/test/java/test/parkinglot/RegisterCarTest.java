package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class RegisterCarTest {

	@Test
	public void testRegisterCarParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.execute("park aaa White"));
	}

	@Test
	public void testRegisterOneCarOnOneParkingLot() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.execute("park aaa White"));
	}

	@Test
	public void testRegisterTwoCarOnOneParkingLot1() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.execute("park aaa White"));
		Assert.assertNotSame("Allocated slot number: 2",
				service.execute("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnOneParkingLot2() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.execute("park aaa White"));
		Assert.assertEquals("Sorry, parking lot is full",
				service.execute("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnTwoParkingLot1() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 2"); 
		Assert.assertEquals("Allocated slot number: 1",
				service.execute("park aaa White"));
		Assert.assertEquals("Allocated slot number: 2",
				service.execute("park bbb Black"));
	}

	@Test
	public void testRegisterTwoCarOnTwoParkingLot2() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 2");
		Assert.assertEquals("Allocated slot number: 1",
				service.execute("park aaa White"));
		Assert.assertNotSame("Sorry, parking lot is full",
				service.execute("park bbb Black"));
	}
	
	@Test
	public void testRegisterCarMoreThanTwoParameters() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1"); 
		Assert.assertNotSame("Allocated slot number: 1",
				service.execute("park bbb Black Red"));
		Assert.assertEquals("Variable input must contains exact 2 premises",
				service.execute("park aaa White Black"));
	}

}
