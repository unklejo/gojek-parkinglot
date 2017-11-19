package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetSlotNumberByRegNumberTest {

	@Test
	public void testGetSlotNumberByRegNumberParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.execute("slot_number_for_registration_number aaa"));
	}

	@Test
	public void testGetSlotNumberByRegNumberNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		Assert.assertEquals("Not found",
				service.execute("slot_number_for_registration_number aaa"));
	}

	@Test
	public void testGetSlotNumberByRegNumberFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		service.execute("park aaa White");
		Assert.assertEquals("1",
				service.execute("slot_number_for_registration_number aaa"));
	}
	
	@Test
	public void testGetSlotNumberByRegNumberFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 3");
		service.execute("park aaa White");
		service.execute("park bbb Black");
		service.execute("park ccc White");
		Assert.assertEquals("1",
				service.execute("slot_number_for_registration_number aaa"));
		Assert.assertNotSame("2",
				service.execute("slot_number_for_registration_number aaa"));
		Assert.assertNotSame("3",
				service.execute("slot_number_for_registration_number aaa"));
	}

}
