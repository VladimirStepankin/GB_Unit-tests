package seminars.second.hw;

import seminar.second.hw.Car;
import seminar.second.hw.Motorcycle;
import seminar.second.hw.Vehicle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Red Bull", "RB9", 2013);
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarHas4Wheels() {
        Car car = new Car("Red Bull", "RB9", 2013);
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void testMotorcycleHas2Wheels() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZR-M1", 2002);
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void testCarReachesSpeed60InTestDrive() {
        Car car = new Car("Red Bull", "RB9", 2013);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void testMotorcycleReachesSpeed75InTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZR-M1", 2002);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void testCarStopsInParkingMode() {
        Car car = new Car("Red Bull", "RB9", 2013);
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testMotorcycleStopsInParkingMode() {
        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZR-M1", 2002);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}