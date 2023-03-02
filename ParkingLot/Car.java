package Practice.ParkingLot;


public class Car extends Vehicule {

    private String plate;

    public String getPlate() {
        return plate;
    }

    public Car(String maker, String plate) {
        super(maker);
        this.plate = plate;
    }
    
}  
