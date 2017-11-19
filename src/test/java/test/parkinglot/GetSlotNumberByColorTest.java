package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetSlotNumberByColorTest {

	@Test
	public void testGetSlotNumberByColorParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.test("slot_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetSlotNumberByColorNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1");
		Assert.assertEquals("Slot number of car with color: White not found",
				service.test("slot_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetSlotNumberByColorFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1");
		service.test("park aaa White");
		Assert.assertEquals("1",
				service.test("slot_numbers_for_cars_with_colour White"));
	}
	
	@Test
	public void testGetSlotNumberByColorFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 3");
		service.test("park aaa White");
		service.test("park bbb Black");
		service.test("park ccc White");
		Assert.assertEquals("1, 3",
				service.test("slot_numbers_for_cars_with_colour White"));
	}

}
