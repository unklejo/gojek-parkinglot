package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetSlotNumberByRegNumberTest {

	@Test
	public void testGetSlotNumberByRegNumberParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.test("slot_number_for_registration_number aaa"));
	}

	@Test
	public void testGetSlotNumberByRegNumberNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1");
		Assert.assertEquals("Slot number of car with registration number: aaa not found",
				service.test("slot_number_for_registration_number aaa"));
	}

	@Test
	public void testGetSlotNumberByRegNumberFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1");
		service.test("park aaa White");
		Assert.assertEquals("1",
				service.test("slot_number_for_registration_number aaa"));
	}
	
	@Test
	public void testGetSlotNumberByRegNumberFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 3");
		service.test("park aaa White");
		service.test("park bbb Black");
		service.test("park ccc White");
		Assert.assertEquals("1",
				service.test("slot_number_for_registration_number aaa"));
		Assert.assertNotSame("2",
				service.test("slot_number_for_registration_number aaa"));
		Assert.assertNotSame("3",
				service.test("slot_number_for_registration_number aaa"));
	}

}
