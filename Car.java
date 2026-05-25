public class Car extends Vehicle {

    private int numberOfSeats;

    public Car(String vehicleId,
               String brand,
               String model,
               double rentalRate,
               int numberOfSeats) {

        super(vehicleId, brand, model, rentalRate);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {

        return super.toString() +
               ", Seats: " + numberOfSeats;
    }
}
