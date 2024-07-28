public class concretePdfDocument implements PdfDocument {

    @Override
    public void open() {
        System.out.println("Opening pdf document");
    }

    @Override
    public void close() {
        System.out.println("Closing pdf document");
    }

}
