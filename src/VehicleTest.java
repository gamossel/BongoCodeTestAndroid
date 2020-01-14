public class VehicleTest {
	public static void main(String[] args) {
		VehicleTest vehicleTest = new VehicleTest();
		Car car = vehicleTest.new Car();
		car.run();
		Plane plane = vehicleTest.new Plane();
		plane.fly();

		CarUsingBuilderPatten bCar = new CarUsingBuilderPatten.Builder().withTotalWheels(4).withPassengerMaxCapacity(5)
				.withGasEngine(false).build();
		System.out.println(bCar.run());

		PlaneUsingBuilderPatten bPlane = new PlaneUsingBuilderPatten.Builder().withTotalWheels(18)
				.withPassengerMaxCapacity(200).withGasEngine(true).build();
		System.out.println(bPlane.run());
	}

	/*
	 * Answer-a: I will implements the interface in two classes name Car and Plane.
	 * For that I need to override those methods.
	 */
	interface Vehicle {
		int set_num_of_wheels();

		int set_num_of_passengers();

		boolean has_gas();
	}

	public class Car implements Vehicle {
		@Override
		public int set_num_of_wheels() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public int set_num_of_passengers() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public boolean has_gas() {
			// TODO Auto-generated method stub
			return true;
		}

		void run() {
			System.out.println("Running...");
		}
	}

	public class Plane implements Vehicle {
		@Override
		public int set_num_of_wheels() {
			// TODO Auto-generated method stub
			return 18;
		}

		@Override
		public int set_num_of_passengers() {
			// TODO Auto-generated method stub
			return 200;
		}

		@Override
		public boolean has_gas() {
			// TODO Auto-generated method stub
			return true;
		}

		void fly() {
			System.out.println("Flying...");
		}
	}

	/*
	 * Answer-b: Builder pattern will be used
	 * 
	 */
	public static class CarUsingBuilderPatten {
		private int numOfWheels;
		private int numOfPassengers;
		private boolean willRunInGas;

		private CarUsingBuilderPatten() {

		}

		public static class Builder {
			private int numOfWheels;
			private int numOfPassengers;
			private boolean willRunInGas;

			public Builder() {

			}

			public Builder withTotalWheels(int wheels) {
				this.numOfWheels = wheels;
				return this;
			}

			public Builder withPassengerMaxCapacity(int numOfPassengers) {
				this.numOfPassengers = numOfPassengers;
				return this;
			}

			public Builder withGasEngine(boolean willRunInGas) {
				this.willRunInGas = willRunInGas;
				return this;
			}

			public CarUsingBuilderPatten build() {
				CarUsingBuilderPatten car = new CarUsingBuilderPatten();
				car.numOfWheels = this.numOfWheels;
				car.numOfPassengers = this.numOfPassengers;
				car.willRunInGas = this.willRunInGas;
				return car;
			}
		}

		public String run() {
			return String.format("Car using %d wheels, %d passengers and will run in gas %b", numOfWheels,
					numOfPassengers, willRunInGas);
		}
	}

	public static class PlaneUsingBuilderPatten {
		private int numOfWheels;
		private int numOfPassengers;
		private boolean willRunInGas;

		private PlaneUsingBuilderPatten() {

		}

		public static class Builder {
			private int numOfWheels;
			private int numOfPassengers;
			private boolean willRunInGas;

			public Builder() {

			}

			public Builder withTotalWheels(int wheels) {
				this.numOfWheels = wheels;
				return this;
			}

			public Builder withPassengerMaxCapacity(int numOfPassengers) {
				this.numOfPassengers = numOfPassengers;
				return this;
			}

			public Builder withGasEngine(boolean willRunInGas) {
				this.willRunInGas = willRunInGas;
				return this;
			}

			public PlaneUsingBuilderPatten build() {
				PlaneUsingBuilderPatten plane = new PlaneUsingBuilderPatten();
				plane.numOfWheels = this.numOfWheels;
				plane.numOfPassengers = this.numOfPassengers;
				plane.willRunInGas = this.willRunInGas;
				return plane;
			}
		}

		public String run() {
			return String.format("Plane using %d wheels, %d passengers and will run in gas %b", numOfWheels,
					numOfPassengers, willRunInGas);
		}
	}
}
