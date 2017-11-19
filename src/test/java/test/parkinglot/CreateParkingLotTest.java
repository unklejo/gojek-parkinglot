package test.parkinglot;

import junit.framework.Assert;

import org.junit.Test;

public class ParkingLotMainTest {

	@Test
	public void testCreateParkingLotMoreThanOne() {
		ParkingLotService service = new ParkingLotService();
		Assert.assertEquals("Created a parking lot with 6 slots",
				service.test("create_parking_lot 6"));
	}

}
