public class GpayAdapter implements PaymentProcessor {
    private Gpay cash;
    
    public GpayAdapter(Gpay cash) {
        this.cash = cash;
    }
    
    @Override
    public void processPayment(double amount) {
        cash.doPayment(amount);
    }
}