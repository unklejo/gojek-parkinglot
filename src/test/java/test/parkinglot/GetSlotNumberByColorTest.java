package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetSlotNumberByColorTest {

	@Test
	public void testGetSlotNumberByColorParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.execute("slot_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetSlotNumberByColorNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		Assert.assertEquals("Not found",
				service.execute("slot_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetSlotNumberByColorFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		service.execute("park aaa White");
		Assert.assertEquals("1",
				service.execute("slot_numbers_for_cars_with_colour White"));
	}
	
	@Test
	public void testGetSlotNumberByColorFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 3");
		service.execute("park aaa White");
		service.execute("park bbb Black");
		service.execute("park ccc White");
		Assert.assertEquals("1, 3",
				service.execute("slot_numbers_for_cars_with_colour White"));
	}

}
