package inheritance;

public class Package extends Mail {
    private double volume;

    public Package(double weight, String returnAddress, String destAddress, double estDaysToDelivery, String deliveryInstructions, double volume) {
        super(weight, returnAddress, destAddress, estDaysToDelivery, deliveryInstructions);
        this.volume = volume;
    }


}
