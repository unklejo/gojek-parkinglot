package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class GetRegNumberByColorTest {

	@Test
	public void testGetRegNumberByColorParkingLotNotCreated() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Parking lot has not been created yet",
				service.test("registration_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetRegNumberByColorNotFound() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1"); 
		Assert.assertEquals("Registration number of car with color: White not found",
				service.test("registration_numbers_for_cars_with_colour White"));
	}

	@Test
	public void testGetRegNumberByColorFoundOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 1");
		service.test("park aaa White");
		Assert.assertEquals("aaa",
				service.test("registration_numbers_for_cars_with_colour White"));
	}
	
	@Test
	public void testGetRegNumberByColorFoundMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		service.test("create_parking_lot 3");
		service.test("park aaa White");
		service.test("park bbb Black");
		service.test("park ccc White");
		Assert.assertEquals("aaa, ccc",
				service.test("registration_numbers_for_cars_with_colour White"));
	}

}
