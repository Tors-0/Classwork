package inheritance;

public class Envelope extends Mail {
    public Envelope(double weight, String returnAddress, String destAddress, double estDaysToDelivery, String deliveryInstructions) {
        super(weight, returnAddress, destAddress, estDaysToDelivery, deliveryInstructions);
    }
}
