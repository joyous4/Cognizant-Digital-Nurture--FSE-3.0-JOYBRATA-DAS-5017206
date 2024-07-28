public class ProxTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // The image will be loaded from the remote server the first time it's displayed
        image1.display();
        System.out.println();
        // The image will not be loaded from the remote server this time, it's cached
        image1.display();
        System.out.println();
        // Load another image
        image2.display();
        System.out.println();
        // Cached image, no remote server load
        image2.display();
    }
}