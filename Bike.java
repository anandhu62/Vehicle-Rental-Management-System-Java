public class Bike extends Vehicle {

    private String bikeType;

    public Bike(String vehicleId,
                String brand,
                String model,
                double rentalRate,
                String bikeType) {

        super(vehicleId, brand, model, rentalRate);
        this.bikeType = bikeType;
    }

    public String getBikeType() {
        return bikeType;
    }

    @Override
    public String toString() {

        return super.toString() +
               ", Type: " + bikeType;
    }
}
