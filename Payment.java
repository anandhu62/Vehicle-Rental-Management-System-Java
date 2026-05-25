import java.io.Serializable;

public class Payment implements Serializable {

    private String paymentId;
    private Booking booking;
    private double amount;
    private boolean isPaid;

    public Payment(String paymentId,
                   Booking booking) {

        this.paymentId = paymentId;
        this.booking = booking;

        this.amount =
            booking.getTotalCost();

        this.isPaid = false;
    }

    public void processPayment() {

        this.isPaid = true;

        System.out.println(
            "Payment of " +
            amount +
            " processed successfully."
        );
    }

    @Override
    public String toString() {

        return "Payment ID: " +
                paymentId +
                ", Amount: " +
                amount +
                ", Paid: " +
                isPaid;
    }
}
