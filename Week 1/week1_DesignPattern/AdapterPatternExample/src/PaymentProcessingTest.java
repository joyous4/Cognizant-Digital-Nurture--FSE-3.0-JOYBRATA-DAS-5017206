public class PaymentProcessingTest {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor GpayProcessor = new GpayAdapter(new Gpay());
        
        double amount1 = 100.00;
        double amount2 = 200.00;
        double amount3 = 300.00;
        
        paypalProcessor.processPayment(amount1);
        stripeProcessor.processPayment(amount2);
        GpayProcessor.processPayment(amount3);
    }
}