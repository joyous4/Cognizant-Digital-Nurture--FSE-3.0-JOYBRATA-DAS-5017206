public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment("1234567890123456", "123", "12/24"));
        paymentContext.pay(100);

        paymentContext.setPaymentStrategy(new PayPalPayment("CognizantAdmin@example.com", "password123"));
        paymentContext.pay(200);
    }
}