import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String VEHICLES_FILE =
            "vehicles.ser";

    private static final String CUSTOMERS_FILE =
            "customers.ser";

    private static final String BOOKINGS_FILE =
            "bookings.ser";

    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<Booking> bookings;

    public Database() {

        this.vehicles =
                loadData(VEHICLES_FILE);

        this.customers =
                loadData(CUSTOMERS_FILE);

        this.bookings =
                loadData(BOOKINGS_FILE);
    }

    public void addVehicle(
            Vehicle vehicle) {

        vehicles.add(vehicle);

        saveData(
                VEHICLES_FILE,
                vehicles
        );
    }

    public void addCustomer(
            Customer customer) {

        customers.add(customer);

        saveData(
                CUSTOMERS_FILE,
                customers
        );
    }

    public void addBooking(
            Booking booking) {

        bookings.add(booking);

        saveData(
                BOOKINGS_FILE,
                bookings
        );
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    private <T> List<T> loadData(
            String fileName) {

        try(ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream(
                                    fileName))) {

            return (List<T>)
                    ois.readObject();

        }

        catch(FileNotFoundException e) {

            return new ArrayList<>();
        }

        catch(IOException |
              ClassNotFoundException e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }

    private <T> void saveData(
            String fileName,
            List<T> data) {

        try(ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    fileName))) {

            oos.writeObject(data);

        }

        catch(IOException e) {

            e.printStackTrace();
        }
    }
}
