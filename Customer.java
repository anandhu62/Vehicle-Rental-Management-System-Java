import java.io.Serializable;

public class Customer implements Serializable {

    private String customerId;
    private String name;
    private String contactNumber;

    public Customer(String customerId,
                    String name,
                    String contactNumber) {

        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return "Customer ID: " +
                customerId +
                ", Name: " +
                name +
                ", Contact: " +
                contactNumber;
    }
}
