package inheritance;

public class Mail {
    private double weight;
    private String returnAddress;
    private String destAddress;
    private double estDaysToDelivery;
    private String deliveryInstructions;
    public Mail(double weight, String returnAddress, String destAddress, double estDaysToDelivery, String deliveryInstructions) {
        this.weight = weight;
        this.returnAddress = returnAddress;
        this.destAddress = destAddress;
        this.estDaysToDelivery = estDaysToDelivery;
        this.deliveryInstructions = deliveryInstructions;
    }

    public void updateDelivery(String newInstructions) {
        deliveryInstructions = newInstructions;
    }
    public String checkInstructions() {
        return deliveryInstructions;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public void setEstDaysToDelivery(double estDaysToDelivery) {
        this.estDaysToDelivery = estDaysToDelivery;
    }

    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public double getEstDaysToDelivery() {
        return estDaysToDelivery;
    }

    public String getDestAddress() {
        return destAddress;
    }

    public double getWeight() {
        return weight;
    }
}
