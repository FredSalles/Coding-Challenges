package Practice.ParkingLot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ParkingImpl implements Parking {

    private Queue<Spot> freeSpots;
    private Map<Vehicule, Spot> usedSpots;

    public ParkingImpl(int capacity) {
        freeSpots = new LinkedList<Spot>();
        for (int i = 0; i < capacity; i++) {
            Spot spot = new Spot(i);
            freeSpots.add(spot);
        }
        usedSpots = new HashMap<Vehicule, Spot>();
    }

    /*
     * Summary of Method
     *  
     * @param Vehicule this is the vehicule that needs a spot
     * @return a spot
     * @exception none
     */
    @Override
    public Spot getFreeSpot(Vehicule vehicule) {
        Spot spot;
        spot = freeSpots.poll(); // NULL if empty (no Exception)
        usedSpots.put(vehicule, spot);
        return spot;
    }

    @Override
    public Spot releaseSpotFromCar(Vehicule vehicule) throws ParkingException {
        Spot spot = usedSpots.get(vehicule);
        if (spot == null) {
            throw new ParkingException("could not find corresponding spot\n");
        }
        freeSpots.add(spot);
        return spot;
    }

}
