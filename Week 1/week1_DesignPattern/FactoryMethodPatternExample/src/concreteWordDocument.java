public class concreteWordDocument implements WordDocument {

    @Override
    public void open() {
        System.out.println("Opening word document");
    }

    @Override
    public void close() {
        System.out.println("closing word document");
    }

}
