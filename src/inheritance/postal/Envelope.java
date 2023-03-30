package inheritance.postal;

public class Envelope extends Mail {
    public Envelope(double weight, String returnAddress, String destAddress, double estDaysToDelivery, String deliveryInstructions) {
        super(weight, returnAddress, destAddress, estDaysToDelivery, deliveryInstructions);
    }
    @Override
    public void updateDelivery(String instructions) { // override for updateDelivery method
        System.out.println("Envelopes don't support delivery instructions, they are left in the mailbox.");
    }
    public void updateMailDelivery(String instructions) { // use of super keyword to call overridden method
        super.updateDelivery(instructions);
    }
}
