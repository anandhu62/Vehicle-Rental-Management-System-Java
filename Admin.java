import java.util.List;

public class Admin {

    private Database database;

    public Admin(Database database) {
        this.database = database;
    }

    public void addVehicle(
            Vehicle vehicle) {

        database.addVehicle(vehicle);

        System.out.println(
            "Vehicle added successfully."
        );
    }

    public void viewAllBookings() {

        List<Booking> bookings =
                database.getBookings();

        if(bookings.isEmpty()) {

            System.out.println(
                "No bookings found."
            );

        } else {

            for(Booking booking :
                    bookings) {

                System.out.println(
                    booking
                );

                System.out.println(
                    "---------------"
                );
            }
        }
    }
}
