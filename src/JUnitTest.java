import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {
	
	@Test
	public void checkTwoStringIsAnnagram() {
		assertEquals(true, new Anagram().isBothStringAnagram("Hello", "eHllo"));
	}
	
	@Test
	public void checkTwoStringIsNotAnnagram() {
		assertEquals(false, new Anagram().isBothStringAnagram("Helo", "eHllo"));
	}
	
	
	@Test
	public void testCarUsingBuilderPatternOnSuccessCase() {
		int numOfWheels = 4;
		int numOfPassengers = 5;
		boolean hasGas = false;
		
		VehicleTest.CarUsingBuilderPatten car = new VehicleTest.CarUsingBuilderPatten.Builder().withTotalWheels(numOfWheels).withPassengerMaxCapacity(numOfPassengers)
				.withGasEngine(hasGas).build();
		
		
		assertEquals(numOfWheels, car.getNumOfWheels());
		assertEquals(numOfPassengers, car.getNumOfPassengers());
		assertEquals(hasGas, car.hasGas());

	}
	
	@Test
	public void testPlaneUsingBuilderPatternSuccessCase() {
		int numOfWheels = 18;
		int numOfPassengers = 200;
		boolean hasGas = true;
		
		VehicleTest.PlaneUsingBuilderPatten plane = new VehicleTest.PlaneUsingBuilderPatten.Builder().withTotalWheels(numOfWheels)
				.withPassengerMaxCapacity(numOfPassengers).withGasEngine(true).build();
		
		assertEquals(numOfWheels, plane.getNumOfWheels());
		assertEquals(numOfPassengers, plane.getNumOfPassengers());
		assertEquals(hasGas, plane.hasGas());
	}
	
	@Test
	public void testCarUsingBuilderPatternOnFailCase() {
		int numOfWheels = 4;
		int numOfPassengers = 5;
		boolean hasGas = false;
		
		VehicleTest.CarUsingBuilderPatten car = new VehicleTest.CarUsingBuilderPatten.Builder().withTotalWheels(4).withPassengerMaxCapacity(5)
				.withGasEngine(false).build();
		
		assertNotEquals(50, car.getNumOfWheels());
		assertNotEquals(20, car.getNumOfPassengers());
		assertNotEquals(true, car.hasGas());
	}
	
	@Test
	public void testPlaneUsingBuilderPatternOnFailCase() {
		int numOfWheels = 18;
		int numOfPassengers = 200;
		boolean hasGas = true;
		
		VehicleTest.PlaneUsingBuilderPatten plane = new VehicleTest.PlaneUsingBuilderPatten.Builder().withTotalWheels(18)
				.withPassengerMaxCapacity(200).withGasEngine(true).build();
		
		assertNotEquals(50, plane.getNumOfWheels());
		assertNotEquals(20, plane.getNumOfPassengers());
		assertNotEquals(false, plane.hasGas());
	}
	
	@Test
	public void testForward() {
		VideoPlayer videoPlayer = new VideoPlayer();
		assertEquals(true, videoPlayer.forward(10));
	}
	
	@Test
	public void testRewind() {
		VideoPlayer videoPlayer = new VideoPlayer();
		assertEquals(true, videoPlayer.rewind());
	}
	
	@Test
	public void testPlay() {
		VideoPlayer videoPlayer = new VideoPlayer();
		assertEquals(true, videoPlayer.play());
	}
}
