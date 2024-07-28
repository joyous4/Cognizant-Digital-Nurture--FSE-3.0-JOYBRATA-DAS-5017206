public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(150.50);

        stockMarket.removeObserver(mobileApp1);

        stockMarket.setStockPrice(200.75);
    }
}
