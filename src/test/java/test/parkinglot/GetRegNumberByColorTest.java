package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetRegNumberByColorTest {

	@Test
	public void testGetRegNumberByColorParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.execute("registration_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetRegNumberByColorNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1"); 
		Assert.assertEquals("Not found",
				service.execute("registration_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetRegNumberByColorFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 1");
		service.execute("park aaa White");
		Assert.assertEquals("aaa",
				service.execute("registration_numbers_for_cars_with_colour White"));
	}
	
	@Test
	public void testGetRegNumberByColorFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.execute("create_parking_lot 3");
		service.execute("park aaa White");
		service.execute("park bbb Black");
		service.execute("park ccc White");
		Assert.assertEquals("aaa, ccc",
				service.execute("registration_numbers_for_cars_with_colour White"));
	}

}
