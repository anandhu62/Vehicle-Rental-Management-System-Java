import java.io.Serializable;

public class Vehicle implements Serializable {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String brand,
                   String model, double rentalRate) {

        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentalRate = rentalRate;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {

        return "Vehicle ID: " + vehicleId +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Rate: " + rentalRate +
                ", Available: " + isAvailable;
    }
}
