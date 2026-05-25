import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(
            String[] args) {

        Database database =
                new Database();

        Admin admin =
                new Admin(database);

        Scanner scanner =
                new Scanner(System.in);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "yyyy-MM-dd");

        while(true) {

            System.out.println(
             "\n--- Vehicle Rental Management System ---");

            System.out.println(
             "1. Add Vehicle");

            System.out.println(
             "2. View All Vehicles");

            System.out.println(
             "3. Add Customer");

            System.out.println(
             "4. Book a Vehicle");

            System.out.println(
             "5. View All Bookings");

            System.out.println(
             "6. Exit");

            System.out.print(
             "Enter your choice: ");

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            switch(choice) {

                case 1:

                    System.out.print(
                     "Enter vehicle type (Car/Bike): ");

                    String type =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Vehicle ID: ");

                    String vehicleId =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Brand: ");

                    String brand =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Model: ");

                    String model =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Rental Rate: ");

                    double rate =
                            scanner.nextDouble();

                    scanner.nextLine();

                    if(type.equalsIgnoreCase(
                            "Car")) {

                        System.out.print(
                         "Enter Number of Seats: ");

                        int seats =
                                scanner.nextInt();

                        scanner.nextLine();

                        admin.addVehicle(
                         new Car(
                          vehicleId,
                          brand,
                          model,
                          rate,
                          seats));

                    }

                    else if(
                     type.equalsIgnoreCase(
                             "Bike")) {

                        System.out.print(
                         "Enter Bike Type: ");

                        String bikeType =
                                scanner.nextLine();

                        admin.addVehicle(
                         new Bike(
                          vehicleId,
                          brand,
                          model,
                          rate,
                          bikeType));
                    }

                    break;

                case 2:

                    System.out.println(
                     "\n--- All Vehicles ---");

                    for(Vehicle v :
                            database.getVehicles()) {

                        System.out.println(v);
                    }

                    break;

                case 3:

                    System.out.print(
                     "Enter Customer ID: ");

                    String customerId =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Name: ");

                    String name =
                            scanner.nextLine();

                    System.out.print(
                     "Enter Contact Number: ");

                    String contact =
                            scanner.nextLine();

                    database.addCustomer(
                     new Customer(
                      customerId,
                      name,
                      contact));

                    break;
                                case 4:

                    try {

                        System.out.print(
                         "Enter Customer ID: ");

                        String custId =
                                scanner.nextLine();

                        Customer customer =
                         database
                         .getCustomers()
                         .stream()
                         .filter(c ->
                          c.getCustomerId()
                          .equals(custId))
                         .findFirst()
                         .orElse(null);

                        if(customer == null) {

                            System.out.println(
                             "Customer not found.");

                            break;
                        }

                        System.out.print(
                         "Enter Vehicle ID to book: ");

                        String vehId =
                                scanner.nextLine();

                        Vehicle vehicle =
                         database
                         .getVehicles()
                         .stream()
                         .filter(v ->
                          v.getVehicleId()
                          .equals(vehId)
                          && v.isAvailable())
                         .findFirst()
                         .orElse(null);

                        if(vehicle == null) {

                            throw new
                            InvalidBookingException(
                             "Vehicle is not available for booking.");
                        }

                        System.out.print(
                         "Enter Start Date (yyyy-MM-dd): ");

                        Date startDate =
                         dateFormat.parse(
                          scanner.nextLine());

                        System.out.print(
                         "Enter End Date (yyyy-MM-dd): ");

                        Date endDate =
                         dateFormat.parse(
                          scanner.nextLine());

                        Booking booking =
                         new Booking(
                          "B" +
                          (database
                           .getBookings()
                           .size()+1),

                          customer,
                          vehicle,
                          startDate,
                          endDate);

                        database
                        .addBooking(
                         booking);

                        vehicle
                        .setAvailable(false);

                        System.out.println(
                         "Booking successful!");

                    }

                    catch(ParseException e){

                        System.out.println(
                         "Invalid date format.");
                    }

                    catch(
                     InvalidBookingException e){

                        System.out.println(
                         "Booking failed: " +
                         e.getMessage());
                    }

                    break;

                case 5:

                    admin.viewAllBookings();

                    break;

                case 6:

                    System.out.println(
                     "Exiting...");

                    scanner.close();

                    return;

                default:

                    System.out.println(
                     "Invalid choice.");
            }
        }
    }
}
