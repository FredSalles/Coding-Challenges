package Practice.ParkingLot;

public interface Parking {

    public Spot getFreeSpot(Vehicule vehicule);
    public Spot releaseSpotFromCar (Vehicule vehicule) throws ParkingException;

}
