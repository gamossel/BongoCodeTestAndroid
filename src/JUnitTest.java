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

		VehicleTest.CarUsingBuilderPatten car = new VehicleTest.CarUsingBuilderPatten.Builder().withTotalWheels(4).withPassengerMaxCapacity(5)
				.withGasEngine(false).build();
		assertEquals("Car using 4 wheels, 5 passengers and will run in gas false", car.run());
	}
	
	@Test
	public void testPlaneUsingBuilderPatternSuccessCase() {
		VehicleTest.PlaneUsingBuilderPatten plane = new VehicleTest.PlaneUsingBuilderPatten.Builder().withTotalWheels(18)
				.withPassengerMaxCapacity(200).withGasEngine(true).build();
		assertEquals("Plane using 18 wheels, 200 passengers and will run in gas true", plane.run());
	}
	
	@Test
	public void testCarUsingBuilderPatternOnFailCase() {

		VehicleTest.CarUsingBuilderPatten car = new VehicleTest.CarUsingBuilderPatten.Builder().withTotalWheels(4).withPassengerMaxCapacity(5)
				.withGasEngine(false).build();
		assertNotEquals("Car using 2 wheels, 6 passengers and will run in gas false", car.run());
	}
	
	@Test
	public void testPlaneUsingBuilderPatternOnFailCase() {
		VehicleTest.PlaneUsingBuilderPatten plane = new VehicleTest.PlaneUsingBuilderPatten.Builder().withTotalWheels(18)
				.withPassengerMaxCapacity(200).withGasEngine(true).build();
		assertNotEquals("Plane using 17 wheels, 200 passengers and will run in gas false", plane.run());
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
