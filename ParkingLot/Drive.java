package Practice.ParkingLot;

public class Drive {

    public static void main(String[] args) {

        Parking parking = new ParkingImpl(5);

        Vehicule car = new Car("Honda", "ABC");
        Vehicule car2 = new Car("Toyota", "DEF");
        Vehicule car3 = new Car("Golf", "GHI");

        Spot spot = parking.getFreeSpot(car);
        Spot spot1 = parking.getFreeSpot(car2);

        try {
            parking.releaseSpotFromCar(car2);
            parking.releaseSpotFromCar(car3);

        } catch (ParkingException e) {
            System.out.print("Exception ==> " + e);
        }

    }
}
