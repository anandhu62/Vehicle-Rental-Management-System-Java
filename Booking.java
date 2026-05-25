import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

    private String bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
    private double totalCost;

    public Booking(String bookingId,
                   Customer customer,
                   Vehicle vehicle,
                   Date startDate,
                   Date endDate) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;

        long diff =
            endDate.getTime() -
            startDate.getTime();

        long days =
            diff / (1000 * 60 * 60 * 24);

        this.totalCost =
            days * vehicle.getRentalRate();
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {

        return "Booking ID: " + bookingId +
                "\nCustomer: " +
                customer.getName() +
                "\nVehicle: " +
                vehicle.getBrand() +
                " " +
                vehicle.getModel() +
                "\nStart Date: " +
                startDate +
                "\nEnd Date: " +
                endDate +
                "\nTotal Cost: " +
                totalCost;
    }
}
